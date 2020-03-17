package com.alarq.StudManRESTClient.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.alarq.StudManRESTClient.controller.*.*(..))") 
	private void forControllerPackage() {}
	@Pointcut("execution(* com.alarq.StudManRESTClient.service.*.*(..))") 
	private void forservicePackage() {}
	
	@Pointcut("forControllerPackage() || forservicePackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	private void before(JoinPoint joinPoint)
	{	
		String methodSign = joinPoint.getSignature().toShortString();
		myLogger.info("in @Before method: "+ methodSign);
		Object[] args = joinPoint.getArgs();
		for(Object o: args)
			System.out.println(o);
	}
	
	@AfterReturning(pointcut="forAppFlow()",
							returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result)
	{
		String methodSign = joinPoint.getSignature().toShortString();
		myLogger.info("in @After method: "+ methodSign);
		myLogger.info("result: "+result);
	}

}
