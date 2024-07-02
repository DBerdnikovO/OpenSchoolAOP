package ru.berdnikov.openschoolaop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.berdnikov.openschoolaop.annotation.Asynchronously;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
import ru.berdnikov.openschoolaop.exception.NotFoundException;
import ru.berdnikov.openschoolaop.mapper.TrackTimeMapper;
import ru.berdnikov.openschoolaop.model.TrackTimeModel;
import ru.berdnikov.openschoolaop.repository.TrackTimeRepository;
import ru.berdnikov.openschoolaop.service.TrackTimeService;

/**
 * @author danilaberdnikov on TrackTimeServiceImpl.
 * @project OpenSchoolAOP
 */
@Service
@Transactional
@RequiredArgsConstructor
public class TrackTimeServiceImpl implements TrackTimeService {
    private final TrackTimeRepository trackTimeRepository;
    private final TrackTimeMapper trackTimeMapper;

    @Override
    @Asynchronously
    public void addExecutionTime(TrackTimeDTO trackTimeDTO) {
        TrackTimeModel trackTimeModel = trackTimeMapper.toEntity(trackTimeDTO);
        trackTimeRepository.save(trackTimeModel);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TrackTimeDTO> getAllTrackTimes(Integer from, Integer size, String className, String methodName) {
        Pageable pageable = PageRequest.of(from, size);
        Page<TrackTimeModel> trackTimeModels = trackTimeRepository.allTrackTimes(className,methodName,pageable);
        return trackTimeModels.map(trackTimeMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public TrackTimeDTO getTrackTimeById(Long id) {
        return trackTimeMapper.toDTO(getTrackTime(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Double getAvgTrackTimes(String className, String methodName) {
        return trackTimeRepository.avgTrackTimes(className,methodName);
    }

    @Override
    @Transactional(readOnly = true)
    public Long getSumTrackTimes(String className, String methodName) {
        return trackTimeRepository.sumTrackTimes(className,methodName);
    }

    private TrackTimeModel getTrackTime(Long id) {
        return trackTimeRepository.findById(id).orElseThrow(() -> new NotFoundException("TrackTime not found with id: " + id)) ;
    }
}
