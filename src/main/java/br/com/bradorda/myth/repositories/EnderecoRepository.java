package br.com.bradorda.myth.repositories;

import br.com.bradorda.myth.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

    Optional<Endereco> findByPessoaId(Long id);

}
