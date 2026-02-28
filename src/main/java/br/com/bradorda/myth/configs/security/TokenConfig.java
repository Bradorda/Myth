package br.com.bradorda.myth.configs.security;

import br.com.bradorda.myth.entities.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

    private final String secret = "secret";

    public String generatedToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withClaim("userId", user.getId())
                .withSubject(user.getPessoa().getEmail())
                .withExpiresAt(Instant.now().plusSeconds(123456))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public Optional<JWTUserData> validate(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT decodeJWT = JWT.require(algorithm).build().verify(token);

            return Optional.of(JWTUserData.builder()
                            .userId(decodeJWT.getClaim("userId").asLong())
                            .email(decodeJWT.getSubject())
                    .build());

        }catch (JWTVerificationException ex){
            return Optional.empty();
        }
    }

}
