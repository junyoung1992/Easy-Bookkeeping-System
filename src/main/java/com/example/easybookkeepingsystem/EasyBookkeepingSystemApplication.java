package com.example.easybookkeepingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class EasyBookkeepingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyBookkeepingSystemApplication.class, args);
    }

}
