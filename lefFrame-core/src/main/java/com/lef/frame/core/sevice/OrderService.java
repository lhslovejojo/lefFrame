package com.lef.frame.core.sevice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

import com.lef.frame.api.dto.OrderDTO;
import com.lef.frame.api.result.PaymentResult;
import com.lef.frame.common.emuns.ResultCodeEmun;
import com.lef.frame.common.exception.FrameException;
import com.lef.frame.core.repository.OrderInfoRepository;
import com.lef.frame.core.repository.PaymentInfoRepository;
import com.lef.frame.core.utils.BeanCopyUtil;
import com.lef.frame.dal.entity.OrderInfo;
import com.lef.frame.dal.entity.PaymentInfo;

@Service
public class OrderService extends BaseTransactionService {
	@Autowired
	OrderInfoRepository orderInfoRepository;
	@Autowired
	PaymentInfoRepository paymentInfoRepository;
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	public PaymentResult purchase(final OrderInfo order, final PaymentInfo paymentInfo) {
		final PaymentResult result = new PaymentResult(ResultCodeEmun.SUCCESS);

		this.getDataSourceTransactionManager().execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					orderInfoRepository.insert(order);
					paymentInfo.setOrderId(order.getId());
					paymentInfoRepository.insert(paymentInfo);
					OrderDTO orderDTO = BeanCopyUtil.cvtDozer(order, OrderDTO.class);
					result.setOrder(orderDTO);
				} catch (Exception e) {
					status.setRollbackOnly();
					logger.error("消费创建订单失败" + e.getMessage(), e);
					result.setCode(ResultCodeEmun.UNKNOWN_EXCEPTION.getDesc());
					result.setMsg("消费创建订单失败" + e.getMessage());
					throw new FrameException(ResultCodeEmun.DB_INSERT_ERROR, e);
				}

			}

		});
		return result;

	}
}
