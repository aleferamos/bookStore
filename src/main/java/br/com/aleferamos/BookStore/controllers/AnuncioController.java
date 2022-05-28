package br.com.aleferamos.BookStore.controllers;


import br.com.aleferamos.BookStore.controllers.dto.anuncio.AnuncioDto;
import br.com.aleferamos.BookStore.services.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

        return ResponseEntity.ok(anuncioService.save(anuncio, file));
    }

    @GetMapping
    public ResponseEntity<Page<AnuncioDto>> listar(@PageableDefault(size = 6) Pageable pageable,
                                                   @RequestParam(value = "nome", required = false) String nome){
        return ResponseEntity.ok(anuncioService.findAll(pageable, nome));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        anuncioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
