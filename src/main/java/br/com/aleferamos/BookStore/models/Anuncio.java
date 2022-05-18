package br.com.aleferamos.BookStore.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "anuncio")
@Getter
@Setter
public class Anuncio extends Entidade {

    private String descricao;

    private String nomeImagem;

    private LocalDate data;

    private LocalDate dataModificacao;

    @OneToOne
    @JoinColumn(name = "id_livro", foreignKey = @ForeignKey(name = "anuncio_livro"))
    private Livro livro;

    @OneToOne
    @JoinColumn(name = "id_pessoa", foreignKey = @ForeignKey(name = "anuncio_pessoa"))
    private Pessoa pessoa;
}
