package com.ibrahimeshag.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class H2Application {

    public static void main(String[] args) {
        SpringApplication.run(H2Application.class, args);
    }


    @Scheduled(fixedRate = 5000)
    public void sendEmail(){
        System.out.println("Sending email...");
    }
}
