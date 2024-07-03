package ru.berdnikov.openschoolaop.controller;

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

    @GetMapping
    @TrackTime
//    @TrackAsyncTime
    public ResponseEntity<Page<DrinkDTO>> getAll(
            @RequestParam(name = "from", defaultValue = "0") Integer from,
            @RequestParam(name = "size", defaultValue = "10") Integer size) {
        Page<DrinkDTO> drinkDTOS = drinkService.getAll(from, size);
        return ResponseEntity.ok().body(drinkDTOS);
    }

    @GetMapping("/{id}")
//    @TrackTime
    @TrackAsyncTime
    public ResponseEntity<DrinkDTO> getDrinkById(@PathVariable Long id) {
        return ResponseEntity.ok().body(drinkService.getDrinkById(id));
    }

    @PostMapping
//    @TrackTime
    @TrackAsyncTime
    public ResponseEntity<DrinkDTO> saveDrink(@RequestBody DrinkDTO dto) {
        DrinkDTO drinkDTO = drinkService.saveDrink(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(drinkDTO);
    }

    @PatchMapping("/{id}")
//    @TrackTime
    @TrackAsyncTime
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody DrinkDTO drinkDTO) {
        drinkService.updateDrink(id, drinkDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
//    @TrackTime
    @TrackAsyncTime
    public ResponseEntity<Void> deleteDrink(@PathVariable Long id) {
        drinkService.deleteDrinkById(id);
        return ResponseEntity.noContent().build();
    }
}
