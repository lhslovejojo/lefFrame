package com.lef.frame.dal.entity;

import java.math.BigDecimal;

public class PaymentInfo  extends BaseEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PAYMENT_INFO.ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PAYMENT_INFO.ORDER_ID
     *
     * @mbggenerated
     */
    private Long orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PAYMENT_INFO.PAY_TYPE
     *
     * @mbggenerated
     */
    private String payType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PAYMENT_INFO.PAY_AMOUNT
     *
     * @mbggenerated
     */
    private BigDecimal payAmount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PAYMENT_INFO.ID
     *
     * @return the value of PAYMENT_INFO.ID
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PAYMENT_INFO.ID
     *
     * @param id the value for PAYMENT_INFO.ID
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PAYMENT_INFO.ORDER_ID
     *
     * @return the value of PAYMENT_INFO.ORDER_ID
     *
     * @mbggenerated
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PAYMENT_INFO.ORDER_ID
     *
     * @param orderId the value for PAYMENT_INFO.ORDER_ID
     *
     * @mbggenerated
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PAYMENT_INFO.PAY_TYPE
     *
     * @return the value of PAYMENT_INFO.PAY_TYPE
     *
     * @mbggenerated
     */
    public String getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PAYMENT_INFO.PAY_TYPE
     *
     * @param payType the value for PAYMENT_INFO.PAY_TYPE
     *
     * @mbggenerated
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PAYMENT_INFO.PAY_AMOUNT
     *
     * @return the value of PAYMENT_INFO.PAY_AMOUNT
     *
     * @mbggenerated
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PAYMENT_INFO.PAY_AMOUNT
     *
     * @param payAmount the value for PAYMENT_INFO.PAY_AMOUNT
     *
     * @mbggenerated
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }
}