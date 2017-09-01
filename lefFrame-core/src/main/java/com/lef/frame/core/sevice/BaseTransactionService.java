package com.lef.frame.core.sevice;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
/**
 * 数据访问抽象层。抽象数据库事务对象的管理。
 * 涉及到编程式事务管理了组件，可以继承该类。
 * @author lihongsong
 *
 */
public abstract class BaseTransactionService {

  @Resource
  private PlatformTransactionManager accountTransactionManager;

  /**
   * 获取事务处理模板对象
   *
   * @return {@link org.springframework.transaction.support.TransactionTemplate}
   *         -事务处理模板对象
   */
  public TransactionTemplate getDataSourceTransactionManager() {
    TransactionTemplate template = new TransactionTemplate(accountTransactionManager);
    template.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
    return template;
  }
}
