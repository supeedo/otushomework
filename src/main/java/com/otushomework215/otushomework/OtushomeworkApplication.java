package com.otushomework215.otushomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class OtushomeworkApplication {

    public static void main( String[] args ) {
        ConfigurableApplicationContext context =
                SpringApplication.run(OtushomeworkApplication.class, args);
    }

}
