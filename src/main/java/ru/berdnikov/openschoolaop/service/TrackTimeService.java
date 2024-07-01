package ru.berdnikov.openschoolaop.service;

import org.springframework.data.domain.Page;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
import ru.berdnikov.openschoolaop.model.TrackTimeModel;

/**
 * @author danilaberdnikov on TrackTimeService.
 * @project OpenSchoolAOP
 */
public interface TrackTimeService {
    TrackTimeModel saveExecutionTime(TrackTimeDTO trackTimeDTO);

    Page<TrackTimeDTO> getAllTrackTimes(Integer from, Integer size, String className, String methodName);

    TrackTimeDTO getTrackTimeById(Long id);
}
