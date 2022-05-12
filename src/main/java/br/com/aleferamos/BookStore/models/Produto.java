package br.com.aleferamos.BookStore.models;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "codigo_barra")
    private String codigoBarra;

    @Column(name = "preco")
    private double preco;
}
