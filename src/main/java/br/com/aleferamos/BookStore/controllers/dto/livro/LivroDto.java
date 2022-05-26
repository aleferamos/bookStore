package br.com.aleferamos.BookStore.controllers.dto.livro;

import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoDto;
import br.com.aleferamos.BookStore.models.Produto;
import lombok.Getter;

public class LivroDto {

    private String titulo;

    private String autor;

    private int numeroPaginas;

    private String edicao;

    private int anoPublicacao;

    private ProdutoDto produto;

    public LivroDto(String titulo, String autor, int numeroPaginas, String edicao, int anoPublicacao, Produto produto) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.produto = new ProdutoDto(produto);
    }

    public LivroDto(String titulo, String autor, int numeroPaginas, String edicao, int anoPublicacao, ProdutoDto produto) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.produto = produto;
    }

    public LivroDto() {
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

    public ProdutoDto getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDto produto) {
        this.produto = produto;
    }
}
