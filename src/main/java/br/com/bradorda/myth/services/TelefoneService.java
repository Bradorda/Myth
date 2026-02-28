package br.com.bradorda.myth.services;

import br.com.bradorda.myth.entities.Endereco;
import br.com.bradorda.myth.entities.Telefone;
import br.com.bradorda.myth.repositories.TelefoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;

    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    public List<Telefone> salvarTelefones(List<Telefone> telefones){
        try{
            return telefoneRepository.saveAll(telefones);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel salvar os Telefones",e.getCause());
        }
    }

    public List<Telefone> buscarPorPessoaId(Long id){
        return telefoneRepository.findByPessoaId(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar os telefones pelo ID da pessoa"));
    }

}
