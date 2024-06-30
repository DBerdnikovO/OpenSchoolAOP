package ru.berdnikov.openschoolaop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.berdnikov.openschoolaop.annotation.TrackAsyncTime;

/**
 * @author danilaberdnikov on Check.
 * @project OpenSchoolAOP
 */
@Component
@Slf4j
public class Check {

    @TrackAsyncTime
    public void method1(){
        log.info("первый метод");
    }

    @TrackAsyncTime
    public void method2(){
        log.info("второй метод");
    }
}
