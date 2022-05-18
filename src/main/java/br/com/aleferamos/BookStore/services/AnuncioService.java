package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.models.Anuncio;
import br.com.aleferamos.BookStore.repositories.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    public Long save(Anuncio anuncio){
       return anuncioRepository.save(anuncio).getId();
    }
}
