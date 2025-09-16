package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.dto.LoginDto;
import com.example.ecommerceapi.dto.RegisterDto;
import com.example.ecommerceapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public RegisterDto  registerUser(@RequestBody RegisterDto registerDto) {
        userService.registerUser(registerDto);
        return registerDto;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto user) {
        return ResponseEntity.ok(userService.loginUser(user));
    }

}
