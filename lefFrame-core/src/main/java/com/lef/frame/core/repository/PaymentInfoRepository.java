package com.lef.frame.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lef.frame.dal.entity.PaymentInfo;
import com.lef.frame.dal.mappers.PaymentInfoMapper;

@Repository
public class PaymentInfoRepository {
	@Autowired
	PaymentInfoMapper paymentInfoMapper;

	public int insert(PaymentInfo paymentInfo) {
		return paymentInfoMapper.insert(paymentInfo);
	}

}
