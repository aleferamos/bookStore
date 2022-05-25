package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaDto;
import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaFormDto;
import br.com.aleferamos.BookStore.exceptions.RegraDeNegocioException;
import br.com.aleferamos.BookStore.models.Pessoa;
import br.com.aleferamos.BookStore.repositories.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Long save(PessoaFormDto pessoaFormDto){
        var pessoaSave = pessoaRepository.save(new Pessoa(pessoaFormDto));
        if(pessoaRepository.existEmail(pessoaSave.getUsuario().getEmail(), pessoaSave.getUsuario().getId())){
            throw new RegraDeNegocioException("pessoa.jaExist");
        }
        return pessoaSave.getId();
    }

    public PessoaDto findPessoaById(Long id){
        return pessoaRepository.findPessoaById(id);
    }

    public void delete(Long id){
        var pessoaDelete = modelMapper.map(findPessoaById(id), Pessoa.class);
        pessoaRepository.delete(pessoaDelete);
    }
}
