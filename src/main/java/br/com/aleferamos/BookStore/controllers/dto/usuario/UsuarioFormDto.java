package br.com.aleferamos.BookStore.controllers.dto.usuario;

import br.com.aleferamos.BookStore.exceptions.RegraDeNegocioException;
import br.com.aleferamos.BookStore.models.Usuario;
public class UsuarioFormDto {

    private Long id;
    private String email;
    private String senha;

    public UsuarioFormDto(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public UsuarioFormDto(Long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioFormDto() {
    }

    public void setSenha(String senha) {
        if(senha.isEmpty()){
            throw new RegraDeNegocioException("senha.IsEmpty");
        }
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
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
        if(email.isEmpty()){
            throw new RegraDeNegocioException("email.IsEmpty");
        }

        this.email = email;
    }
}
