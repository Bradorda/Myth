package br.com.bradorda.myth.repositories;

import br.com.bradorda.myth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByPessoaEmail(String email);

}
