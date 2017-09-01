package com.lef.frame.api.result;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lef.frame.common.emuns.ResultCodeEmun;
import com.lef.frame.common.utils.StringUtil;

/**
 * 返回结果父类
 * 
 * @author lihongsong
 *
 */
public abstract class ResultBase implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;
	/** */
	private static final int msgLength = 50;
	/**
	 * 返回码
	 */
	private String code;
	/**
	 * 返回描述
	 */
	private String msg;
	/**
	 * 来自原请求的requestNo;
	 */
	private String requestNo;

	public ResultBase() {
	}
	public ResultBase(String code, String message,String requestNo) {
		this.code = code;
		this.msg = StringUtil.left(message,msgLength);
		this.requestNo=requestNo;
	}
	public ResultBase(ResultCodeEmun resultCode) {
		this.code = resultCode.getCode();
		this.msg = StringUtil.left(resultCode.getDesc(),msgLength);
	}

	public ResultBase(ResultCodeEmun resultCode,String requestNo) {
		this.code = resultCode.getCode();
		this.msg = StringUtil.left(resultCode.getDesc(),msgLength);
		this.requestNo=requestNo;
	}

	public ResultBase(ResultCodeEmun resultCode, String message,String requestNo) {
		this.code = resultCode.getCode();
		this.msg =  StringUtil.left(message,msgLength);
		this.requestNo=requestNo;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = StringUtil.left(msg,msgLength);
	}
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
}
