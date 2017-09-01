package com.lef.frame.core.sevice;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lef.frame.api.request.RequestBase;
import com.lef.frame.api.result.ResultBase;
import com.lef.frame.common.emuns.SendStatusEmun;
import com.lef.frame.core.repository.AsynNoticeInfoRepository;
import com.lef.frame.dal.entity.AsynNoticeInfo;

@Service
public class AsynNoticeService {
	@Autowired
	AsynNoticeInfoRepository asynNoticeInfoRepository;

	private static final Logger logger = LoggerFactory.getLogger(AsynNoticeService.class);

	public void create(RequestBase request) {
		AsynNoticeInfo asynNoticeInfo = new AsynNoticeInfo();
		asynNoticeInfo.setBizNo(request.getRequestNo());
		asynNoticeInfoRepository.insert(asynNoticeInfo);
	}

	public void changeSendStatus(String bizNo, SendStatusEmun status) {
		AsynNoticeInfo asynNoticeInfo = asynNoticeInfoRepository.selectByBizNo(bizNo);
		if (status == SendStatusEmun.SENDING)
			asynNoticeInfo.setSendTime(new Date());
		asynNoticeInfo.setSendStatus(status.getCode());
		asynNoticeInfoRepository.update(asynNoticeInfo);
	}
}
