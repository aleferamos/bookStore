package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.controllers.dto.endereco.EnderecoFormDto;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
@Getter
public class Endereco extends Entidade {

    private String endereco;

    private String cep;

    private String complemento;

    private int numero;

    public Endereco(EnderecoFormDto endereco) {
        this.endereco = endereco.getEndereco();
        this.cep = endereco.getCep();
        this.complemento = endereco.getComplemento();
        this.numero = endereco.getNumero();
    }
}
