package br.com.aleferamos.BookStore.repositories;

import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaDto;
import br.com.aleferamos.BookStore.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    @Query("SELECT NEW br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaDto(p.id, p.nome, p.usuario, p.endereco) " +
            "FROM Pessoa p WHERE p.id = :id")
    PessoaDto findPessoaById(Long id);

    @Query("SELECT DISTINCT CASE " +
            "WHEN COUNT(pessoa) > 0 THEN true " +
            "ELSE false " +
            "END " +
            "FROM Pessoa pessoa " +
            "WHERE (pessoa.usuario.email = :email) " +
            "AND (pessoa.usuario.id <> :id OR :id IS NULL)")
    Boolean existEmail(@Param(value = "email") String email, @Param(value="id") Long id);
}