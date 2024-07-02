package ru.berdnikov.openschoolaop.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
import ru.berdnikov.openschoolaop.exception.ProceedingJoinPointException;
import ru.berdnikov.openschoolaop.service.TrackTimeService;

import java.util.concurrent.CompletableFuture;

/**
 * @author danilaberdnikov on LoggingTrackAsyncTimeAspect.
 * @project OpenSchoolAOP
 */
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingTrackTimeAspect {
    private final TrackTimeService trackTimeService;

    @Pointcut("@annotation(ru.berdnikov.openschoolaop.annotation.TrackTime)")
    public void loggingTrackTime() {}

    @Pointcut("@annotation(ru.berdnikov.openschoolaop.annotation.TrackAsyncTime)")
    public void loggingTrackAsyncTime() {}

    @Around("loggingTrackTime()")
    public Object methodExecutionTimeSync(ProceedingJoinPoint joinPoint) {
        log.info("Sync start in LoggingTrackTimeAspect");
        return executeTime(joinPoint, "TrackTime");
    }

    @Around("loggingTrackAsyncTime()")
    public Object methodExecutionTimeAsync(ProceedingJoinPoint joinPoint) {
        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(() ->
                executeTime(joinPoint, "TrackAsyncTime"));
        return completableFuture.join();
    }

    private Object executeTime(ProceedingJoinPoint joinPoint, String annotationName) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Signature signature = joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        boolean success = true;

        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            success = false;
            throw new ProceedingJoinPointException(e);
        }
        finally {
            stopWatch.stop();
            long executionTime = stopWatch.getTotalTimeMillis();
            TrackTimeDTO trackTimeDTO = new TrackTimeDTO(
                    annotationName, className, methodName, executionTime, success
            );
            trackTimeService.addExecutionTime(trackTimeDTO);
        }
    }
}
