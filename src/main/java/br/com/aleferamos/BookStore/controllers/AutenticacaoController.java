package br.com.aleferamos.BookStore.controllers;

import javax.validation.Valid;

import br.com.aleferamos.BookStore.controllers.dto.ForgotPasswordDTO;
import br.com.aleferamos.BookStore.controllers.dto.MessageDTO;
import br.com.aleferamos.BookStore.controllers.dto.ResetPasswordDTO;
import br.com.aleferamos.BookStore.controllers.dto.TokenDTO;
import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaAuthenticadDto;
import br.com.aleferamos.BookStore.exceptions.ObjectNotFoundException;
import br.com.aleferamos.BookStore.models.ResetPasswordToken;
import br.com.aleferamos.BookStore.models.Usuario;
import br.com.aleferamos.BookStore.services.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autenticacao")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class AutenticacaoController {

    @Autowired
    private ResetPasswordTokenService serviceResetPassword;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    EmailService emailService;

    @Value("${auth.reset-password-token-expiration-miliseg}")
    private Long resetPasswordTokenExpirationMisiseg;

    @PostMapping("autenticar")
    public ResponseEntity<TokenDTO> stored(@RequestBody @Valid LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha());

        authenticationManager.authenticate(login).isAuthenticated();


        TokenDTO tokenDTO = new TokenDTO("Bearer", autenticacaoService.getToken(login));

        return ResponseEntity.ok(tokenDTO);
    }

    @PostMapping("validar")
    public ResponseEntity<Boolean> isValid(@RequestBody TokenDTO token){
        return ResponseEntity.ok(autenticacaoService.isTokenValid(token.getToken()));
    }

    @GetMapping("GetUSerAuthenticad")
    public ResponseEntity<PessoaAuthenticadDto> getUserAuthenticad(@RequestParam("token") String token){
        return ResponseEntity.ok(pessoaService.findPessoaAuthenticad(autenticacaoService.GetIdUser(token)));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<MessageDTO> findById(@Valid @RequestBody ForgotPasswordDTO dto)
            throws JsonProcessingException {

        Usuario userFound = usuarioService.buscarPorEmail(dto.getEmail());

        if(userFound == null) {
            throw new ObjectNotFoundException("Object "+Usuario.class.getName()+" not found! e-mail "+dto.getEmail());
        }

        ResetPasswordToken resetPasswordToken = usuarioService.generateResetPasswordToken(userFound);
        emailService.sendResetPasswordToken(resetPasswordToken);

        StringBuilder sb = new StringBuilder();
        sb.append("Em alguns instantes enviaremos um email para este endereço, ");
        sb.append("Por favor clique no link que enviamos para fazer a alteração. ");
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

}