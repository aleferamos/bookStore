package br.com.aleferamos.BookStore.repositories;

import br.com.aleferamos.BookStore.models.ResetPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, Integer>{

    @Transactional(readOnly = true)
    Optional<ResetPasswordToken> findByToken(@Param("token") String token);

    @Transactional(readOnly = true)
    @Query(value = "SELECT spt FROM ResetPasswordToken spt JOIN spt.user user WHERE user.email = :email")
    public Optional<ResetPasswordToken> findByEmail(@Param("email") String email);


}