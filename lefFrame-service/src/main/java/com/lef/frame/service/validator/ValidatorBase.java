package com.lef.frame.service.validator;

import static com.lef.frame.service.utils.ValidatorUtil.*;

import com.lef.frame.api.request.RequestBase;
import com.lef.frame.common.emuns.ResultCodeEmun;

/**
 * 请求校验器基类
 * @author lihongsong
 *
 * @param <R>
 */
public abstract class ValidatorBase<R extends RequestBase> {

	public void validate(R request) {
		// Todo
		isNull(request, ResultCodeEmun.INVALID_REQUEST, "无效的请求对象");
		isBlack(request.getClientCode(), ResultCodeEmun.INVALID_REQUEST, "无效的客户端编码");
		isNull(request.getRequestTime(), ResultCodeEmun.INVALID_REQUEST, "无效的请求时间");
		this.validateInternal(request);
	}

	/**
	 * 特请请求校验器，集成覆盖该方法，实现特有验证逻辑。
	 *
	 * @param request
	 *            请求对象。
	 */
	protected abstract void validateInternal(R request);
}
