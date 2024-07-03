package ru.berdnikov.openschoolaop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author danilaberdnikov on Drink.
 * @project OpenSchoolAOP
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "drink_catalog")
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
}
