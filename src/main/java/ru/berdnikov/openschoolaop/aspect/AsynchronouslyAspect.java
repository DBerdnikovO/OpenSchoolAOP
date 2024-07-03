package ru.berdnikov.openschoolaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.berdnikov.openschoolaop.exception.ProceedingJoinPointException;

import java.util.concurrent.CompletableFuture;

/**
 * @author danilaberdnikov on AsynchronouslyAspect.
 * @project OpenSchoolAOP
 */
@Component
@Aspect
@Slf4j
public class AsynchronouslyAspect {
    @Value("${logging.track.async.time: false}")
    private boolean async;

    @Pointcut("execution(@ru.berdnikov.openschoolaop.annotation.Asynchronously * *(..)) ")
    public void asyncRunnerPointcut() {
    }

    @Around("asyncRunnerPointcut()")
    public Object asyncRunner(ProceedingJoinPoint joinPoint) {
        if(async) {
            return CompletableFuture.runAsync(() -> {
                try {
                    log.info("----------------------");
                    log.info("Async launch in class:{}, method {}}", joinPoint.getSignature().getDeclaringType().getSimpleName(), joinPoint.getSignature().getName());
                    log.info("----------------------");
                    joinPoint.proceed();
                } catch (Throwable e) {
                    throw new ProceedingJoinPointException(e);
                }
            });
        }
        try {
            log.info("----------------------");
            log.info("Sync launch in class:{}, method {}}", joinPoint.getSignature().getDeclaringType().getSimpleName(), joinPoint.getSignature().getName());
            log.info("----------------------");
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new ProceedingJoinPointException(e);
        }
    }
}
