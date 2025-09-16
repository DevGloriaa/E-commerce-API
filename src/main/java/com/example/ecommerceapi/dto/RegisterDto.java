package com.example.ecommerceapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class RegisterDto {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String phoneno;
}
