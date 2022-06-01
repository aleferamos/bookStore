package br.com.aleferamos.BookStore.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GoogleBooks", url = "https://www.googleapis.com/books/v1/volumes")
public interface GoogleBooksFeignClient {

    @GetMapping("?q={nome}&maxResults=5&orderBy=relevance&printType=books&key={key}")
    ResponseEntity<?> buscaLivro(@PathVariable String nome, @PathVariable String key);
}
