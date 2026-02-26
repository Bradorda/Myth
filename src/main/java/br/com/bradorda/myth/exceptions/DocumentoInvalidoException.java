package br.com.bradorda.myth.exceptions;

public class DocumentoInvalidoException extends RuntimeException {

    public DocumentoInvalidoException(String message, String s) {
        super(message);
    }
}
