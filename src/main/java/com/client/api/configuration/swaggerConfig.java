package com.client.api.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swaggerConfig {

    @Bean
    OpenAPI apiClientApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("clients-api")
                        .description("API for managing client data")
                        .version("0.0.1")
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Apache License Version 2.0")));
    }

}


