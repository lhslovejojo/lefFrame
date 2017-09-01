package com.lef.frame.api.result;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lef.frame.api.dto.OrderDTO;
import com.lef.frame.common.emuns.ResultCodeEmun;

/**
 * 返回消费结果
 * 
 * @author lihongsong
 *
 */
public class PaymentResult extends ResultBase implements Serializable {
	/**
	 * 返回订单
	 */
	private OrderDTO order;

	private static final long serialVersionUID = 1L;

	public PaymentResult() {
	}

	public PaymentResult(ResultCodeEmun resultCode) {
		super(resultCode);
	}

	public PaymentResult(ResultCodeEmun resultCode, String requestNo) {
		super(resultCode, requestNo);
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
