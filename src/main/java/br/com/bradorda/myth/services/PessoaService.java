package br.com.bradorda.myth.services;

import br.com.bradorda.myth.entities.Pessoa;
import org.springframework.transaction.annotation.Transactional;
import br.com.bradorda.myth.exceptions.PessoaNaoEncontradaException;
import br.com.bradorda.myth.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @Transactional(readOnly = true)
    public Pessoa buscarPorId(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
    }
}
