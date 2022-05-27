package br.com.aleferamos.BookStore.controllers.dto.pessoa;

import br.com.aleferamos.BookStore.controllers.dto.endereco.EnderecoDto;
import br.com.aleferamos.BookStore.controllers.dto.usuario.UsuarioDto;

import br.com.aleferamos.BookStore.models.Endereco;
import br.com.aleferamos.BookStore.models.Usuario;
public class PessoaDto {

    private Long id;
    private String nome;
    private UsuarioDto usuario;
    private EnderecoDto endereco;

    public PessoaDto(Long id, String nome, Usuario usuario, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.usuario = new UsuarioDto(usuario);
        this.endereco = new EnderecoDto(endereco);
    }

    @Override
    public String toString() {
        return "PessoaDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", usuario=" + usuario +
                ", endereco=" + endereco +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }
}
