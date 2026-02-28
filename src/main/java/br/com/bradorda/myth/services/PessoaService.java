package br.com.bradorda.myth.services;

import br.com.bradorda.myth.entities.Pessoa;
import br.com.bradorda.myth.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa salvar(Pessoa pessoa){
        try{
            return pessoaRepository.save(pessoa);
        }catch (Exception e){
            throw new RuntimeException("Não foi possivel salvar a pessoa",e.getCause());
        }
    }

    public Pessoa buscarPorId(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Não foi possivel encontrar a pessoa por id"));
    }
}
