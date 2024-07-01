package ru.berdnikov.openschoolaop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
import ru.berdnikov.openschoolaop.model.TrackTimeModel;

import java.util.List;

/**
 * @author danilaberdnikov on TrackTimeMapper.
 * @project OpenSchoolAOP
 */
@Mapper(componentModel = "spring")
public interface TrackTimeMapper {
    TrackTimeDTO toDTO(TrackTimeModel trackTimeModel);

    @Mapping(target = "id", ignore = true)
    TrackTimeModel toEntity(TrackTimeDTO trackTimeDTO);

    List<TrackTimeDTO> toTrackTimeDTOList(List<TrackTimeModel> trackTimeModels);
}
