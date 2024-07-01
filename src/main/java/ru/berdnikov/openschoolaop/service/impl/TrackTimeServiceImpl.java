package ru.berdnikov.openschoolaop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
import ru.berdnikov.openschoolaop.exception.NotFoundException;
import ru.berdnikov.openschoolaop.mapper.TrackTimeMapper;
import ru.berdnikov.openschoolaop.model.Drink;
import ru.berdnikov.openschoolaop.model.TrackTimeModel;
import ru.berdnikov.openschoolaop.repository.TrackTimeRepository;
import ru.berdnikov.openschoolaop.service.TrackTimeService;

import java.util.List;

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
    public TrackTimeModel saveExecutionTime(TrackTimeDTO trackTimeDTO) {
        TrackTimeModel trackTimeModel = trackTimeMapper.toEntity(trackTimeDTO);
        return trackTimeRepository.save(trackTimeModel);
    }

    @Override
    public Page<TrackTimeDTO> getAllTrackTimes(Integer from, Integer size, String className, String methodName) {
        Pageable pageable = PageRequest.of(from, size);
        Page<TrackTimeModel> trackTimeModels = trackTimeRepository.getAllTrackTimes(className,methodName,pageable);
        return trackTimeModels.map(trackTimeMapper::toDTO);
    }

    @Override
    public TrackTimeDTO getTrackTimeById(Long id) {
        return trackTimeMapper.toDTO(getTrackTime(id));
    }

    private TrackTimeModel getTrackTime(Long id) {
        return trackTimeRepository.findById(id).orElseThrow(() -> new NotFoundException("TrackTime not found with id: " + id)) ;
    }
}
