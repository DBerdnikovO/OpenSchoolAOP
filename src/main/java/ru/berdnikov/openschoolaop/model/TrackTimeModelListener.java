package ru.berdnikov.openschoolaop.model;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import ru.berdnikov.openschoolaop.mapper.TrackTimeMapper;

/**
 * @author danilaberdnikov on TrackTimeModelListener.
 * @project OpenSchoolAOP
 */
@Slf4j
public class TrackTimeModelListener {
    private final TrackTimeMapper trackTimeMapper = Mappers.getMapper(TrackTimeMapper.class);

    @PostLoad
    private void afterLoad(TrackTimeModel trackTimeModel) {
        log.info("Give element, id = {}: {}.", trackTimeModel.getId(), trackTimeMapper.toDTO(trackTimeModel));
    }

    @PostPersist
    private void afterPersist(TrackTimeModel trackTimeModel) {
        log.info("Add new element: {}.", trackTimeMapper.toDTO(trackTimeModel));
    }

    @PostRemove
    private void afterRemove(TrackTimeModel trackTimeModel) {
        log.info("Deleting element with id = {}.", trackTimeModel.getId());
    }
}
