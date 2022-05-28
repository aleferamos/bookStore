package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoDto;
import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoFormDto;
import br.com.aleferamos.BookStore.exceptions.RegistroNaoEncontradoException;
import br.com.aleferamos.BookStore.models.Produto;
import br.com.aleferamos.BookStore.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoDto findProdutoById(Long id){
        return produtoRepository.findProdutoById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("produto.NaoEncontrado"));
    }

    public Long save(ProdutoFormDto produtoFormDto){
        return produtoRepository.save(new Produto(produtoFormDto)).getId();
    }
}
