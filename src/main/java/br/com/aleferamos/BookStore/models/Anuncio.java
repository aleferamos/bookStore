package br.com.aleferamos.BookStore.models;

import br.com.aleferamos.BookStore.Utils.Enum.StatusAnuncioEnum;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "anuncio")
public class Anuncio extends Entidade {

    private String descricao;

    private String nomeImagem;

    private LocalDate data;

    private LocalDate dataModificacao;

    private Double preco;

    private int curtida;

    private StatusAnuncioEnum status;

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_livro", foreignKey = @ForeignKey(name = "anuncio_livro"))
    private Livro livro;

    @OneToOne
    @JoinColumn(name = "id_pessoa", foreignKey = @ForeignKey(name = "anuncio_pessoa"))
    private Pessoa pessoa;


    public Anuncio(String descricao, String nomeImagem, LocalDate data, LocalDate dataModificacao, Double preco, Livro livro, Pessoa pessoa) {
        this.descricao = descricao;
        this.nomeImagem = nomeImagem;
        this.data = LocalDate.now();
        this.dataModificacao = dataModificacao;
        this.preco = preco;
        this.curtida = 0;
        this.livro = livro;
        this.pessoa = pessoa;
        this.status = StatusAnuncioEnum.CREATED;
    }

    public Anuncio() {
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

    @Override
    public String toString() {
        return "Anuncio{" +
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
