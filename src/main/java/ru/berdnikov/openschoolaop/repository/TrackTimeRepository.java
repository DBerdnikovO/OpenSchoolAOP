package ru.berdnikov.openschoolaop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.berdnikov.openschoolaop.model.TrackTimeModel;

/**
 * @author danilaberdnikov on TrackTimeRepository.
 * @project OpenSchoolAOP
 */
@Repository
public interface TrackTimeRepository extends JpaRepository<TrackTimeModel, Long> {
    @Query("""
            SELECT ttm FROM TrackTimeModel ttm
            where (:className is null or ttm.className = :className)
            and (:methodName is null or ttm.methodName = :methodName)
            """)
    Page<TrackTimeModel> allTrackTimes(
            @Param("className") String className,
            @Param("methodName") String methodName,
            Pageable page
    );

    @Query("""
            SELECT AVG(ttm.executionTime) FROM TrackTimeModel ttm
            where (:className is null or ttm.className = :className)
            and (:methodName is null or ttm.methodName = :methodName)
            """)
    Double avgTrackTimes(
            @Param("className") String className,
            @Param("methodName") String methodName
    );

    @Query("""
            SELECT SUM(ttm.executionTime) FROM TrackTimeModel ttm
            where (:className is null or ttm.className = :className)
            and (:methodName is null or ttm.methodName = :methodName)
            """)
    Long sumTrackTimes(
            @Param("className") String className,
            @Param("methodName") String methodName
    );
}
