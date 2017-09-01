package com.lef.frame.common.emuns;

import java.io.Serializable;

import static com.lef.frame.common.utils.StringUtil.*;


/**
 * 订单状态
 * @author lihongsong
 *
 */
public enum SendStatusEmun implements Serializable {

    INIT("INIT", "待发送"),
    SENDING("SENDING", "发送中"),
    SUCCESS("SUC", "发送成功"),
	FAIL("FAIL", "发送失败");

   
    private final String code;
    private final String desc;

    private SendStatusEmun(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SendStatusEmun getByCode(String code) {
        if (isBlack(code)) {
            return null;
        }

        for (SendStatusEmun item : SendStatusEmun.values()) {
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
