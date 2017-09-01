package com.lef.frame.service.validator;

import static com.lef.frame.service.utils.ValidatorUtil.isBlack;
import static com.lef.frame.service.utils.ValidatorUtil.isNull;

import org.springframework.stereotype.Component;

import com.lef.frame.api.request.PurchaseRequest;
import com.lef.frame.common.emuns.ResultCodeEmun;

/**
 * @author liuchuan
 * @since 2016-12-28 12:00
 */
@Component
public class PurchaseValidator extends ValidatorBase<PurchaseRequest> {

	@Override
	protected void validateInternal(PurchaseRequest request) {
		// TODO Auto-generated method stub
		isBlack(request.getCustomerId(), ResultCodeEmun.INVALID_REQUEST, "会员编码ID为空");
		isNull(request.getOrderAmount(), ResultCodeEmun.INVALID_REQUEST, "消费金额不能为空");
	}
}
