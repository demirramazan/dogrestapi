package com.udacity.dogrestapi.config;

import io.swagger.models.Path;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Dogs API",
                "This API returns a list of dogs infos.",
                "1.0",
                "https://github.com/demirramazan/dogrestapi.git",
                new Contact("Ramazan Demir", "https://github.com/demirramazan", "ramazandemir_4488@hotmail.com"),
                "License of API", "http://www.udacity.com/license", Collections.emptyList());
    }
}
