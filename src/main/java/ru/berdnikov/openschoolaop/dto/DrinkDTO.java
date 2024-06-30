package ru.berdnikov.openschoolaop.dto;

import lombok.Data;
import ru.berdnikov.openschoolaop.model.DrinkType;

/**
 * @author danilaberdnikov on DrinkDTO.
 * @project OpenSchoolAOP
 */
@Data
public class DrinkDTO {
    private Long id;
    private String name;
    private DrinkType drinkType;
    private String brand;
}
