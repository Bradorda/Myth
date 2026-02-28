package br.com.bradorda.myth.configs.security;

import br.com.bradorda.myth.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthConfig implements UserDetailsService {

    private final UserRepository userRepository;

    public UserAuthConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByPessoaEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("E-mail %s não foi encontrado ", username)));

    }
}
