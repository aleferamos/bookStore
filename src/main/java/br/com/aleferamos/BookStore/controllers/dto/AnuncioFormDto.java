package br.com.aleferamos.BookStore.controllers.dto;

import br.com.aleferamos.BookStore.controllers.dto.livro.LivroFormDto;
import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaFormDto;
import br.com.aleferamos.BookStore.models.Livro;
import br.com.aleferamos.BookStore.models.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class    AnuncioFormDto {

    private String descricao;

    private String nomeImagem;

    private LocalDate data;

    private LocalDate dataModificacao;

    private LivroFormDto livro;

    private PessoaFormDto pessoa;
}
