/*
 * wangyin.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.lef.frame.api.dto;

import java.io.Serializable;

public class OrderDTO implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;

	private Long id;
	// 记账协议模板编码
	private String customerId;
	// 记账协议子条目编码
	private Long orderAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}

}
