package br.com.aleferamos.BookStore.controllers.dto.pessoa;

import br.com.aleferamos.BookStore.controllers.dto.endereco.EnderecoFormDto;
import br.com.aleferamos.BookStore.controllers.dto.usuario.UsuarioFormDto;
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

@Getter
@NoArgsConstructor
@Setter
public class PessoaFormDto {

    private Long id;

    private String nome;

    private UsuarioFormDto usuario;

    private EnderecoFormDto endereco;

}
