package br.com.aleferamos.BookStore.controllers.dto.anuncio;

import br.com.aleferamos.BookStore.Utils.Enum.StatusAnuncioEnum;
import br.com.aleferamos.BookStore.models.Livro;
import br.com.aleferamos.BookStore.models.Pessoa;
import java.time.LocalDate;

public class AnuncioDto {

    private Long id;
    private String descricao;
    private String nomeImagem;
    private LocalDate data;
    private LocalDate dataModificacao;
    private Double preco;
    private int curtida;
    private StatusAnuncioEnum status;
    private Livro livro;
    private Pessoa pessoa;

    public AnuncioDto(Long id ,String descricao, String nomeImagem, LocalDate data, LocalDate dataModificacao, Double preco,
                      int curtida, Livro livro, Pessoa pessoa) {
        this.id = id;
        this.descricao = descricao;
        this.nomeImagem = nomeImagem;
        this.data = data;
        this.dataModificacao = dataModificacao;
        this.preco = preco;
        this.curtida = curtida;
        this.status = StatusAnuncioEnum.CREATED;
        this.livro = livro;
        this.pessoa = pessoa;
    }

    public AnuncioDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public StatusAnuncioEnum getStatus() {
        return status;
    }

    public void setStatus(StatusAnuncioEnum status) {
        this.status = status;
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
