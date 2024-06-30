package ru.berdnikov.openschoolaop.mapper;

//import org.mapstruct.Mapper;
import org.mapstruct.Mapper;
import ru.berdnikov.openschoolaop.dto.DrinkDTO;
import ru.berdnikov.openschoolaop.model.Drink;

/**
 * @author danilaberdnikov on DrinkMapper.
 * @project OpenSchoolAOP
 */
@Mapper(componentModel = "spring")
public interface DrinkMapper {
    DrinkDTO toDTO(Drink entity);
    Drink toEntity(DrinkDTO dto);
}
