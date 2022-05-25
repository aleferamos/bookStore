package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.controllers.dto.AnuncioFormDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "anuncio")
@NoArgsConstructor
public class Anuncio extends Entidade {

    private String descricao;

    private String nomeImagem;

    private LocalDate data;

    private LocalDate dataModificacao;

    private Double preco;

    private int curtida;

    public Anuncio(String descricao, String nomeImagem, LocalDate data, LocalDate dataModificacao, Double preco, Livro livro, Pessoa pessoa) {
        this.descricao = descricao;
        this.nomeImagem = nomeImagem;
        this.data = LocalDate.now();
        this.dataModificacao = dataModificacao;
        this.preco = preco;
        this.curtida = 0;
        this.livro = livro;
        this.pessoa = pessoa;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_livro", foreignKey = @ForeignKey(name = "anuncio_livro"))
    private Livro livro;

    @OneToOne
    @JoinColumn(name = "id_pessoa", foreignKey = @ForeignKey(name = "anuncio_pessoa"))
    private Pessoa pessoa;

}
