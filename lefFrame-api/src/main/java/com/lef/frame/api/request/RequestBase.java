package com.lef.frame.api.request;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 接口请求父类 所有请求的参数，必须带有的属性
 * 
 * @author lihongsong
 *
 */
public abstract class RequestBase implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;
	/**
	 * 调用方编码 建议为每个调用方分配一个编码
	 */
	private String clientCode;
	/**
	 * 请求号，唯一
	 */
	private String requestNo;
	/**
	 * 请求时间
	 */
	private Date requestTime;
	/**
	 * 是否是同步接口 默认为同步;
	 */
	private boolean isSyn=true;
	
	public RequestBase(String clientCode)
	{
		this.clientCode=clientCode;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public boolean isSyn() {
		return isSyn;
	}

	public void setSyn(boolean isSyn) {
		this.isSyn = isSyn;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	
	  public String toString() {
		    return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		  }


}
