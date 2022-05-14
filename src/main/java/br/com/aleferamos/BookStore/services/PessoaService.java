package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaFormDto;
import br.com.aleferamos.BookStore.models.Pessoa;
import br.com.aleferamos.BookStore.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Long save(PessoaFormDto pessoaFormDto){
        var pessoaSave = pessoaRepository.save(new Pessoa(pessoaFormDto));
        return pessoaSave.getId();
    }
}
