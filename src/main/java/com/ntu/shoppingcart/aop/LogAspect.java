package com.ntu.shoppingcart.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Spring aop 
 *
 */
@Aspect
@Component
public class LogAspect {

	//只攔截 controller的method
	@Pointcut("execution(* com.ntu.shoppingcart.controller..*(..))")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		String URI = request.getRequestURI().substring(request.getContextPath().length());
		String methodName = joinPoint.getSignature().getName();

		logger.info("started : URI = {}, Method = {} ", URI, methodName);
	}

	@After("pointcut()")
	public void after(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		String URI = request.getRequestURI().substring(request.getContextPath().length());
		String methodName = joinPoint.getSignature().getName();

		logger.info("finished :  URI = {}, Method = {} ", URI, methodName);

	}
}
