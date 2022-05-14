package br.com.aleferamos.BookStore.controllers;

import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoDto;
import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoFormDto;
import br.com.aleferamos.BookStore.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("{id}")
    public ResponseEntity<ProdutoDto> buscar(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.findProdutoById(id));
    }

    @PostMapping
    public ResponseEntity<Long> salvar(@RequestBody ProdutoFormDto produtoFormDto){
        return ResponseEntity.ok(produtoService.save(produtoFormDto));
    }
}
