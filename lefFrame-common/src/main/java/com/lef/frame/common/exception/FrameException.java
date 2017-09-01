package com.lef.frame.common.exception;

import com.lef.frame.common.emuns.ResultCodeEmun;

/**
 * 自定义异常Demo
 * 
 * @author lihongsong
 *
 */
public class FrameException extends RuntimeException {
	private String msg;
	private String code;

	public FrameException(ResultCodeEmun resultCode) {
		super(resultCode.getDesc());
		this.msg = resultCode.getDesc();
		this.code = resultCode.getCode();
	}

	public FrameException(ResultCodeEmun resultCode, String message) {
		super(resultCode.getDesc()+message);
		this.msg = resultCode.getDesc()+message;
		this.code = resultCode.getCode();
	}

	public FrameException(ResultCodeEmun resultCode, String message, Throwable cause) {
		super(resultCode.getDesc()+message, cause);
		this.msg = resultCode.getDesc()+message;
		this.code = resultCode.getCode();
	}

	public FrameException(ResultCodeEmun resultCode, Throwable cause) {
		super(resultCode.getDesc(), cause);
		this.msg = resultCode.getDesc();
		this.code = resultCode.getCode();

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
