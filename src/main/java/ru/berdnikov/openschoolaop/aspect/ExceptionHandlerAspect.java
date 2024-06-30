package ru.berdnikov.openschoolaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author danilaberdnikov on ExceptionHandlerAspect.
 * @project OpenSchoolAOP
 */
@Slf4j
@Aspect
@Component
public class ExceptionHandlerAspect {
    @AfterThrowing(pointcut = "execution(* * (..) throws @ru.berdnikov.openschoolaop.annotation.Throw *)", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
//        log.info("Произошла ошибка при вызове метода: {}", joinPoint.getSignature().toShortString());
//        log.info("Ошибку: {}", exception.getMessage());
    }
}
