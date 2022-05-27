package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.Utils.Enum.PerfilUsuarioEnum;
import br.com.aleferamos.BookStore.controllers.dto.usuario.UsuarioFormDto;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
public class Usuario extends Entidade {

    private String email;

    private String senha;
    private PerfilUsuarioEnum perfil;

    public Usuario(UsuarioFormDto usuarioFormDto) {
        this.email = usuarioFormDto.getEmail();
        this.senha = usuarioFormDto.getSenha();
        this.perfil = PerfilUsuarioEnum.USER;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfil=" + perfil +
                '}';
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public PerfilUsuarioEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuarioEnum perfil) {
        this.perfil = perfil;
    }
}