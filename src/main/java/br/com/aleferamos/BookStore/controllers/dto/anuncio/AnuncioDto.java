package br.com.aleferamos.BookStore.controllers.dto.anuncio;

import br.com.aleferamos.BookStore.models.Livro;
import br.com.aleferamos.BookStore.models.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnuncioDto {

    private String descricao;

    private String nomeImagem;

    private LocalDate data;

    private LocalDate dataModificacao;

    private Double preco;

    private int curtida;

    private Livro livro;

    private Pessoa pessoa;
}
