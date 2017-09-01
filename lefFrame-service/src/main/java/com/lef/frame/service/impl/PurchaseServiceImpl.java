package com.lef.frame.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.lef.frame.api.PurchaseService;
import com.lef.frame.api.request.PurchaseRequest;
import com.lef.frame.api.result.PaymentResult;
import com.lef.frame.common.emuns.OrderStatusEmun;
import com.lef.frame.common.emuns.PayTypeEmun;
import com.lef.frame.common.emuns.ResultCodeEmun;
import com.lef.frame.common.exception.FrameException;
import com.lef.frame.core.service.asynnotice.PurchaseNotify;
import com.lef.frame.core.sevice.AsynNoticeService;
import com.lef.frame.core.sevice.OrderService;
import com.lef.frame.dal.entity.OrderInfo;
import com.lef.frame.dal.entity.PaymentInfo;
import com.lef.frame.service.validator.PurchaseValidator;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	OrderService orderService;
	@Autowired
	PurchaseValidator purchaseValidator;
	@Autowired
	ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@Autowired
	AsynNoticeService asynNoticeService;
	@Autowired
	PurchaseNotify purchaseNotify;

	@Override
	public PaymentResult purchase(PurchaseRequest request) {
		PaymentResult result = new PaymentResult(ResultCodeEmun.SUCCESS,request.getRequestNo());
		try {
			purchaseValidator.validate(request);
			if (request.isSyn()) // 同步处理
			{
				result = orderService.purchase(bindOrder(request), bindPayment(request));
				result.setRequestNo(request.getRequestNo());
			}
			else { // 异步处理
				asynProcess(request);
			}
		} catch (FrameException frameException) {
			result.setCode(frameException.getCode());
			result.setMsg(frameException.getMessage());
		} catch (Exception ex) {
			result.setCode(ResultCodeEmun.UNKNOWN_EXCEPTION.getCode());
			result.setMsg(ResultCodeEmun.UNKNOWN_EXCEPTION.getDesc() + ex.getMessage());
		}
		return result;
	}

	private OrderInfo bindOrder(PurchaseRequest request) {
		OrderInfo order = new OrderInfo();
		order.setCustomerId(request.getCustomerId());
		order.setOrderAmount(request.getOrderAmount());
		order.setStatus(OrderStatusEmun.INIT.getCode());
		return order;
	}

	private PaymentInfo bindPayment(PurchaseRequest request) {
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setPayAmount(request.getOrderAmount());
		paymentInfo.setPayType(PayTypeEmun.PURCHASE.getCode());
		return paymentInfo;
	}

	private void asynProcess(final PurchaseRequest request) {
		//将异步操作保存到数据库
		asynNoticeService.create(request);
		threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				PaymentResult result = new PaymentResult(ResultCodeEmun.SUCCESS,request.getRequestNo());
				try {
					result = orderService.purchase(bindOrder(request), bindPayment(request));
					result.setRequestNo(request.getRequestNo());
				} catch (FrameException frameException) {
					result.setCode(frameException.getCode());
					result.setMsg(frameException.getMessage());
				} catch (Exception ex) {
					result.setCode(ResultCodeEmun.UNKNOWN_EXCEPTION.getCode());
					result.setMsg(ResultCodeEmun.UNKNOWN_EXCEPTION.getDesc() + ex.getMessage());
				}
				purchaseNotify.sendNotify(result, request.getRequestNo());
			}
		});
	}

}
