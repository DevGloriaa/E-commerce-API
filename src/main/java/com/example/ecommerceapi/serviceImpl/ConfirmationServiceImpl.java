package com.example.ecommerceapi.serviceImpl;

import com.example.ecommerceapi.dto.EmailDto;
import com.example.ecommerceapi.dto.SendConfirmationDto;
import com.example.ecommerceapi.exceptions.HandleUserDoesNotExistException;
import com.example.ecommerceapi.model.Confirmation;
import com.example.ecommerceapi.model.User;
import com.example.ecommerceapi.repository.ConfirmationRepository;
import com.example.ecommerceapi.repository.UserRepository;
import com.example.ecommerceapi.service.ConfirmationService;
import com.example.ecommerceapi.service.EmailService;
import com.example.ecommerceapi.service.UserService;
import com.example.ecommerceapi.utils.EmailContent;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfirmationServiceImpl implements ConfirmationService {
    @Autowired
    private final ConfirmationRepository confirmationRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public String sendRegistrationEmail(SendConfirmationDto sendConfirmationDto) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmailIgnoreCase(sendConfirmationDto.getEmail())
                .orElseThrow(() -> new HandleUserDoesNotExistException("User not found!")));

        Confirmation confirmation = new Confirmation();
        confirmation.setEmail(sendConfirmationDto.getEmail());
        confirmation.setId(user.get().getId());
        confirmation.setPhoneno(sendConfirmationDto.getPhoneno());
        confirmationRepository.save(confirmation);

    String message = EmailContent.registrationEmail();
    EmailDto emailDto = EmailDto.builder()
            .recipient(user.get().getEmail())
            .subject("Successful Registration")
            .messageBody(message)
            .build();
        emailService.sendEmail(emailDto);

        return "";
    }
}
