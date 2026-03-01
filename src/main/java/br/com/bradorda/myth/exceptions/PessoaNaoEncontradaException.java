package br.com.bradorda.myth.exceptions;

public class PessoaNaoEncontradaException extends RuntimeException {

    public PessoaNaoEncontradaException(Long id) {
        super("Pessoa não encontrada para o id: " + id);
    }
}