package br.com.aleferamos.BookStore.controllers;

import br.com.aleferamos.BookStore.controllers.dto.ForgotPasswordDTO;
import br.com.aleferamos.BookStore.controllers.dto.MessageDTO;
import br.com.aleferamos.BookStore.controllers.dto.ResetPasswordDTO;
import br.com.aleferamos.BookStore.exceptions.ObjectNotFoundException;
import br.com.aleferamos.BookStore.models.ResetPasswordToken;
import br.com.aleferamos.BookStore.models.Usuario;
import br.com.aleferamos.BookStore.services.EmailService;
import br.com.aleferamos.BookStore.services.ResetPasswordTokenService;
import br.com.aleferamos.BookStore.services.UsuarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/resetPassword")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class ResetPasswordTokenController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    EmailService emailService;

    @Autowired
    private ResetPasswordTokenService serviceResetPassword;

    @Value("${auth.reset-password-token-expiration-miliseg}")
    private Long resetPasswordTokenExpirationMisiseg;

    @PostMapping("/forgot-password")
    public ResponseEntity<MessageDTO> findById(@Valid @RequestBody ForgotPasswordDTO dto)
            throws JsonProcessingException, EmailException {

        Usuario userFound = usuarioService.buscarPorEmail(dto.getEmail());

        if(userFound == null) {
            throw new ObjectNotFoundException("Object "+Usuario.class.getName()+" not found! e-mail "+dto.getEmail());
        }

        ResetPasswordToken resetPasswordToken = usuarioService.generateResetPasswordToken(userFound);
        emailService.sendResetPasswordToken(resetPasswordToken);

        StringBuilder sb = new StringBuilder();
        sb.append("Em alguns instantes enviaremos um email para este endereço, ");
        sb.append("Por favor clique no link que enviamos para fazer a alteração. <br>");
        sb.append("Verifique a caixa de spam caso não conste nos emails!");


        return ResponseEntity.ok().body(new MessageDTO(sb.toString(),
                        HttpStatus.OK.value()
                )
        );
    }

    @PostMapping("/reset-password")
    public ResponseEntity<MessageDTO> findById(@Valid @RequestBody ResetPasswordDTO dto) {

        ResetPasswordToken resetPasswordToken = serviceResetPassword.findByToken(dto.getToken());

        if(resetPasswordToken == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(
                    new MessageDTO("Esse link não está valido!","Reset password error", HttpStatus.BAD_REQUEST.value())
            );
        }

        if(resetPasswordToken.isExpired(resetPasswordTokenExpirationMisiseg)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(
                    new MessageDTO("Esse link não está valido!","Reset password error", HttpStatus.BAD_REQUEST.value())
            );
        }

        Usuario user = resetPasswordToken.getUser();
        user.setSenha(dto.getPassword());
        usuarioService.updatePassword(user);
        //clean token to prevent that it will be used more than once

        resetPasswordToken.setToken(null);
        serviceResetPassword.update(resetPasswordToken);

        return ResponseEntity.ok().body(new MessageDTO("Sua senha foi alterada com sucesso!", HttpStatus.OK.value()));
    }

    @GetMapping("tokenIsValid/{token}")
    public ResponseEntity<Boolean> tokenIsValid(@PathVariable String token){
        return ResponseEntity.ok(serviceResetPassword.tokenIsValid(token));
    }
}
