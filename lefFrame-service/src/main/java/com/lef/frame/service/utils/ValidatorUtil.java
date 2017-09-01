package com.lef.frame.service.utils;

import com.lef.frame.common.emuns.ResultCodeEmun;
import com.lef.frame.common.exception.FrameException;
import static com.lef.frame.common.utils.StringUtil.*;

/**
 * 校验参数合法工具类
 * @author lihongsong
 *
 */
public class ValidatorUtil {
    public static void isNull(Object obj, ResultCodeEmun resultCode) {
        if (obj == null) {
            throw new FrameException(resultCode);
        }
    }

    public static void isBlack(String value, ResultCodeEmun resultCode) {

        if (isBlank(value)) {
            throw new FrameException(resultCode);
        }
    }

    public static void isFalse(boolean condition, ResultCodeEmun resultCode) {
        if (!condition) {
            throw new FrameException(resultCode);
        }
    }

    public static void isNull(Object obj, ResultCodeEmun resultCode, String message) {
        if (obj == null) {
            throw new FrameException(resultCode, message);
        }
    }

    public static void isNotNumber(String value, ResultCodeEmun resultCode, String message) {

        if (!isNumeric(value)) {
            throw new FrameException(resultCode, message);
        }
    }

    public static void isBlack(String value, ResultCodeEmun resultCode, String message) {

        if (isBlank(value)) {
            throw new FrameException(resultCode, message);
        }
    }

    public static void isFalse(boolean condition, ResultCodeEmun resultCode, String message) {
        if (!condition) {
            throw new FrameException(resultCode, message);
        }
    }
}

