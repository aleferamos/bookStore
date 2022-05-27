package br.com.aleferamos.BookStore.repositories;

import br.com.aleferamos.BookStore.controllers.dto.livro.LivroDto;
import br.com.aleferamos.BookStore.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT NEW br.com.aleferamos.BookStore.controllers.dto.livro.LivroDto(l.titulo, l.autor, l.numeroPaginas, " +
            "l.edicao, l.anoPublicacao, l.produto) FROM Livro l WHERE l.id = :id")
    Optional<LivroDto> findLivroById(Long id);
}
