package br.com.aleferamos.BookStore.controllers.dto.produto;

import br.com.aleferamos.BookStore.models.Produto;
import lombok.Getter;

public class ProdutoDto {

    private Long id;
    private String codigoBarra;

    public ProdutoDto(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.codigoBarra = produto.getCodigoBarra();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
}
