package br.com.aleferamos.BookStore.controllers;

import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaAuthenticadDto;
import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaDto;
import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaFormDto;
import br.com.aleferamos.BookStore.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("pessoa")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Long> salvar(@RequestBody PessoaFormDto pessoaFormDto){
        return ResponseEntity.ok(pessoaService.save(pessoaFormDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<PessoaDto> buscar(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.findPessoaById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
