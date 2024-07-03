package ru.berdnikov.openschoolaop.exception;

/**
 * @author danilaberdnikov on NotFoundException.
 * @project OpenSchoolAOP
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
