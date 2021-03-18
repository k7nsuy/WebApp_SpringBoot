package com.example.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class LogAspect {
	
	//System.out.println() 출력
	Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	//모든 컨트롤러와 모든 mapper에 대해서 실행함.
	//크롬에서 주소창에 127.0.0.1:9092/ROOT/member/login => 돌아가는 과정을 지켜봄
	@Around("execution(* com.example.controller.*Controller.*(..)) or execution(* com.example.mapper.*Mapper.*(..))" )
	public Object printLog(ProceedingJoinPoint joinpoint) throws Throwable {
		
		String className = joinpoint.getSignature().getDeclaringTypeName();
		String methodName = joinpoint.getSignature().getName();
		
		logger.info("컨트롤러는 " + className + ", 메서드는 " + methodName + " 입니다.");		
		
		return joinpoint.proceed();
	}
	
	@Around("execution(* com.example.controller.MemberController.*(..))" )
	public Object sessionLog(ProceedingJoinPoint joinPoint) throws Throwable {
		//request객체 가져오기
		HttpServletRequest request
		= ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes()).getRequest();
		
		//session 객체 가져오기
		HttpSession httpSession = request.getSession();
		//이전 페이지에 대한 url정보 출력
		//127.0.0.1:9092/ROOT/member/main?user=x
		logger.info(request.getServletPath()); //member/main
		logger.info(request.getQueryString()); //user=x
		
		String path = request.getServletPath();
		String query = request.getQueryString();
		
		// 로그인 후 이전 페이지로 돌아가야 되기 때문에 로그인 로그아웃 페이지는 url에서 뻬야한다.
		
		if(!path.startsWith("/member/login")
				|| !path.startsWith("/member/logout")) {
			
			if(query == null) {
				httpSession.setAttribute("CURRENT_URL", path);
			}
			
			else {
				httpSession.setAttribute("CURRENT_URL", path + "?" + query);
			}
		
			logger.info(httpSession.getAttribute("CURRENT_URL") + "");
		}
		
		return joinPoint.proceed();
	}
}
