package br.com.aleferamos.BookStore.controllers.dto.pessoa;

import br.com.aleferamos.BookStore.controllers.dto.endereco.EnderecoDto;
import br.com.aleferamos.BookStore.controllers.dto.usuario.UsuarioDto;

import br.com.aleferamos.BookStore.models.Endereco;
import br.com.aleferamos.BookStore.models.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
