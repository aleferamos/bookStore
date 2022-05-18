package br.com.aleferamos.BookStore.repositories;

import br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaDto;
import br.com.aleferamos.BookStore.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    @Query("SELECT NEW br.com.aleferamos.BookStore.controllers.dto.pessoa.PessoaDto(p.id, p.nome, p.usuario, p.endereco) " +
            "FROM Pessoa p WHERE p.id = :id")
    PessoaDto findPessoaById(Long id);
}