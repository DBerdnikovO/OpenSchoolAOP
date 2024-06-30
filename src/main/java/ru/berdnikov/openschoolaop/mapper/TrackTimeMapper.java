package ru.berdnikov.openschoolaop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
import ru.berdnikov.openschoolaop.model.TrackTime;

/**
 * @author danilaberdnikov on TrackTimeMapper.
 * @project OpenSchoolAOP
 */
@Mapper(componentModel = "spring")
public interface TrackTimeMapper {
    TrackTimeDTO toDTO(TrackTime entity);

    @Mapping(target = "id", ignore = true)
    TrackTime toEntity(TrackTimeDTO dto);
}
