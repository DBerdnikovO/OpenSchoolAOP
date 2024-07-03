package ru.berdnikov.openschoolaop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.berdnikov.openschoolaop.annotation.SuccessLogging;
import ru.berdnikov.openschoolaop.dto.TrackTimeDTO;
import ru.berdnikov.openschoolaop.service.TrackTimeService;

/**
 * @author danilaberdnikov on TrackTimeController.
 * @project OpenSchoolAOP
 */
@RestController
@Slf4j
@SuccessLogging
@RequestMapping("/stat/track")
@RequiredArgsConstructor
public class TrackTimeController {
    private final TrackTimeService trackTimeService;

    @GetMapping()
    public ResponseEntity<Page<TrackTimeDTO>> getAll(
            @RequestParam(name = "form", defaultValue = "0") Integer from,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "methodName", required = false) String methodName) {
        Page<TrackTimeDTO> trackTimeDTOS = trackTimeService.getAllTrackTimes(from, size, className, methodName);
        return ResponseEntity.ok().body(trackTimeDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackTimeDTO> getTrackTimeById(@PathVariable Long id) {
        return ResponseEntity.ok().body(trackTimeService.getTrackTimeById(id));
    }

    @GetMapping("/avg")
    public ResponseEntity<Double> getAvgTrackTimes(
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "methodName", required = false) String methodName) {
        Double avg = trackTimeService.getAvgTrackTimes(className, methodName);
        return ResponseEntity.ok().body(avg);
    }

    @GetMapping("/sum")
    public ResponseEntity<Long> getSumTrackTimes(
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "methodName", required = false) String methodName) {
        Long sum = trackTimeService.getSumTrackTimes(className, methodName);
        return ResponseEntity.ok().body(sum);
    }
}
