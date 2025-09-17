package com.example.ecommerceapi.serviceImpl;

import com.example.ecommerceapi.dto.EmailDto;
import com.example.ecommerceapi.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    private static final String senderName = "E-Commerce.ng ";

    @Value("${mail.from.address}")
    private String fromAddress;

    @Value("${mail.from.address}")
    private String senderEmail;

    @Override
    public void sendEmail(EmailDto emailDto) {
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            var mailMessage = new MimeMessageHelper(message);
            mailMessage.setFrom(fromAddress, senderName);
            mailMessage.setTo(emailDto.getRecipient());
            mailMessage.setSubject(emailDto.getSubject());
            mailMessage.setText(emailDto.getMessageBody(),
                    true);
            javaMailSender.send(message);

        }catch (MessagingException | UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }

    }
}
