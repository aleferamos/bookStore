package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.controllers.dto.livro.LivroFormDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "LIVRO")
@Getter
@NoArgsConstructor
public class Livro extends Entidade {

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "numero_paginas")
    private int numeroPaginas;

    @Column(name = "edicao")
    private String edicao;

    @Column(name = "ano_publicacao")
    private int anoPublicacao;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_produto", foreignKey = @ForeignKey(name = "livro_produto"))
    private Produto produto;

    public Livro(LivroFormDto livroFormDto) {
        this.titulo = livroFormDto.getTitulo();
        this.autor = livroFormDto.getAutor();
        this.numeroPaginas = livroFormDto.getNumeroPaginas();
        this.edicao = livroFormDto.getEdicao();
        this.anoPublicacao = livroFormDto.getAnoPublicacao();
        this.produto = new Produto(livroFormDto.getProduto());
    }
}
