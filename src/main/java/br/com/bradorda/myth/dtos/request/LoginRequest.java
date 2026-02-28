package br.com.bradorda.myth.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @Email(message = "Endereço de email invalido") String email,
        @NotEmpty(message = "Informe uma senha.") String password
) {

}
