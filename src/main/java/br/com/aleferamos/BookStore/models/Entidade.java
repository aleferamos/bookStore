package br.com.aleferamos.BookStore.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



@MappedSuperclass
public class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

