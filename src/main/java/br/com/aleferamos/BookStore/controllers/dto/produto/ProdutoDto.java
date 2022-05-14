package br.com.aleferamos.BookStore.controllers.dto.produto;

import br.com.aleferamos.BookStore.models.Produto;
import lombok.Getter;

@Getter
public class ProdutoDto {

    private Long id;
    private String codigoBarra;

    private double preco;

    public ProdutoDto(String codigoBarra, double preco) {
        this.codigoBarra = codigoBarra;
        this.preco = preco;
    }

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.codigoBarra = produto.getCodigoBarra();
        this.preco = produto.getPreco();
    }
}
