package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.repositories.GoogleBooksFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GoogleBookService {

    @Autowired
    private GoogleBooksFeignClient googleBooksFeignClient;

    @Autowired
    private AppKeyService appKeyService;

    public ResponseEntity<?> getBook(String nome){
        return googleBooksFeignClient.buscaLivro(nome, appKeyService.getKey("googleBooks"));
    }
}
