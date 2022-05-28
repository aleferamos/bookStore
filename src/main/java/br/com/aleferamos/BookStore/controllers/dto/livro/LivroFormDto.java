package br.com.aleferamos.BookStore.controllers.dto.livro;

import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoFormDto;

public class LivroFormDto {

    private Long id;
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private String edicao;
    private int anoPublicacao;
    private ProdutoFormDto produto;

    public LivroFormDto(Long id, String titulo, String autor, int numeroPaginas, String edicao, int anoPublicacao, ProdutoFormDto produto) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.produto = produto;
    }

    public LivroFormDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ProdutoFormDto getProduto() {
        return produto;
    }

    public void setProduto(ProdutoFormDto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "LivroFormDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", edicao='" + edicao + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", produto=" + produto +
                '}';
    }
}
