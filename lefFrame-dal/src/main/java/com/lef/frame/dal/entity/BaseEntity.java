/*
 * wangyin.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.lef.frame.dal.entity;

import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;

/**
 * 基础entity ,用于共用的方法和属性
 * @author lihongsong
 *
 */
public  abstract class BaseEntity implements Serializable {
  private static final long serialVersionUID = 741231858441822688L;

  /**
   * @return
   *
   * @see java.lang.Object#toString()
   */
  public String toString() {
    try {
      Map<?, ?> props = BeanUtils.describe(this);
      Iterator<?> iProps = props.keySet().iterator();
      StringBuffer retBuffer = new StringBuffer();

      while (iProps.hasNext()) {
        String key = (String) iProps.next();

        // skip false property "class"
        if ("class".equals(key)) {
          continue;
        }

        retBuffer.append(key).append("=[").append(props.get(key)).append("]");

        if (iProps.hasNext()) {
          retBuffer.append(", ");
        }
      }

      return retBuffer.toString();
    } catch (Exception e) {
      return super.toString();
    }
  }
}
