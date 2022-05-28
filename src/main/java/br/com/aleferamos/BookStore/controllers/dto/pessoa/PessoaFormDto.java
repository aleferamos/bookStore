package br.com.aleferamos.BookStore.controllers.dto.pessoa;

import br.com.aleferamos.BookStore.controllers.dto.endereco.EnderecoFormDto;
import br.com.aleferamos.BookStore.controllers.dto.usuario.UsuarioFormDto;
import br.com.aleferamos.BookStore.exceptions.RegraDeNegocioException;
import br.com.aleferamos.BookStore.models.Endereco;
import br.com.aleferamos.BookStore.models.Pessoa;
import br.com.aleferamos.BookStore.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class PessoaFormDto {

    private Long id;

    private String nome;

    private UsuarioFormDto usuario;

    private EnderecoFormDto endereco;

    public PessoaFormDto() {
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
