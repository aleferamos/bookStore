package br.com.aleferamos.BookStore.controllers;

import br.com.aleferamos.BookStore.models.Pagamento;
import br.com.aleferamos.BookStore.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/save")
    private ResponseEntity<Pagamento> save(@RequestBody Pagamento pagamento){
        return ResponseEntity.ok().body(pagamentoService.save(pagamento));
    }
}
