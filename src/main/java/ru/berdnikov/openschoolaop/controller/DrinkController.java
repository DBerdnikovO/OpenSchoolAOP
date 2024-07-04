package ru.berdnikov.openschoolaop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.berdnikov.openschoolaop.annotation.SuccessLogging;
import ru.berdnikov.openschoolaop.annotation.TrackAsyncTime;
import ru.berdnikov.openschoolaop.annotation.TrackTime;
import ru.berdnikov.openschoolaop.dto.DrinkDTO;
import ru.berdnikov.openschoolaop.service.DrinkService;

/**
 * @author danilaberdnikov on DrinkController.
 * @project OpenSchoolAOP
 */
@RestController
@Slf4j
@RequestMapping("/drink")
@RequiredArgsConstructor
@SuccessLogging
public class DrinkController {
    private final DrinkService drinkService;

    @Operation(
            summary = "Получить все напитки",
            description = "Позволяет получить напитки по размеру страницы"
    )
    @GetMapping
    @TrackTime
//    @TrackAsyncTime
    public ResponseEntity<Page<DrinkDTO>> getAllDrinkOnPage(
            @RequestParam(name = "from", defaultValue = "0") @Parameter(description = "Номер страницы") Integer from,
            @RequestParam(name = "size", defaultValue = "10") @Parameter(description = "Размер страницы") Integer size) {
        Page<DrinkDTO> drinkDTOS = drinkService.getAll(from, size);
        return ResponseEntity.ok().body(drinkDTOS);
    }

    @Operation(
            summary = "Получить напиток по id",
            description = "Позволяет получить напиток по id"
    )
    @GetMapping("/{id}")
//    @TrackTime
    @TrackAsyncTime
    public ResponseEntity<DrinkDTO> getDrinkById(@PathVariable @Parameter(description = "Id напитка") Long id) {
        return ResponseEntity.ok().body(drinkService.getDrinkById(id));
    }

    @Operation(
            summary = "Добавить напиток",
            description = "Позволяет добавить наипиток"
    )
    @PostMapping
//    @TrackTime
    @TrackAsyncTime
    public ResponseEntity<DrinkDTO> saveDrinkDTO(@RequestBody DrinkDTO dto) {
        DrinkDTO drinkDTO = drinkService.saveDrink(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(drinkDTO);
    }

    @Operation(
            summary = "Обновить напиток",
            description = "Позволяет обновить наипиток по id"
    )
    @PatchMapping("/{id}")
//    @TrackTime
    @TrackAsyncTime
    public ResponseEntity<Void> updateDrink(@PathVariable Long id, @RequestBody DrinkDTO drinkDTO) {
        drinkService.updateDrink(id, drinkDTO);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Удалить напиток",
            description = "Позволяет удалить наипиток по id"
    )
    @DeleteMapping("/{id}")
//    @TrackTime
    @TrackAsyncTime
    public ResponseEntity<Void> deleteDrink(@PathVariable @Parameter(description = "Id наиптка, который нужно удалить") Long id) {
        drinkService.deleteDrinkById(id);
        return ResponseEntity.noContent().build();
    }
}
