package com.lef.frame.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lef.frame.common.emuns.OrderStatusEmun;
import com.lef.frame.dal.entity.OrderInfo;
import com.lef.frame.dal.mappers.OrderInfoMapper;

@Repository
public class OrderInfoRepository {
	@Autowired
	OrderInfoMapper orderInfoMapper;

	public int insert(OrderInfo order) {
		order.setStatus(OrderStatusEmun.INIT.getCode());
		return orderInfoMapper.insert(order);
	}

}
