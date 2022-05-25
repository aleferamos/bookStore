package br.com.aleferamos.BookStore.controllers.dto.livro;

import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoFormDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroFormDto {

    private Long id;

    private String titulo;

    private String autor;

    private int numeroPaginas;

    private String edicao;

    private int anoPublicacao;

    private ProdutoFormDto produto;
}
