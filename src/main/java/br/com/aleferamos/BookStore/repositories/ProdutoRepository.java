package br.com.aleferamos.BookStore.repositories;

import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoDto;
import br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoFormDto;
import br.com.aleferamos.BookStore.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT NEW br.com.aleferamos.BookStore.controllers.dto.produto.ProdutoDto(p.codigoBarra) FROM Produto p WHERE p.id = :id")
    Optional<ProdutoDto> findProdutoById(Long id);



}
