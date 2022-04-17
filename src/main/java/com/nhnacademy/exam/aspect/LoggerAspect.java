package com.nhnacademy.exam.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StopWatch;

/**
 * AOP 로깅을 관리하는 클래스입니다.
 */
@SuppressWarnings("squid:S6212") //var을 사용하라는 경고 무시
@Aspect
public class LoggerAspect {
    private static final Log log = LogFactory.getLog(LoggerAspect.class);

    /**
     * 모든 public method의 실행시간을 측정하는 메소드입니다.
     */
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