package com.lef.frame.common.emuns;

import java.io.Serializable;

import static com.lef.frame.common.utils.StringUtil.*;


/**
 * 订单状态
 * @author lihongsong
 *
 */
public enum OrderStatusEmun implements Serializable {

    INIT("INIT", "初始状态"),
    SUCCESS("SUC", "成功"),
	FAIL("FAIL", "失败"),
	REVOKE("REVOKE", "撤销"),
	Reversal("REVERSAL", "冲正");

   
    private final String code;
    private final String desc;

    private OrderStatusEmun(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static OrderStatusEmun getByCode(String code) {
        if (isBlack(code)) {
            return null;
        }

        for (OrderStatusEmun item : OrderStatusEmun.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
