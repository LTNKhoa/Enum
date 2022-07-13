package com.example.demo2;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication

public class Demo2Application {


    public static void main(String[] args) {
//        SpringApplication.run(Demo2Application.class, args);
        new SpringApplicationBuilder(Demo2Application.class).profiles("dev").run(args);
//        new SpringApplicationBuilder(Demo2Application.class).profiles("prod").run(args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

@Component
@RequiredArgsConstructor
class MyRunner implements CommandLineRunner {
    private final Environment environment;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Active profiles: " + Arrays.toString(environment.getActiveProfiles()));
    }
}

@Component
@Profile(value = "dev")
class MyRunner2 implements CommandLineRunner {
    @Value("${message}")
    private String message;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In development");
        System.out.println("Message: " + message);
    }
}

@Component
@Profile(value = "local")
class MyRunner3 implements CommandLineRunner {
    @Value("${message}")
    private String message;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In local");
        System.out.println("Message: " + message);
    }
}

@Component
@Profile(value = "prod")
class MyRunner4 implements CommandLineRunner {
    @Value("${message}")
    private String message;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In prod");
        System.out.println("Message: " + message);
    }
}