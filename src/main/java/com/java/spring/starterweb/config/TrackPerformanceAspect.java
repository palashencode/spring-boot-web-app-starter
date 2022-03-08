package com.java.spring.starterweb.config;

import com.java.spring.starterweb.annotations.TrackExecutionTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class TrackPerformanceAspect {
    private static final Logger LOGGER = LogManager.getLogger(TrackPerformanceAspect.class);

    @Around("@annotation(com.java.spring.starterweb.annotations.TrackExecutionTime)")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        TrackExecutionTime trackAnnotation = AnnotationUtils.findAnnotation(methodSignature.getMethod(), TrackExecutionTime.class);

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getPackageName()+"."+methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        //Measure method execution time
        final Instant start = Instant.now();
        Object result = proceedingJoinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish). toMillis();

        //Log method execution time
        LOGGER.info("Track Performance-Execution time of " + className + "." + methodName
                + " :: url=" +trackAnnotation.url()+" name="+trackAnnotation.name()
                + " type="+trackAnnotation.type()+" :: "+ timeElapsed + " ms");

        return result;
    }

}
