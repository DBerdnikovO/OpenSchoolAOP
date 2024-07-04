package ru.berdnikov.openschoolaop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.berdnikov.openschoolaop.dto.DrinkDTO;
import ru.berdnikov.openschoolaop.exception.NotFoundException;
import ru.berdnikov.openschoolaop.mapper.DrinkMapper;
import ru.berdnikov.openschoolaop.model.Drink;
import ru.berdnikov.openschoolaop.repository.DrinkRepository;
import ru.berdnikov.openschoolaop.service.DrinkService;

/**
 * @author danilaberdnikov on DrinkServiceImpl.
 * @project OpenSchoolAOP
 */
@Service
@Transactional
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepository drinkRepository;
    private final DrinkMapper drinkMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<DrinkDTO> getAll(Integer from, Integer size) {
        Pageable pageable = PageRequest.of(from, size);
        Page<Drink> drinkPage = drinkRepository.findAll(pageable);
        return drinkPage.map(drinkMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public DrinkDTO getDrinkById(Long id) {
        Drink drink = getDrink(id);
        return drinkMapper.toDTO(drink);
    }

    @Override
    public DrinkDTO saveDrink(DrinkDTO drinkDTO) {
        Drink drink = drinkMapper.toEntity(drinkDTO);
        return drinkMapper.toDTO(drinkRepository.save(drink));
    }

    @Override
    public void updateDrink(Long id, DrinkDTO drinkDTO) {
        Drink updateDrink = drinkMapper.toEntity(drinkDTO);
        drinkRepository.save(updateDrink);
    }

    @Override
    public void deleteDrinkById(Long id) {
        drinkRepository.deleteById(id);
    }

    private Drink getDrink(Long id) {
        return drinkRepository.findById(id).orElseThrow(() -> new NotFoundException("Drink not found with id: " + id));
    }
}
