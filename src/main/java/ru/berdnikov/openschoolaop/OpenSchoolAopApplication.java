package ru.berdnikov.openschoolaop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.berdnikov.openschoolaop.utils.ThreadUtils;

@RequiredArgsConstructor
@SpringBootApplication
public class OpenSchoolAopApplication {
//    @Autowired
//    private final Check check;

    public static void main(String[] args) {
        SpringApplication.run(OpenSchoolAopApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {
//        check.method1();
//        check.method2();
    }
}
