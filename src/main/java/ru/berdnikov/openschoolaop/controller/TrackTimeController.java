package ru.berdnikov.openschoolaop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.berdnikov.openschoolaop.annotation.TrackTime;
import ru.berdnikov.openschoolaop.dto.DrinkDTO;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
import ru.berdnikov.openschoolaop.service.TrackTimeService;

/**
 * @author danilaberdnikov on TrackTimeController.
 * @project OpenSchoolAOP
 */
@RestController
@Slf4j
@RequestMapping("/stat/track")
@RequiredArgsConstructor
public class TrackTimeController {
    private final TrackTimeService trackTimeService;

    @GetMapping()
    public ResponseEntity<Page<TrackTimeDTO>> getAll(
            @RequestParam(name = "form", defaultValue = "0") Integer from,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "methodName",required = false) String methodName) {
        Page<TrackTimeDTO> trackTimeDTOS = trackTimeService.getAllTrackTimes(from, size, className, methodName);
        log.info("Give elements list, from = {}, size = {}, количество = {}.", from, size, trackTimeDTOS.getTotalElements());
        return ResponseEntity.ok().body(trackTimeDTOS);
    }

    @GetMapping("/{id}")
    @TrackTime
    public ResponseEntity<TrackTimeDTO> getTrackTimeById(@PathVariable Long id) {
        return ResponseEntity.ok().body(trackTimeService.getTrackTimeById(id));
    }
}
