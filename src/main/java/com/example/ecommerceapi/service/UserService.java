package com.example.ecommerceapi.service;

import com.example.ecommerceapi.dto.LoginDto;
import com.example.ecommerceapi.dto.LoginResponseDto;
import com.example.ecommerceapi.dto.RegisterDto;
import com.example.ecommerceapi.model.User;

public interface UserService {
    //Register
    User registerUser(RegisterDto registerDto);
    //Login
    LoginResponseDto loginUser(LoginDto user);
}
