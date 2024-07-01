package ru.berdnikov.openschoolaop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
import ru.berdnikov.openschoolaop.model.TrackTimeModel;

import java.util.List;

/**
 * @author danilaberdnikov on TrackTimeRepository.
 * @project OpenSchoolAOP
 */
@Repository
public interface TrackTimeRepository extends JpaRepository<TrackTimeModel, Long> {
     @Query("""
            SELECT tt FROM TrackTimeModel tt
            where (:className is null or tt.className = :className)
            and (:methodName is null or tt.methodName = :methodName)
            """)
     Page<TrackTimeModel> getAllTrackTimes(
             @Param("className") String className,
             @Param("methodName") String methodName,
             Pageable page
     );
}
