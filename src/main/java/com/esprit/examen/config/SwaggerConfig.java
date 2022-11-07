package com.esprit.examen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.esprit.examen"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }
    private ApiInfo apiInfo ()
    {
        return new ApiInfoBuilder()
                .title("Swagger Configuration for Pidev PI Project")
                .description("\" Spring Boot Swagger configuration\"")
                .version("1.1.0")
                .build();
    }
}
