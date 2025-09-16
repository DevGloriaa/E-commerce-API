package com.example.ecommerceapi.service;

import com.example.ecommerceapi.dto.EmailDto;
import com.example.ecommerceapi.dto.SendConfirmationDto;

public interface EmailService {
    void sendEmail(EmailDto emailDto);
}
