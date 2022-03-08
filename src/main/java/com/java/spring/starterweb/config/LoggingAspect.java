package com.java.spring.starterweb.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Around("execution(* com.java.spring.starterweb.controller2.HomeController2.*(..)) " +
            "|| execution(* com.java.spring.starterweb.controller.HomeController.*(..))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getPackageName()+"."+methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        //Measure method execution time
        final Instant start = Instant.now();
        Object result = proceedingJoinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish). toMillis();

        //Log method execution time
        LOGGER.info("1-Execution time of " + className + "." + methodName + " :: " + timeElapsed + " ms");

        return result;
    }

}
