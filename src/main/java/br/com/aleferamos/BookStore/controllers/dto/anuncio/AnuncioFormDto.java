package br.com.aleferamos.BookStore.controllers.dto.anuncio;

import br.com.aleferamos.BookStore.controllers.dto.livro.LivroFormDto;
import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaFormDto;
import br.com.aleferamos.BookStore.exceptions.RegraDeNegocioException;
import java.time.LocalDate;


public class    AnuncioFormDto {

    private String descricao;

    private String nomeImagem;

    private LocalDate data;

    private LocalDate dataModificacao;

    private Double preco;

    private int curtida;

    private LivroFormDto livro;

    private PessoaFormDto pessoa;

    public AnuncioFormDto() {
    }

    public AnuncioFormDto(String descricao, String nomeImagem, LocalDate data, LocalDate dataModificacao, Double preco, int curtida, LivroFormDto livro, PessoaFormDto pessoa) {
        this.descricao = descricao;
        this.nomeImagem = nomeImagem;
        this.data = LocalDate.now();
        this.dataModificacao = dataModificacao;
        this.preco = preco;
        this.curtida = curtida;
        this.livro = livro;
        this.pessoa = pessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if(descricao.isEmpty()){
            throw new RegraDeNegocioException("descricao.isEmpty");
        }
        this.descricao = descricao;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        if(nomeImagem.contains("null")){
            throw new RegraDeNegocioException("nomeImage.isEmpty");
        }

        this.nomeImagem = nomeImagem;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getCurtida() {
        return curtida;
    }

    public void setCurtida(int curtida) {
        this.curtida = curtida;
    }

    public LivroFormDto getLivro() {
        return livro;
    }

    public void setLivro(LivroFormDto livro) {
        if(livro.getTitulo().isEmpty() || livro.getAutor().isEmpty()){
            throw new RegraDeNegocioException("livro.isEmpty");
        }
        this.livro = livro;
    }

    public PessoaFormDto getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaFormDto pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "AnuncioFormDto{" +
                "descricao='" + descricao + '\'' +
                ", nomeImagem='" + nomeImagem + '\'' +
                ", data=" + data +
                ", dataModificacao=" + dataModificacao +
                ", preco=" + preco +
                ", curtida=" + curtida +
                ", livro=" + livro +
                ", pessoa=" + pessoa +
                '}';
    }
}
