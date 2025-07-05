package com.example.edgeservice.config;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi bookServiceApi() {
        return GroupedOpenApi.builder()
                .group("book-service")
                .pathsToMatch("/book-service/**")
                .build();
    }

    @Bean
    public GroupedOpenApi storeServiceApi() {
        return GroupedOpenApi.builder()
                .group("store-service")
                .pathsToMatch("/store-service/**")
                .build();
    }
}
