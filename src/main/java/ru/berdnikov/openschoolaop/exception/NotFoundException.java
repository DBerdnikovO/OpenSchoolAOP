package ru.berdnikov.openschoolaop.exception;

import ru.berdnikov.openschoolaop.annotation.Throw;

/**
 * @author danilaberdnikov on NotFoundException.
 * @project OpenSchoolAOP
 */
@Throw
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
