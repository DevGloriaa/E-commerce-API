package com.example.ecommerceapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtResponseDto {
    private final String token;
    public JwtResponseDto(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }

}
