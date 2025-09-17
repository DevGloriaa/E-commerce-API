package com.example.ecommerceapi.service;

import com.example.ecommerceapi.dto.SendConfirmationDto;

public interface ConfirmationService {
    //Email to confirm registration
    String sendRegistrationEmail(SendConfirmationDto sendConfirmationDto);

}
