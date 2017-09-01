package com.lef.frame.core.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect 
@Component
public class LogInterceptor {
    private final Logger logger = LoggerFactory.getLogger("REQUEST_LOG");  
    
	@Pointcut("execution(public * com.lef.frame.service.impl.*.*(..))") 
    public void logService(){};
    @Before("logService()")
    public void before(JoinPoint joinPoint) { 
    	//打印接受的请求参数
    	logger.info(joinPoint.getArgs()[0].toString());
    } 
    
    @AfterReturning(value="logService()", returning = "rtv") 
    public void afterReturning(JoinPoint joinPoint, Object rtv) throws Throwable { 
    	//打印返回的请求
    	logger.info(rtv.toString());
    } 
}
