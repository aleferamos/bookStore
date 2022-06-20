package br.com.aleferamos.BookStore.controllers;

import br.com.aleferamos.BookStore.services.GoogleBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.*;

@RestController
@RequestMapping("googlebook")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class GoogleBookController {

    @Autowired
    private GoogleBookService googleBookService;

    @GetMapping("{nome}")
    public ResponseEntity<?> buscar(@PathVariable(required = false) String nome) throws IOException {

//

        return googleBookService.getBook(nome);
    }

}
