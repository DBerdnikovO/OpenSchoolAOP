package ru.berdnikov.openschoolaop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Сущность тайм-трэкера")
public class TrackTimeDTO {
    @Schema(description = "Название аннотации")
    private String annotationName;
    @Schema(description = "Имя класса")
    private String className;
    @Schema(description = "Название метода")
    private String methodName;
    @Schema(description = "Время выполнения")
    private Long executionTime;
    @Schema(description = "Статус выполнения")
    private Boolean success;
}
