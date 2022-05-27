package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaFormDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "pessoa")

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

    public Pessoa(String nome, Usuario usuario, Endereco endereco) {
        this.nome = nome;
        this.usuario = usuario;
        this.endereco = endereco;
    }

    public Pessoa() {
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", usuario=" + usuario +
                ", endereco=" + endereco +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
