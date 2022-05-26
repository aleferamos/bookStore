package br.com.aleferamos.BookStore.controllers.dto.usuario;

import br.com.aleferamos.BookStore.Utils.Enum.PerfilUsuarioEnum;
import br.com.aleferamos.BookStore.models.Usuario;
import lombok.Getter;

public class UsuarioDto {

    private Long id;

    private String email;

    private String senha;

    private PerfilUsuarioEnum perfil;

    public UsuarioDto(Usuario usuario) {
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.perfil = usuario.getPerfil();
        this.id = usuario.getId();
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfil=" + perfil +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilUsuarioEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuarioEnum perfil) {
        this.perfil = perfil;
    }
}
