package ru.berdnikov.openschoolaop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author danilaberdnikov on TrackTime.
 * @project OpenSchoolAOP
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "MethodTrackTimeLog")
public class TrackTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "execution_time_ms")
    private Long executionTime;

    @Column(name = "success")
    private Boolean success;

    public TrackTime(String className, String methodName, Long executionTime, Boolean success) {
        this.className = className;
        this.methodName = methodName;
        this.executionTime = executionTime;
        this.success = success;
    }
}
