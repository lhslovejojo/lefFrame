package com.lef.frame.core.service.asynnotice;

import org.springframework.stereotype.Service;

import com.lef.frame.api.result.PaymentResult;
/**
 * 消费异步通知调用方
 * @author lihongsong
 *
 */
@Service
public class PurchaseNotify extends NotifyBaseService<PaymentResult> {
    /**
     * 具体实现方法，省略
     */
	@Override
	protected boolean send(PaymentResult t) {
		// TODO Auto-generated method stub
		return true;
	}

}
