package br.com.bradorda.myth.dtos.request;

import br.com.bradorda.myth.entities.Endereco;
import br.com.bradorda.myth.entities.Pessoa;
import br.com.bradorda.myth.entities.Telefone;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RegisterUserRequest(
        @NotNull(message = "Os dados precisam ser informados.") Pessoa pessoa,
        @NotNull(message = "É necessario informar pelo menos um número de telefone.") List<Telefone> telefones,
        @NotNull(message = "Endereço precisa ser informado corretamente.") Endereco endereco,
        @NotEmpty(message = "A senha não pode estar vazia") String password
) {}
