package ru.berdnikov.openschoolaop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author danilaberdnikov on Check.
 * @project OpenSchoolAOP
 */
@Slf4j
@Component
public class Check {
    @Autowired
    @Lazy
    private Check info;

    public void method1() {
        log.info("первый метод");
        info.method2();
    }

    public void method2() {
        log.info("второй метод");
    }
}
