package br.com.bradorda.myth.repositories;

import br.com.bradorda.myth.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TelefoneRepository extends JpaRepository<Telefone,Long> {

    Optional<List<Telefone>> findByPessoaId(Long id);

}
