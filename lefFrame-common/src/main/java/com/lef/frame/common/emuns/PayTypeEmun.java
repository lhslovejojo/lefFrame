package com.lef.frame.common.emuns;

import java.io.Serializable;

import static com.lef.frame.common.utils.StringUtil.*;


/**
 * 去银行支付类型，
 * @author lihongsong
 *
 */
public enum PayTypeEmun implements Serializable {
    PURCHASE("PURCHASE", "消费"),
    REFUND("REFUND", "退款"),
	REVOKE("REVOKE", "撤销"),
	Reversal("REVERSAL", "冲正");

   
    private final String code;
    private final String desc;

    private PayTypeEmun(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PayTypeEmun getByCode(String code) {
        if (isBlack(code)) {
            return null;
        }

        for (PayTypeEmun item : PayTypeEmun.values()) {
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
