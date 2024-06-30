package ru.berdnikov.openschoolaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.berdnikov.openschoolaop.model.Drink;

/**
 * @author danilaberdnikov on DrinkRepository.
 * @project OpenSchoolAOP
 */
@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
