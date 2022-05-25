package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaFormDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
public class Pessoa extends Entidade {

    private String nome;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "pessoa_usuario"))
    private Usuario usuario;

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_endereco", foreignKey = @ForeignKey(name = "pessoa_endereco"))
    private Endereco endereco;

    public Pessoa(PessoaFormDto pessoa) {
        this.nome = pessoa.getNome();
        this.usuario = new Usuario(pessoa.getUsuario());
        this.endereco = new Endereco(pessoa.getEndereco());
    }
}
