package com.stevezchao.carDistributionSystem.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(com.stevezchao.carDistributionSystem.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return joinPoint.proceed();
    }

    @Before("execution(* com.stevezchao.carDistributionSystem..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method execution started: {}", joinPoint.getSignature());
    }

    @After("execution(* com.stevezchao.carDistributionSystem..*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Method execution completed: {}", joinPoint.getSignature());
    }
}