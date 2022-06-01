package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.repositories.AppKeyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppKeyService {
    
    @Autowired
    private AppKeyFeignClient appKeyFeignClient;
    
    public String getKey(String type){
        return appKeyFeignClient.getKey(type);
    }
}
