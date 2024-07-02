package ru.berdnikov.openschoolaop.service;

import org.springframework.data.domain.Page;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;

/**
 * @author danilaberdnikov on TrackTimeService.
 * @project OpenSchoolAOP
 */
public interface TrackTimeService {
    void addExecutionTime(TrackTimeDTO trackTimeDTO);

    Page<TrackTimeDTO> getAllTrackTimes(Integer from, Integer size, String className, String methodName);

    TrackTimeDTO getTrackTimeById(Long id);

    Double getAvgTrackTimes(String className, String methodName);

    Long getSumTrackTimes(String className, String methodName);
}
