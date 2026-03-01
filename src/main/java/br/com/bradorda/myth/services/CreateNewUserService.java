package br.com.bradorda.myth.services;

import br.com.bradorda.myth.dtos.request.RegisterUserRequest;
import br.com.bradorda.myth.dtos.response.RegisterUserResponse;
import br.com.bradorda.myth.entities.Pessoa;
import br.com.bradorda.myth.entities.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CreateNewUserService {

    private final PessoaService pessoaService;
    private final PasswordEncoder passwordEncoder;

    public CreateNewUserService(PessoaService pessoaService, PasswordEncoder passwordEncoder) {
        this.pessoaService = pessoaService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public RegisterUserResponse createNewUser(RegisterUserRequest request) {

        Pessoa pessoa = request.pessoa();

        pessoa.setEndereco(request.endereco());
        pessoa.getEndereco().setPessoa(pessoa);

        pessoa.setTelefones(request.telefones());
        pessoa.getTelefones().forEach(t -> t.setPessoa(pessoa));

        User user = new User();
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setPessoa(pessoa);
        pessoa.setUser(user);

        Pessoa pessoaSaved = pessoaService.salvar(pessoa);

        return new RegisterUserResponse(pessoaSaved.getNome(), pessoaSaved.getEmail());
    }

}
