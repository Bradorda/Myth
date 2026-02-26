package br.com.bradorda.myth.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserDTO(@NotEmpty @Email String email, @NotEmpty String password) {

}
