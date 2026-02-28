package br.com.bradorda.myth.services;

import br.com.bradorda.myth.entities.Endereco;
import br.com.bradorda.myth.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco salvar(Endereco endereco){
        try{
            return enderecoRepository.save(endereco);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel salvar Endereço",e.getCause());
        }
    }

    public Endereco buscarPorPessoaId(Long id){
        return enderecoRepository.findByPessoaId(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o endereço pelo ID da pessoa"));
    }

}
