package com.example.ecommerceapi.serviceImpl;

import com.example.ecommerceapi.dto.LoginDto;
import com.example.ecommerceapi.dto.LoginResponseDto;
import com.example.ecommerceapi.dto.RegisterDto;
import com.example.ecommerceapi.dto.SendConfirmationDto;
import com.example.ecommerceapi.exceptions.HandleUserDoesNotExistException;
import com.example.ecommerceapi.model.User;
import com.example.ecommerceapi.repository.UserRepository;
import com.example.ecommerceapi.service.ConfirmationService;
import com.example.ecommerceapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtServiceImpl jwtServiceImpl;
    @Autowired
    private ConfirmationService confirmationService;

    @Override
    public User registerUser(RegisterDto registerDto) {
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPhoneno(registerDto.getPhoneno());
        user.setUserType(user.getUserType());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        SendConfirmationDto sendConfirmationDto = new SendConfirmationDto();
        sendConfirmationDto.setEmail(registerDto.getEmail());
        sendConfirmationDto.setPhoneno(registerDto.getPhoneno());

        userRepository.save(user);
        confirmationService.sendRegistrationEmail(sendConfirmationDto);

        return user;
    }

    @Override
    public LoginResponseDto loginUser(LoginDto user) {
        User existing = userRepository.findByEmailIgnoreCase(String.valueOf(user.getEmail()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(user.getPassword(), existing.getPassword())) {
            throw new HandleUserDoesNotExistException("Incorrect password");
        }
        String token = jwtServiceImpl.generateToken(existing);
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setMessage("Login successful!");
        loginResponseDto.setToken(token);

        return loginResponseDto;
    }
}
