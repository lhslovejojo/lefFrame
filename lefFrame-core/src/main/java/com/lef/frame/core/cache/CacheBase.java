package com.lef.frame.core.cache;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
/**
 * 缓存抽象父类  使用guva
 * @author lihongsong
 *
 * @param <T>
 * @param <R>
 */
public abstract class CacheBase<T, R> {

  private static final Logger logger = LoggerFactory.getLogger(CacheBase.class);

  private LoadingCache<T, R> guvaCache = CacheBuilder.newBuilder().maximumSize(1000)
      .expireAfterWrite(180, TimeUnit.MINUTES).refreshAfterWrite(1, TimeUnit.MINUTES).build(new CacheLoader<T, R>() {
        public R load(T key) throws Exception {
          R rule = queryFromDal(key);
          return rule;
        }
      });

  public R getByKey(T key) {
    R obj = null;
    try {
      obj = guvaCache.get(key);

    } catch (Exception e) {
      obj = queryFromDal(key);
      if (obj != null) {
        guvaCache.put(key, obj);
      } else {
        logger.info("cache error:" + key + " cannot find value");
      }
    }
    return obj;

  }

  protected abstract R queryFromDal(T key);

}
