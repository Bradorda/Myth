package br.com.bradorda.myth.configs.security;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId,String email) {

}
