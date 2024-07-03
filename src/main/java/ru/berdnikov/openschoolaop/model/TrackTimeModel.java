package ru.berdnikov.openschoolaop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author danilaberdnikov on TrackTimeModel.
 * @project OpenSchoolAOP
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "track_time")
public class TrackTimeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "annotation_name")
    private String annotationName;

    @Column(name = "class_name")
    private String className;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "execution_time_ms")
    private Long executionTime;

    @Column(name = "success")
    private Boolean success;
}
