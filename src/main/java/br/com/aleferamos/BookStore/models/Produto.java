package br.com.aleferamos.BookStore.models;

import javax.persistence.*;


@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column(name = "preco")
    private double preco;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "codigoBarra")
    private String codigoDeBarra;

}

