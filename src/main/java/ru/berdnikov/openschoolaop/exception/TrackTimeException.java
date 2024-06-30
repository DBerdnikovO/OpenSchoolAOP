package ru.berdnikov.openschoolaop.exception;

import ru.berdnikov.openschoolaop.annotation.Throw;

/**
 * @author danilaberdnikov on TrackTimeException.
 * @project OpenSchoolAOP
 */
@Throw
public class TrackTimeException extends RuntimeException{
    public TrackTimeException() {
    }

    public TrackTimeException(String message) {
        super(message);
    }

    public TrackTimeException(Throwable cause) {
        super(cause);
    }
}
