package br.com.aleferamos.BookStore.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carrinho")
public class Carrinho extends Entidade {

    @OneToMany()
    private List<Livro> livros;

    public Carrinho(List<Livro> livros) {
        this.livros = livros;
    }

    public Carrinho() {
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
