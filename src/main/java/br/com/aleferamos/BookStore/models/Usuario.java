package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.Utils.Enum.PerfilUsuarioEnum;
import br.com.aleferamos.BookStore.controllers.dto.usuario.UsuarioFormDto;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Getter
public class Usuario extends Entidade {

    private String email;

    private String senha;

    private PerfilUsuarioEnum perfil;

    public Usuario(UsuarioFormDto usuarioFormDto) {
        this.email = usuarioFormDto.getEmail();
        this.senha = usuarioFormDto.getSenha();
        this.perfil = PerfilUsuarioEnum.USER;
    }
}
