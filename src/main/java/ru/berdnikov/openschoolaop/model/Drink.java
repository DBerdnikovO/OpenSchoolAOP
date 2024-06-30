package ru.berdnikov.openschoolaop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author danilaberdnikov on Drink.
 * @project OpenSchoolAOP
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "DrinkCatalog")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private DrinkType drinkType;

    @Column(name = "brand")
    private String brand;

    public Drink(String name, DrinkType DrinkType, String brand) {
        this.name = name;
        this.drinkType = DrinkType;
        this.brand = brand;
    }
}