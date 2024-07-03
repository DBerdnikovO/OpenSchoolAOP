package ru.berdnikov.openschoolaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.berdnikov.openschoolaop.exception.ObjectNullException;

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
        if (result == null) {
            throw new ObjectNullException("Method" + joinPoint.getSignature() + " return null");
        } else {
            log.info("----------------------");
            log.info("Method {} executed successfully with result: {}", joinPoint.getSignature(), result);
            log.info("----------------------");
        }
    }
}
