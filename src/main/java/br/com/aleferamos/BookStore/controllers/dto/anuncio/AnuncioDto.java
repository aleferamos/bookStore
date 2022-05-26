package br.com.aleferamos.BookStore.controllers.dto.anuncio;

import br.com.aleferamos.BookStore.models.Livro;
import br.com.aleferamos.BookStore.models.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

public class AnuncioDto {

    private String descricao;

    private String nomeImagem;

    private LocalDate data;

    private LocalDate dataModificacao;

    private Double preco;

    private int curtida;

    private Livro livro;

    private Pessoa pessoa;

    public AnuncioDto(String descricao, String nomeImagem, LocalDate data, LocalDate dataModificacao, Double preco,
                      int curtida, Livro livro, Pessoa pessoa) {
        this.descricao = descricao;
        this.nomeImagem = nomeImagem;
        this.data = data;
        this.dataModificacao = dataModificacao;
        this.preco = preco;
        this.curtida = curtida;
        this.livro = livro;
        this.pessoa = pessoa;
    }

    public AnuncioDto() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
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

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
