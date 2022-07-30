package br.com.aleferamos.BookStore.models;



import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
public class Pagamento extends Entidade{


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "carrinho")
    private Carrinho cart;

    @OneToOne
    @JoinColumn(name = "pessoa")
    private Pessoa pessoa;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "total")
    private Double total;

    public Pagamento(Carrinho cart, Pessoa pessoa, LocalDate dataPagamento, Double total) {
        this.cart = cart;
        this.pessoa = pessoa;
        this.dataPagamento = dataPagamento;
        this.total = total;
    }

    public Pagamento() {
    }


    public Carrinho getCart() {
        return cart;
    }

    public void setCart(Carrinho cart) {
        this.cart = cart;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
