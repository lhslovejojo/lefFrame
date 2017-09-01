package com.lef.frame.api;

import com.lef.frame.api.request.PurchaseRequest;
import com.lef.frame.api.result.PaymentResult;

/**
 * 购物消费接口
 * 
 * @author lihongsong
 *
 */
public interface PurchaseService {
	/**
	 * 购物消费接口
	 * 
	 * @param request
	 * @return
	 */
	public PaymentResult purchase(PurchaseRequest request);
}
