package com.nhnacademy.exam.aspect;

import com.nhnacademy.exam.config.MainConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StopWatch;

@Aspect
public class LoggerAspect {
    private static final Log log = LogFactory.getLog(MainConfiguration.class);

    @Around("execution(public * * (..)) && !target(com.nhnacademy.exam.config.MainConfiguration)")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            long timeMillis = stopWatch.getTotalTimeMillis();
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            String methodName = methodSignature.getMethod().getName();

            log.info("실행 메서드: " + methodName + ", 실행시간 : " + timeMillis + "ms");
        }
    }
}