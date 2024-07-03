package ru.berdnikov.openschoolaop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.berdnikov.openschoolaop.model.DrinkType;

/**
 * @author danilaberdnikov on DrinkDTO.
 * @project OpenSchoolAOP
 */
@Data
@Schema(description = "Сущность напитка")
public class DrinkDTO {
    @Schema(description = "Название", example = "Fanta")
    private String name;
    @Schema(description = "Тип напитка", example = "NON_ALCOHOL")
    private DrinkType drinkType;
    @Schema(description = "Название брэнда", example = "Coca-cola")
    private String brand;
}
