package br.com.aleferamos.BookStore.controllers.dto.endereco;

import br.com.aleferamos.BookStore.models.Endereco;
import lombok.Getter;

@Getter
public class EnderecoDto {

    private String endereco;

    private String cep;

    private String complemento;

    private int numero;

    public EnderecoDto(Endereco endereco) {
        this.endereco = endereco.getEndereco();
        this.cep = endereco.getCep();
        this.complemento = endereco.getComplemento();
        this.numero = endereco.getNumero();
    }
}
