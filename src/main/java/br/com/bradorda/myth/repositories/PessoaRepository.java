package br.com.bradorda.myth.repositories;

import br.com.bradorda.myth.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
