package br.com.bradorda.myth.configs.security;

import br.com.bradorda.myth.entities.User;
import br.com.bradorda.myth.repositories.PessoaRepository;
import br.com.bradorda.myth.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthConfig implements UserDetailsService {

    private final UserRepository userRepository;
    private final PessoaRepository pessoaRepository;

    public UserAuthConfig(UserRepository userRepository, PessoaRepository pessoaRepository) {
        this.userRepository = userRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByPessoaEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("E-mail %s não foi encontrado ", username)));

        user.setPessoa(pessoaRepository.findByEmail(username));

        return user;
    }
}
