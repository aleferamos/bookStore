package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.Utils.ObjectMapperUtil;
import br.com.aleferamos.BookStore.controllers.dto.ResetPasswordDTO;
import br.com.aleferamos.BookStore.models.ResetPasswordToken;
import br.com.aleferamos.BookStore.models.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("${application.smtp-sender}")
    private String smtpSender;

    @Value("${application.reset-password-url}")
    private String resetPassowdUrl;

    public void sendResetPasswordToken(ResetPasswordToken resetPasswordToken)
            throws JsonProcessingException {
        SimpleMailMessage msg = this.prepareResetPasswordEmail(resetPasswordToken);
        sendEmail(msg);
    }

    protected SimpleMailMessage prepareResetPasswordEmail(ResetPasswordToken resetPasswordToken)
            throws JsonProcessingException{

        SimpleMailMessage sm = new SimpleMailMessage();
        Usuario user = resetPasswordToken.getUser();
        sm.setTo(user.getEmail());
        sm.setFrom(smtpSender);
        sm.setSubject("Reset password");
        sm.setSentDate(new Date(System.currentTimeMillis()));

        ObjectMapper objectMapper = new ObjectMapper();

        ResetPasswordDTO dto = ObjectMapperUtil.map(resetPasswordToken,ResetPasswordDTO.class);

        dto.setPassword("newPassword");
        dto.setPasswordConfirm("newPassword");

        StringBuilder sb = new StringBuilder();
        sb.append("Olá, você pediu para fazer um alteração em sua senha? caso sim entre no link abaixo para fazer a alteração, ");
        sb.append("Caso não foi você fique atento pois alguem está tentando entrar em sua conta! ");
        sb.append(resetPassowdUrl).append("/").append(dto.getToken());

        sm.setText(sb.toString());
        return sm;
    }

}