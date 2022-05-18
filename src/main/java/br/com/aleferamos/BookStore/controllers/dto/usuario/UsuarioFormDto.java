package br.com.aleferamos.BookStore.controllers.dto.usuario;

import br.com.aleferamos.BookStore.models.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsuarioFormDto {

    private String email;

    private String senha;

    public UsuarioFormDto(Usuario usuario) {
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}
