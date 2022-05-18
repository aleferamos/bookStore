package br.com.aleferamos.BookStore.repositories;

import br.com.aleferamos.BookStore.models.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
}
