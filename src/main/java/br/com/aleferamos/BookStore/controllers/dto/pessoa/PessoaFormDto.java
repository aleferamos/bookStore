package br.com.aleferamos.BookStore.controllers.dto.pessoa;

import br.com.aleferamos.BookStore.controllers.dto.endereco.EnderecoFormDto;
import br.com.aleferamos.BookStore.controllers.dto.usuario.UsuarioFormDto;
import br.com.aleferamos.BookStore.exceptions.RegraDeNegocioException;

public class PessoaFormDto {

    private Long id;

    private String nome;

    private UsuarioFormDto usuario;

    private EnderecoFormDto endereco;

    public PessoaFormDto() {
    }

    public PessoaFormDto(Long id, String nome, UsuarioFormDto usuario, EnderecoFormDto endereco) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.endereco = endereco;
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
        if(nome.isEmpty()){
            throw new RegraDeNegocioException("nome.isEmpty");
        }
        this.nome = nome;
    }

    public UsuarioFormDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioFormDto usuario) {
        this.usuario = usuario;
    }

    public EnderecoFormDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoFormDto endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "PessoaFormDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", usuario=" + usuario +
                ", endereco=" + endereco +
                '}';
    }
}
