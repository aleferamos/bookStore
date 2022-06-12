package br.com.aleferamos.BookStore.controllers;

import javax.validation.Valid;

import br.com.aleferamos.BookStore.controllers.dto.TokenDTO;
import br.com.aleferamos.BookStore.services.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autenticacao")
public class AutenticacaoController {

    private AuthenticationManager authenticationManager;
    private AutenticacaoService autenticacaoService;

    @Autowired
    public AutenticacaoController(AuthenticationManager authenticationManager, AutenticacaoService autenticacaoService) {
        super();
        this.authenticationManager = authenticationManager;
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> stored(@RequestBody @Valid LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha());

        authenticationManager.authenticate(login);

        TokenDTO tokenDTO = new TokenDTO("Bearer", autenticacaoService.getToken(login));

        return ResponseEntity.ok(tokenDTO);
    }

}