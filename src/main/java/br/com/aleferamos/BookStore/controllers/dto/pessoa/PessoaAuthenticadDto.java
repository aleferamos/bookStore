package br.com.aleferamos.BookStore.controllers.dto.pessoa;

import br.com.aleferamos.BookStore.controllers.dto.endereco.EnderecoAuthenticadDto;
import br.com.aleferamos.BookStore.controllers.dto.usuario.UsuarioAuthenticadDto;
import br.com.aleferamos.BookStore.models.Pessoa;

public class PessoaAuthenticadDto {

    private Long id;

    private String nome;

    private UsuarioAuthenticadDto usuario;

    private EnderecoAuthenticadDto endereco;

    public PessoaAuthenticadDto(Long id, String nome, UsuarioAuthenticadDto usuario, EnderecoAuthenticadDto endereco) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.endereco = endereco;
    }

    public PessoaAuthenticadDto(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.usuario = new UsuarioAuthenticadDto(pessoa.getUsuario());
        this.endereco = new EnderecoAuthenticadDto(pessoa.getEndereco());
    }

    public PessoaAuthenticadDto() {
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

    public UsuarioAuthenticadDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioAuthenticadDto usuario) {
        this.usuario = usuario;
    }

    public EnderecoAuthenticadDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoAuthenticadDto endereco) {
        this.endereco = endereco;
    }
}
