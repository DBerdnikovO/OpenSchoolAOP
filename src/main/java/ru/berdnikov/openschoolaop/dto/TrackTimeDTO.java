package ru.berdnikov.openschoolaop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author danilaberdnikov on TrackTimeDTO.
 * @project OpenSchoolAOP
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackTimeDTO {
    private String className;
    private String methodName;
    private Long executionTime;
    private Boolean success;
}
