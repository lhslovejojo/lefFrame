package com.lef.frame.common.emuns;

import java.io.Serializable;

import static com.lef.frame.common.utils.StringUtil.*;


/**
 * 返回码
 * @author lihongsong
 *
 */
public enum ResultCodeEmun implements Serializable {

    SUCCESS("00000", "成功"),
    ING("11111", "处理中"),

    INVALID_REQUEST("ACC3010001", "请求校验失败"),

    DUP_REQ_ORIG_SUC("ACC3010002", "重复请求，原记账请求已成功"),
    DUP_REVERSAL("ACC3010003", "原请求单已被冲正"),
    NO_REVERSAL("ACC3010005", "无冲正原单"),
    DUP_REQ_INTERNAL("ACC3010004", "入库失败，违反唯一性约束，内部使用"),
    ACCOUNT_NOT_ORIG("ACC3010006", "原请求单不存在"),
    DB_INSERT_ERROR("ACC3010007", "数据库插入失败"),
    DUP_REQ("ACC3010008", "重复请求"),
    UNIMPLEMENTED_REQUEST_TYPE("ACC3010009", "无效请求类型"),
    DUP_REQ_ORIG_FAIL("ACC3010010", "重复请求，原记账请求已失败"),
    NO_PERMISSION("ACC3010011", "无访问权限"),
    DB_UPDATE_ERROR("ACC3010012","数据库更新失败"),
    DUP_REQ_ORIG_ING("ACC3010013", "重复请求，原记账请求处理中"),

    MISS_AGREEMENT("ACC3020001", "未找到对应的账户支付协议"),
    AGREEMENT_NOT_FULL_MATCH("ACC3020002", "账务协议匹配失败，请检查记账规则和请求的匹配情况"),
    PRICING_FAILED("ACC3020003", "默认协议条目金额计算失败"),
    DEFAULT_ACCOUNT_MAPPING_FAILED("ACC3020004", "获取默认账户失败"),

    BORROWING_IMBALANCE("ACC3030001", "请求借贷不平衡"),
    ACCOUNT_NOT_FUND("ACC3030002", "未找到指定的账户"),
    ACCOUNT_FROZEN("ACC3030003", "账户冻结"),
    ACCOUNT_FROZEN_IN("ACC3030004", "账户冻结止入"),
    ACCOUNT_FROZEN_OUT("ACC3030005", "账户冻结止出"),
    ACCOUNT_STATUS_INVALID("ACC3030006", "账户注销"),
    ACCOUNT_NOT_ENOUGH_MONEY("ACC3030007", "账户操作金额不足"),
    INVALID_AMOUNT_SECTION("ACC3030008", "无效的资金部分类别"),
    ACCOUNT_STATUS_EXCEPTION("ACC3030009", "账户金额成分异常"),
    PERSON_ACCOUNT_NOT_ENOUGH_MONEY("ACC3030010", "个人账户操作金额不足"),


    ACCOUNT_UPDATE_MONEY_ERROR("ACC3040001", "账户更新余额出错"),

    DUP_REQ_COUNT_NOT_MATCH("ACC3050001", "重复请求且步骤条目不一致"),

    ACCOUNT_QUERY_SIZE_BIG("ACC3060001", "交易查询列表过大"),
    ACCOUNT_FUND_QUERY_PARAM_ERROR("ACC3060002", "交易查询参数有误"),
    ACCOUNT_NO_REQUEST("ACC3060003", "未查询到待查询的请求"),


    //3090-3099 预留给man使用
    ACCOUNT_CREATE_4_BATCH("ACC3090001", "存量账户待跑批"),

    ACCOUNT_CREATE_MIGRATE_NO_MATCH("ACC3090002", "老账户与新账户不匹配"),

    //Channel and Customer mapping

    CHANNEL_CUSTOMER_EXIST("ACC4030001", "渠道映射关系已存在"),
    BUFFER_EXIST("ACC4030002", "缓冲记录已存在"),

    BUFFER_NOT_FIND("ACC4030003", "未找到对应的缓冲记录"),

    MESSAGE_FAILED("89999", "消息发送失败"),

    NO_DATA("99998", "无数据"),

    UNKNOWN_EXCEPTION("99999", "未知系统异常");

    private final String code;
    private final String desc;

    private ResultCodeEmun(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEmun getByCode(String code) {
        if (isBlack(code)) {
            return null;
        }

        for (ResultCodeEmun item : ResultCodeEmun.values()) {
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
