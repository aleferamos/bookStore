package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.controllers.dto.livro.LivroFormDto;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "LIVRO")
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

    public Livro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
