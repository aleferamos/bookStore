package br.com.aleferamos.BookStore.controllers;

import br.com.aleferamos.BookStore.controllers.dto.AnuncioFormDto;
import br.com.aleferamos.BookStore.controllers.dto.anuncio.AnuncioDto;
import br.com.aleferamos.BookStore.models.Anuncio;
import br.com.aleferamos.BookStore.services.AnuncioService;
import com.fasterxml.jackson.core.JsonProcessingException;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("anuncio")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class AnuncioController {

    @Autowired
    private AnuncioService anuncioService;

    @PostMapping
    public ResponseEntity<Long> salvar(@RequestParam(name = "anuncio") String anuncio,
                                       @RequestParam(name = "imagem") MultipartFile file) throws IOException {
        return ResponseEntity.ok(anuncioService.save(fromJsonToEntity(anuncio), file));
    }

    @GetMapping
    public ResponseEntity<Page<AnuncioDto>> listar(Pageable pageable){
        return ResponseEntity.ok(anuncioService.findAll(pageable));
    }

    private Anuncio fromJsonToEntity(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Anuncio.class);
    }
}
