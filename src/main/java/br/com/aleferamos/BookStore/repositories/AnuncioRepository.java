package br.com.aleferamos.BookStore.repositories;

import br.com.aleferamos.BookStore.controllers.dto.anuncio.AnuncioDto;
import br.com.aleferamos.BookStore.models.Anuncio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    @Query("SELECT NEW br.com.aleferamos.BookStore.controllers.dto.anuncio.AnuncioDto(a.descricao, a.nomeImagem, a.data, " +
            "a.dataModificacao, a.preco, a.curtida, a.livro, a.pessoa) FROM Anuncio a")
    Page<AnuncioDto> findAllAnuncio(Pageable pageable);
}
