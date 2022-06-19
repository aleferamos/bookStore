package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.repositories.GoogleBooksFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GoogleBookService {

    @Value("${encrypted.keyGoogleBooks}")
    private String keyGoogleBooks;
    @Autowired
    private GoogleBooksFeignClient googleBooksFeignClient;

    public ResponseEntity<?> getBook(String nome){
        return googleBooksFeignClient.buscaLivro(nome, keyGoogleBooks);
    }
}
