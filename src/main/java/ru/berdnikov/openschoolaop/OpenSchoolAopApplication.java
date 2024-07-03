package ru.berdnikov.openschoolaop;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
@SpringBootApplication
public class OpenSchoolAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenSchoolAopApplication.class, args);
    }

}
