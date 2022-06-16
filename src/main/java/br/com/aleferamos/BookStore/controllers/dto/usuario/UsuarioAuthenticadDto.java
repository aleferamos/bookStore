package br.com.aleferamos.BookStore.controllers.dto.usuario;

import br.com.aleferamos.BookStore.Utils.Enum.PerfilUsuarioEnum;
import br.com.aleferamos.BookStore.models.Usuario;

public class UsuarioAuthenticadDto {

    private Long id;
    private String email;
    private PerfilUsuarioEnum perfil;

    public UsuarioAuthenticadDto(Long id, String email, PerfilUsuarioEnum perfil) {
        this.id = id;
        this.email = email;
        this.perfil = perfil;
    }

    public UsuarioAuthenticadDto() {
    }

    public UsuarioAuthenticadDto(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.perfil = usuario.getPerfil();
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

    public PerfilUsuarioEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuarioEnum perfil) {
        this.perfil = perfil;
    }
}
