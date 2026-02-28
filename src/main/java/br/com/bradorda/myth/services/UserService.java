package br.com.bradorda.myth.services;

import br.com.bradorda.myth.entities.User;
import br.com.bradorda.myth.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User salvar(User user){
        try {
            return userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException("Não foi possivel salvar o User",e.getCause());
        }
    }

}
