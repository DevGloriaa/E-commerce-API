package com.example.ecommerceapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI ecommerceApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("ECommerce API")
                        .description("ECommerce API application documentaion")
                        .version("v1.0"));
    }
}
