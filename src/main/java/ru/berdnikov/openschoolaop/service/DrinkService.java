package ru.berdnikov.openschoolaop.service;

import ru.berdnikov.openschoolaop.dto.DrinkDTO;

/**
 * @author danilaberdnikov on DrinkService.
 * @project OpenSchoolAOP
 */
public interface DrinkService {
    DrinkDTO getDrinkById(Long id);

    DrinkDTO saveDrink(DrinkDTO drinkDTO);
}
