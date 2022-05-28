package br.com.aleferamos.BookStore.controllers.dto.produto;

public class ProdutoFormDto {

    private Long id;
    private String codigoBarra;

    public ProdutoFormDto(Long id, String codigoBarra) {
        this.id = id;
        this.codigoBarra = codigoBarra;
    }

    public ProdutoFormDto() {
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
