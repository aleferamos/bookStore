package br.com.aleferamos.BookStore.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AppKey", url = "http://localhost:8081/key/")
public interface AppKeyFeignClient {

    @GetMapping("{type}")
    String getKey(@PathVariable String type);
}
