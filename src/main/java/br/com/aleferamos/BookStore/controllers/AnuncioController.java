package br.com.aleferamos.BookStore.controllers;

import br.com.aleferamos.BookStore.models.Anuncio;
import br.com.aleferamos.BookStore.services.AnuncioService;
import com.fasterxml.jackson.core.JsonProcessingException;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("anuncio")
public class AnuncioController {

    @Autowired
    private AnuncioService anuncioService;

    @PostMapping
    public ResponseEntity<Long> salvar(@RequestParam(name = "anuncio") String anuncio) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var anuncioSave = mapper.readValue(anuncio, Anuncio.class);
        anuncioSave.setData(LocalDate.now());

        return ResponseEntity.ok(anuncioService.save(anuncioSave));
    }
}
