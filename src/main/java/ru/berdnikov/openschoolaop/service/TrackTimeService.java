package ru.berdnikov.openschoolaop.service;

import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
import ru.berdnikov.openschoolaop.model.TrackTime;

/**
 * @author danilaberdnikov on TrackTimeService.
 * @project OpenSchoolAOP
 */
public interface TrackTimeService {
    TrackTime saveExecutionTime(TrackTimeDTO trackTimeDTO);
}
