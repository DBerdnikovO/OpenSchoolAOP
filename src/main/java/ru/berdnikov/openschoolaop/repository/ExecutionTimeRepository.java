package ru.berdnikov.openschoolaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.berdnikov.openschoolaop.model.TrackTime;

/**
 * @author danilaberdnikov on ExecutionTimeRepository.
 * @project OpenSchoolAOP
 */
@Repository
public interface ExecutionTimeRepository extends JpaRepository<TrackTime, Long> {
}
