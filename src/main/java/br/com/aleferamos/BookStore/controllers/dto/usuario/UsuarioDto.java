package br.com.aleferamos.BookStore.controllers.dto.usuario;

import br.com.aleferamos.BookStore.Utils.Enum.PerfilUsuarioEnum;
import br.com.aleferamos.BookStore.models.Usuario;
import lombok.Getter;

@Getter
public class UsuarioDto {

    private String email;

    private String senha;

    private PerfilUsuarioEnum perfil;

    public UsuarioDto(Usuario usuario) {
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.perfil = usuario.getPerfil();
    }
}
