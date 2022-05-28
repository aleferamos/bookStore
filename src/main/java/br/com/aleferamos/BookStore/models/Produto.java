package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoFormDto;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")
public class Produto extends Entidade{

    @Column(name = "codigo_barra")
    private String codigoBarra;

    public Produto() {
    }

    public Produto(ProdutoFormDto produtoFormDto) {
        this.codigoBarra = produtoFormDto.getCodigoBarra();
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
}
