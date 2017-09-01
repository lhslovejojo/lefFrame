package com.lef.frame.api.request;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 消费请求对象
 * @author lihongsong
 *
 */
public class PurchaseRequest extends RequestBase implements Serializable {
  /** */
  private static final long serialVersionUID = 1L;
  /** 会员ID */
  private String customerId;
  /** 消费金额*/
  private BigDecimal orderAmount;

  public PurchaseRequest(String clientCode) {
    super(clientCode);
  }

  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

public String getCustomerId() {
	return customerId;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}

public BigDecimal getOrderAmount() {
	return orderAmount;
}

public void setOrderAmount(BigDecimal orderAmount) {
	this.orderAmount = orderAmount;
}

}
