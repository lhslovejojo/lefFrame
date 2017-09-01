package com.lef.frame.dal.entity;

import java.math.BigDecimal;

public class OrderInfo extends BaseEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_INFO.ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_INFO.CUSTOMER_ID
     *
     * @mbggenerated
     */
    private String customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_INFO.ORDER_AMOUNT
     *
     * @mbggenerated
     */
    private BigDecimal orderAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_INFO.STATUS
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_INFO.ID
     *
     * @return the value of ORDER_INFO.ID
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_INFO.ID
     *
     * @param id the value for ORDER_INFO.ID
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_INFO.CUSTOMER_ID
     *
     * @return the value of ORDER_INFO.CUSTOMER_ID
     *
     * @mbggenerated
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_INFO.CUSTOMER_ID
     *
     * @param customerId the value for ORDER_INFO.CUSTOMER_ID
     *
     * @mbggenerated
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_INFO.ORDER_AMOUNT
     *
     * @return the value of ORDER_INFO.ORDER_AMOUNT
     *
     * @mbggenerated
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_INFO.ORDER_AMOUNT
     *
     * @param orderAmount the value for ORDER_INFO.ORDER_AMOUNT
     *
     * @mbggenerated
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_INFO.STATUS
     *
     * @return the value of ORDER_INFO.STATUS
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_INFO.STATUS
     *
     * @param status the value for ORDER_INFO.STATUS
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}