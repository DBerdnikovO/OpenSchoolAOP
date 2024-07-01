package ru.berdnikov.openschoolaop.model;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import ru.berdnikov.openschoolaop.mapper.DrinkMapper;

/**
 * @author danilaberdnikov on DrinkListener.
 * @project OpenSchoolAOP
 */
@Slf4j
public class DrinkListener {
    private final DrinkMapper drinkMapper = Mappers.getMapper(DrinkMapper.class);

    @PostLoad
    private void afterLoad(Drink drink) {
        log.info("Give element, id = {}: {}.", drink.getId(), drinkMapper.toDTO(drink));
    }

    @PostPersist
    private void afterPersist(Drink drink) {
        log.info("Add new element: {}.", drinkMapper.toDTO(drink));
    }

    @PostRemove
    private void afterRemove(Drink drink) {
        log.info("Deleting element with id = {}.", drink.getId());
    }
}
