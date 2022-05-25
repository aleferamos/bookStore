package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoFormDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")
@Getter
@NoArgsConstructor
public class Produto extends Entidade{

    @Column(name = "codigo_barra")
    private String codigoBarra;

    public Produto(ProdutoFormDto produtoFormDto) {
        this.codigoBarra = produtoFormDto.getCodigoBarra();
    }

}
