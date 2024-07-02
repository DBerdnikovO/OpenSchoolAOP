package ru.berdnikov.openschoolaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @author danilaberdnikov on AsyncRunnerAspect.
 * @project OpenSchoolAOP
 */
@Component
@Aspect
@Slf4j
public class AsyncRunnerAspect {

    @Pointcut("execution(@ru.berdnikov.openschoolaop.annotation.Asynchronously public void add*(..)) ")
    public void asyncRunnerPointcut() {}

    @Around("asyncRunnerPointcut()")
    public Object asyncRunner(ProceedingJoinPoint joinPoint) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Async launch in AsyncRunnerAspect");
                joinPoint.proceed();
            } catch (Throwable e) {
                log.error("Error AsyncRunnerAspect", e);
            }
        });
    }
}
