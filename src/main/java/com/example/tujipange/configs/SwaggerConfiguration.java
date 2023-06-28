package com.example.tujipange.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author Nicholas Nzovia
 * @On 21/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact(
                "Dev Nic",
                "https://nzovia.github.io/",
                "itsdevelopernic22@gmail.com"
        );
        return new ApiInfo(
                "Tujipange Api's",
                "The Apis development are inspired by desire to build complete Backend for Group Contributions",
                "version 1.0",
                "",
                contact,
                "All rights reserved for the developer",
                "",
                Collections.emptyList()
        );
    }
}
