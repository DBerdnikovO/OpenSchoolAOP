package ru.berdnikov.openschoolaop.aspect;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import ru.berdnikov.openschoolaop.annotation.TrackAsyncTime;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
import ru.berdnikov.openschoolaop.exception.TrackTimeException;

import java.util.concurrent.CompletableFuture;

/**
 * @author danilaberdnikov on LoggingTrackAsyncTimeAspect.
 * @project OpenSchoolAOP
 */
@Slf4j
@Aspect
@Order(1)
@Component
public class LoggingTrackTimeAspect {
    @Pointcut("@annotation(ru.berdnikov.openschoolaop.annotation.TrackTime)")
    public void loggingTrackTime() {
    }

    @Pointcut("@annotation(ru.berdnikov.openschoolaop.annotation.TrackAsyncTime)")
    public void loggingTrackAsyncTime() {
    }

//    @Around("@annotation(ru.berdnikov.openschoolaop.annotation.TrackTime) || @annotation(ru.berdnikov.openschoolaop.annotation.TrackAsyncTime)")
//    public Object methodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        Signature signature = joinPoint.getSignature();
//        String methodName = signature.getName();
//        boolean isAsync = signature.getDeclaringType().getMethod(methodName).isAnnotationPresent(TrackAsyncTime.class);
//        return isAsync ? methodExecutionTimeAsync(joinPoint) : methodExecutionTimeSync(joinPoint);
//    }

    @Around("loggingTrackTime()")
    public Object methodExecutionTimeSync(ProceedingJoinPoint joinPoint) {
        return executeTime(joinPoint);
    }

    @Around("loggingTrackAsyncTime()")
    public CompletableFuture<Object> methodExecutionTimeAsync(ProceedingJoinPoint joinPoint) {
        return CompletableFuture.supplyAsync(() -> executeTime(joinPoint));
    }

    private Object executeTime(ProceedingJoinPoint joinPoint) {
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
            throw new TrackTimeException(e);
        }
        finally {
            stopWatch.stop();
            // compl future??
            long executionTime = stopWatch.getTotalTimeMillis();

            TrackTimeDTO trackTimeDTO = new TrackTimeDTO(
                    className, methodName, executionTime, success
            );
            // сохранять???
            System.out.println(trackTimeDTO);
        }
    }

    @AfterReturning(pointcut = "execution(* *(..)) && cflowbelow(methodExecutionTimeSync())", returning = "result")
    public void saveData(JoinPoint joinPoint, Data result) throws Throwable {
        System.out.println("[" + Thread.currentThread().getId() + "] " + joinPoint);
        System.out.println(result);
//        data = result;
    }
}
