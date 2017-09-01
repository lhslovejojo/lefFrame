package com.lef.frame.core.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lef.frame.common.emuns.SendStatusEmun;
import com.lef.frame.dal.entity.AsynNoticeInfo;
import com.lef.frame.dal.mappers.AsynNoticeInfoMapper;

@Repository
public class AsynNoticeInfoRepository {
	@Autowired
	AsynNoticeInfoMapper asynNoticeInfoMapper;

	public int insert(AsynNoticeInfo asynNoticeInfo) {
		asynNoticeInfo.setSendStatus(SendStatusEmun.INIT.getCode());
		asynNoticeInfo.setCreateTime(new Date());
		return asynNoticeInfoMapper.insert(asynNoticeInfo);
	}
	public  AsynNoticeInfo selectByBizNo(String bizNo)
	{
		return asynNoticeInfoMapper.selectByBizNo(bizNo);
	}
	public  int update(AsynNoticeInfo asynNoticeInfo)
	{
		return asynNoticeInfoMapper.updateByPrimaryKey(asynNoticeInfo);
	}

}
