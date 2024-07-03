package ru.berdnikov.openschoolaop.utils;

/**
 * @author danilaberdnikov on ThreadUtils.
 * @project OpenSchoolAOP
 */
public class ThreadUtils {
    public static void waitTime(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
