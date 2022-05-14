package br.com.aleferamos.BookStore.controllers.dto.produto;

import br.com.aleferamos.BookStore.models.Produto;
import lombok.Getter;

@Getter
public class ProdutoFormDto {

    private Long id;

    private String codigoBarra;

    private double preco;

}
