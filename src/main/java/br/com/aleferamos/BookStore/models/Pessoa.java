package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaFormDto;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
@Getter
public class Pessoa extends Entidade {

    private String nome;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "pessoa_usuario"))
    private Usuario usuario;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_endereco", foreignKey = @ForeignKey(name = "pessoa_endereco"))
    private Endereco endereco;

    public Pessoa(PessoaFormDto pessoa) {
        this.nome = pessoa.getNome();
        this.usuario = new Usuario(pessoa.getUsuario());
        this.endereco = new Endereco(pessoa.getEndereco());
    }
}
