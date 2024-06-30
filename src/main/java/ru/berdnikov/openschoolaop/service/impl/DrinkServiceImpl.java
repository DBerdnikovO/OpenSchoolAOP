package ru.berdnikov.openschoolaop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.berdnikov.openschoolaop.dto.DrinkDTO;
import ru.berdnikov.openschoolaop.mapper.DrinkMapper;
import ru.berdnikov.openschoolaop.model.Drink;
import ru.berdnikov.openschoolaop.repository.DrinkRepository;
import ru.berdnikov.openschoolaop.repository.ExecutionTimeRepository;
import ru.berdnikov.openschoolaop.service.DrinkService;

/**
 * @author danilaberdnikov on DrinkServiceImpl.
 * @project OpenSchoolAOP
 */
@Service
@Transactional
public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepository drinkRepository;
    private final DrinkMapper drinkMapper;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository,
                            DrinkMapper drinkMapper) {
        this.drinkRepository = drinkRepository;
        this.drinkMapper = drinkMapper;
    }

    // Переделать под аоп
    @Override
    @Transactional(readOnly = true)
    public DrinkDTO getDrinkById(Long id) {
        Drink drink = drinkRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id)) ;
        return drinkMapper.toDTO(drink);
    }

    @Override
    public DrinkDTO saveDrink(DrinkDTO drinkDTO) {
        return drinkMapper.toDTO(drinkRepository.save(drinkMapper.toEntity(drinkDTO)));
    }
}
