package br.com.aleferamos.BookStore.controllers.dto.livro;

import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoDto;
import br.com.aleferamos.BookStore.models.Produto;
import lombok.Getter;

@Getter
public class LivroDto {

    private String titulo;

    private String autor;

    private int numeroPaginas;

    private String edicao;

    private int anoPublicacao;

    private ProdutoDto produto;

    public LivroDto(String titulo, String autor, int numeroPaginas, String edicao, int anoPublicacao, Produto produto) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.produto = new ProdutoDto(produto);
    }
}
