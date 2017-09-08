package com.lef.frame.core.service.asynnotice;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.lef.frame.api.result.ResultBase;
import com.lef.frame.common.emuns.SendStatusEmun;
import com.lef.frame.core.sevice.AsynNoticeService;
/**
 * 子类必须实现send方法，具体的调用对方接口
 * @author lihongsong
 *
 * @param <T>
 */
public abstract class NotifyBaseService<T extends ResultBase> {
	@Autowired
	AsynNoticeService asynNoticeService;

	public void sendNotify(T t, String requestNo) {
		try {
			String contentJson = JSON.toJSONString(t);
			asynNoticeService.updateContent(requestNo,contentJson);
			asynNoticeService.changeSendStatus(requestNo, SendStatusEmun.SENDING);
			if (send(t)) {
				asynNoticeService.changeSendStatus(requestNo, SendStatusEmun.SUCCESS);
			} else
				asynNoticeService.changeSendStatus(requestNo, SendStatusEmun.FAIL);
		} catch (Exception ex) {
			asynNoticeService.changeSendStatus(requestNo, SendStatusEmun.FAIL);
		}
	}
    
	// 具体子类必须重写此方法
	protected abstract boolean send(T t);
}
