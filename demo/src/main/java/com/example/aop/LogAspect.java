package com.example.aop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class LogAspect {
	Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	// ItemController의 메소드가 호출되기 전에
	@Before("execution(* com.example.controller.ItemController.*(..))")
    public void doSomethingBefore() {
		
		long start = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");    
		Date resultdate = new Date(start);
		
		logger.info("AOP Test : Before ======================");
		logger.info(sdf.format(resultdate)+"");
        
    }
	
	@After("execution(* com.example.controller.ItemController.*(..))")
    public void doSomethingAfter() {
		long start = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");    
		Date resultdate = new Date(start);
		
		logger.info(sdf.format(resultdate)+"");
        logger.info("AOP Test : After =======================");
    }
	
	@Around("execution(* com.example.controller.*Controller.*(..)) or execution(* com.example.mapper.*Mapper.*(..))")
	public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
		String type = joinPoint.getSignature().getDeclaringTypeName();
		String name = joinPoint.getSignature().getName();
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		logger.info(request.getServletPath()); //reqeust mapping 주소
		logger.info(request.getQueryString()); //?page=1&...
		Map<String, String[]> paramMap = request.getParameterMap();
		for(String key : paramMap.keySet()) {
			String[] param = paramMap.get(key);
			for(int i=0;i<param.length;i++) {
				logger.info( String.format("%s, %s", key, param[i]));
			}
		}
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("AOP", "AOP세션");
		
		logger.info(type + "," + name);
		return joinPoint.proceed();
	}

}

