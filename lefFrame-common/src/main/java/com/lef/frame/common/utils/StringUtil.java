package com.lef.frame.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类，尽可能不依赖第三方包
 * 
 * @author lihongsong
 *
 */
public class StringUtil extends StringUtils{
	/**
	 * 取出字符串中的第一组数字
	 *
	 * @param s
	 * @return
	 */
	public static String numberMatch(String s) {
		if (s == null) {
			return null;
		}
		Pattern p = Pattern.compile("[0-9\\.]+");
		Matcher m = p.matcher(s);
		if (m.find()) {
			return m.group();
		}
		return null;
	}

	/**
	 * 判读是否是空字符串
	 * 
	 * @param s
	 * @return 为空 返回 TRUE ,非空返回false
	 */
	public static boolean isBlack(String s) {
		if (s == null || "".equals(s.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 判读是否非空
	 * 
	 * @param s
	 * @return 为空 返回 FALSE ,非空返回TRUE
	 */
	public static boolean isNotBlack(String s) {
		return !isBlack(s);
	}
}
