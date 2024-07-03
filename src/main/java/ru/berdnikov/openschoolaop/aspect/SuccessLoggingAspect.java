package ru.berdnikov.openschoolaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author danilaberdnikov on SuccessLoggingAspect.
 * @project OpenSchoolAOP
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class SuccessLoggingAspect {
    @Pointcut("within(ru.berdnikov.openschoolaop.controller.*) && @within(ru.berdnikov.openschoolaop.annotation.SuccessLogging)")
    public void message() {
    }

    @AfterReturning(pointcut = "message()", returning = "result")
    public void afterReturningMessage(JoinPoint joinPoint, Object result) {
        log.info("----------------------");
        log.info("Method {} executed successfully with result: {}", joinPoint.getSignature(), result);
        log.info("----------------------");
    }
}
