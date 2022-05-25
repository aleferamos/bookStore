package br.com.aleferamos.BookStore.controllers.dto.produto;

import br.com.aleferamos.BookStore.models.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoFormDto {

    private Long id;

    private String codigoBarra;

}
