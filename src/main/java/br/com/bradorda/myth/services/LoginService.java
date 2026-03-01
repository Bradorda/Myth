package br.com.bradorda.myth.services;


import br.com.bradorda.myth.configs.security.TokenConfig;
import br.com.bradorda.myth.dtos.request.LoginRequest;
import br.com.bradorda.myth.dtos.response.LoginResponse;
import br.com.bradorda.myth.entities.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public LoginService(AuthenticationManager authenticationManager, TokenConfig tokenConfig) {
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    public LoginResponse login(LoginRequest request){

        UsernamePasswordAuthenticationToken userAndPassword
                = new UsernamePasswordAuthenticationToken(request.email(), request.password());

        Authentication authentication = authenticationManager.authenticate(userAndPassword);
        User user = (User) authentication.getPrincipal();
        String token = tokenConfig.generatedToken(user);

        return new LoginResponse(token);
    }


}
