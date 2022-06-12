package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.Utils.Enum.PerfilUsuarioEnum;
import br.com.aleferamos.BookStore.controllers.dto.usuario.UsuarioFormDto;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "usuario")
public class Usuario extends Entidade implements UserDetails {

    private String email;

    private String senha;
    private PerfilUsuarioEnum perfil;

    public Usuario(UsuarioFormDto usuarioFormDto) {
        this.email = usuarioFormDto.getEmail();
        this.senha = usuarioFormDto.getSenha();
        this.perfil = PerfilUsuarioEnum.USER;
    }

    public Usuario() {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
