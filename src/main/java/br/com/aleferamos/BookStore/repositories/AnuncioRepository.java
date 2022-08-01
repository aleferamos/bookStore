package br.com.aleferamos.BookStore.repositories;

import br.com.aleferamos.BookStore.Utils.Enum.StatusAnuncioEnum;
import br.com.aleferamos.BookStore.controllers.dto.anuncio.AnuncioDto;
import br.com.aleferamos.BookStore.models.Anuncio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    @Query("SELECT NEW br.com.aleferamos.BookStore.controllers.dto.anuncio.AnuncioDto(a.id, a.descricao, a.nomeImagem," +
            " a.data, a.dataModificacao, a.preco, a.curtida, a.status ,a.livro, a.pessoa) " +
            "FROM Anuncio a WHERE a.livro.titulo LIKE CONCAT('%',:nome,'%') OR :nome IS NULL")
    Page<AnuncioDto> findAllAnuncio(Pageable pageable, @Param("nome") String nome);

    @Query("SELECT NEW br.com.aleferamos.BookStore.controllers.dto.anuncio.AnuncioDto(a.id, a.descricao, a.nomeImagem, " +
            "a.data, a.dataModificacao, a.preco, a.curtida, a.status ,a.livro, a.pessoa) FROM Anuncio a WHERE a.id = :id")
    Optional<AnuncioDto> findAnuncioById(Long id);

    @Query("SELECT a FROM Anuncio a "
            + "WHERE (LOWER(a.livro.titulo) like CONCAT('%', LOWER(:nome), '%') OR :nome IS NULL) "
            + "AND (:menorPreco IS NULL OR a.preco >= :menorPreco) AND (:maiorPreco IS NULL OR a.preco <= :maiorPreco)")
    List<Anuncio> findAnuncioPorNomeEPreco
            (@Param("nome") String titulo,
             @Param("menorPreco") Double menorPreco,
             @Param("maiorPreco") Double maiorPreco);

    Page<Anuncio> findAllByStatus(Pageable pageable, StatusAnuncioEnum status);
}
