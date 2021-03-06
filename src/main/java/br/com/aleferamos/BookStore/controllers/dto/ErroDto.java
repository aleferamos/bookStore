package br.com.aleferamos.BookStore.controllers.dto;

import lombok.Getter;

public class ErroDto {
    private String erro;
    private String propriedade;

    public ErroDto(String erro, String propriedade) {
        super();
        this.erro = erro;
        this.propriedade = propriedade;
    }

    public ErroDto(String erro) {
        this.erro = erro;
    }

    public String getErro() {
        return erro;
    }

    public String getPropriedade() {
        return propriedade;
    }
}