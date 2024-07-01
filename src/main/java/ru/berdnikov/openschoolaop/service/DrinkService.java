package ru.berdnikov.openschoolaop.service;

import org.springframework.data.domain.Page;
import ru.berdnikov.openschoolaop.dto.DrinkDTO;

import java.util.List;

/**
 * @author danilaberdnikov on DrinkService.
 * @project OpenSchoolAOP
 */
public interface DrinkService {
    Page<DrinkDTO> getAll(Integer from, Integer size);

    DrinkDTO getDrinkById(Long id);

    DrinkDTO saveDrink(DrinkDTO drinkDTO);

    void updateDrink(Long id, DrinkDTO drinkDTO);

    void deleteDrinkById(Long id);
}
