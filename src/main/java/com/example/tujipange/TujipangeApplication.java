package com.example.tujipange;

import com.example.tujipange.utils.GenerateRandomNumberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@SpringBootApplication
@Slf4j
public class TujipangeApplication {

    public static void main(String[] args) {

        SpringApplication.run(TujipangeApplication.class, args);
        GenerateRandomNumberService generateRandomNumberService = new GenerateRandomNumberService();
//        var randomValue = generateRandomNumberService.generateRandomNumber();
//        System.out.println("You random Number is " +
//                "" +randomValue);

    }

    @Bean
    public InternalResourceViewResolver defaultViewResolver() {

        return new InternalResourceViewResolver();
    }

}
