package ru.berdnikov.openschoolaop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
//import ru.berdnikov.openschoolaop.mapper.ExecutionTimeObjectConverter;
//import ru.berdnikov.openschoolaop.mapper.ObjectConverter;
import ru.berdnikov.openschoolaop.mapper.TrackTimeMapper;
import ru.berdnikov.openschoolaop.model.TrackTime;
import ru.berdnikov.openschoolaop.repository.ExecutionTimeRepository;
import ru.berdnikov.openschoolaop.service.TrackTimeService;

/**
 * @author danilaberdnikov on TrackTimeServiceImpl.
 * @project OpenSchoolAOP
 */
@Service
@Transactional
public class TrackTimeServiceImpl implements TrackTimeService {
    private final ExecutionTimeRepository executionTimeRepository;
    private final TrackTimeMapper trackTimeMapper;

    @Autowired
    public TrackTimeServiceImpl(ExecutionTimeRepository executionTimeRepository,
                                TrackTimeMapper trackTimeMapper) {
        this.executionTimeRepository = executionTimeRepository;
        this.trackTimeMapper = trackTimeMapper;
    }

    @Override
    public TrackTime saveExecutionTime(TrackTimeDTO trackTimeDTO) {
        new TrackTime();
        TrackTime trackTime;
        trackTime = trackTimeMapper.toEntity(trackTimeDTO);
        return executionTimeRepository.save(trackTime);
    }
}
