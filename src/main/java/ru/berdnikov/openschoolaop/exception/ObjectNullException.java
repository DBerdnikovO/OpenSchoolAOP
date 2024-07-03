package ru.berdnikov.openschoolaop.exception;

/**
 * @author danilaberdnikov on ObjectNullException.
 * @project OpenSchoolAOP
 */
public class ObjectNullException extends RuntimeException {
    public ObjectNullException() {
    }

    public ObjectNullException(String message) {
        super(message);
    }

    public ObjectNullException(Throwable cause) {
        super(cause);
    }
}
