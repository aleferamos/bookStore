package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.models.ResetPasswordToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.mail.SimpleMailMessage;
public interface EmailService {

    void sendEmail(SimpleMailMessage msg);

    public void sendResetPasswordToken(ResetPasswordToken resetPasswordToken) throws JsonProcessingException;
}