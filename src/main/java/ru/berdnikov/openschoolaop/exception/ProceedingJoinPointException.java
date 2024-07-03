package ru.berdnikov.openschoolaop.exception;

/**
 * @author danilaberdnikov on ProceedingJoinPointException.
 * @project OpenSchoolAOP
 */
public class ProceedingJoinPointException extends RuntimeException {
    public ProceedingJoinPointException() {
    }

    public ProceedingJoinPointException(String message) {
        super(message);
    }

    public ProceedingJoinPointException(Throwable cause) {
        super(cause);
    }
}
