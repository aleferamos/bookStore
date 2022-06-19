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
import org.apache.commons.mail.EmailException;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private PessoaService pessoaService;


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
}