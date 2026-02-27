package br.com.bradorda.myth.configs;

import br.com.bradorda.myth.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthConfig implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByPessoaEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("E-mail %s não foi encontrado ", username)));

    }
}
