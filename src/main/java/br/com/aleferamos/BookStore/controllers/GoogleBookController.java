package br.com.aleferamos.BookStore.controllers;

import br.com.aleferamos.BookStore.services.GoogleBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("googlebook")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class GoogleBookController {

    @Autowired
    private GoogleBookService googleBookService;

    @GetMapping("{nome}")
    public ResponseEntity<?> buscar(@PathVariable(name = "nome") String nome){
        return googleBookService.getBook(nome);
    }
}
