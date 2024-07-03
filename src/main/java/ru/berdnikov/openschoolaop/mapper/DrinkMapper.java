package ru.berdnikov.openschoolaop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.berdnikov.openschoolaop.dto.DrinkDTO;
import ru.berdnikov.openschoolaop.model.Drink;

import java.util.List;

/**
 * @author danilaberdnikov on DrinkMapper.
 * @project OpenSchoolAOP
 */
@Mapper(componentModel = "spring")
public interface DrinkMapper {
    DrinkDTO toDTO(Drink drink);

    @Mapping(target = "id", ignore = true)
    Drink toEntity(DrinkDTO drinkDTO);

    List<DrinkDTO> toDrinkDTOList(List<Drink> drinks);
}
