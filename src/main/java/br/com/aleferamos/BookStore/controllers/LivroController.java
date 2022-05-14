package br.com.aleferamos.BookStore.controllers;

import br.com.aleferamos.BookStore.controllers.dto.livro.LivroDto;
import br.com.aleferamos.BookStore.controllers.dto.livro.LivroFormDto;
import br.com.aleferamos.BookStore.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Long> salvar(@RequestBody LivroFormDto livroFormDto){
        return ResponseEntity.ok(livroService.save(livroFormDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<LivroDto> buscar(@PathVariable Long id){
        return ResponseEntity.ok(livroService.findLivroById(id));
    }
}
