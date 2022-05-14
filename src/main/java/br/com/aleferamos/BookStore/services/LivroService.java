package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.controllers.dto.livro.LivroDto;
import br.com.aleferamos.BookStore.controllers.dto.livro.LivroFormDto;
import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoFormDto;
import br.com.aleferamos.BookStore.exceptions.RegistroNaoEncontradoException;
import br.com.aleferamos.BookStore.models.Livro;
import br.com.aleferamos.BookStore.models.Produto;
import br.com.aleferamos.BookStore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Long save(LivroFormDto livroFormDto){
        return livroRepository.save(new Livro(livroFormDto)).getId();
    }

    public LivroDto findLivroById (Long id){
        return livroRepository.findLivroById(id).orElseThrow(() -> new RegistroNaoEncontradoException("livro.NaoEncontrado"));
    }
}
