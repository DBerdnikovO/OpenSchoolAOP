package ru.berdnikov.openschoolaop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(
            summary = "Получить всю статистику",
            description = "Позволяет получить параметризированную статистику пользователей по имени класса и/или низванию метода"
    )
    @GetMapping()
    public ResponseEntity<Page<TrackTimeDTO>> getAll(
            @RequestParam(name = "form", defaultValue = "0") Integer from,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @RequestParam(name = "className", required = false) @Parameter(description = "Имя класса") String className,
            @RequestParam(name = "methodName", required = false) @Parameter(description = "Название метода") String methodName) {
        Page<TrackTimeDTO> trackTimeDTOS = trackTimeService.getAllTrackTimes(from, size, className, methodName);
        return ResponseEntity.ok().body(trackTimeDTOS);
    }

    @Operation(
            summary = "Получить статистику по id",
            description = "Позволяет получить информацию о времени выполненния по id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<TrackTimeDTO> getTrackTimeById(@PathVariable @Parameter(description = "Id времени выполнения") Long id) {
        return ResponseEntity.ok().body(trackTimeService.getTrackTimeById(id));
    }

    @Operation(
            summary = "Получить среднее время выполнения методов",
            description = "Позволяет получить информацию о среднем времени выполнения методов в зависимости от имени класса и/или названия метода"
    )
    @GetMapping("/avg")
    public ResponseEntity<Double> getAvgTrackTimes(
            @RequestParam(name = "className", required = false) @Parameter(description = "Имя класса") String className,
            @RequestParam(name = "methodName", required = false) @Parameter(description = "Название метода") String methodName) {
        Double avg = trackTimeService.getAvgTrackTimes(className, methodName);
        return ResponseEntity.ok().body(avg);
    }

    @Operation(
            summary = "Получить общее время выполнения методов",
            description = "Позволяет получить информацию о суммарном времени выполнения методов в зависимости от имени класса и/или названия метода"
    )
    @GetMapping("/sum")
    public ResponseEntity<Long> getSumTrackTimes(
            @RequestParam(name = "className", required = false) @Parameter(description = "Имя класса") String className,
            @RequestParam(name = "methodName", required = false) @Parameter(description = "Название метода") String methodName) {
        Long sum = trackTimeService.getSumTrackTimes(className, methodName);
        return ResponseEntity.ok().body(sum);
    }
}
