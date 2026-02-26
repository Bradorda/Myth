package br.com.bradorda.myth.entities;

import br.com.bradorda.myth.entities.enums.TipoDocumento;
import br.com.bradorda.myth.exceptions.DocumentoInvalidoException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Documento {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipo;

    @Column(nullable = false,unique = true, length = 14)
    private String numero;

    public Documento(TipoDocumento tipo, String numero) {
        validar(tipo,numero);
        this.tipo = tipo;
        this.numero = numero;
    }

    private void validar(TipoDocumento tipo, String numero) {
        if(numero == null || numero.length() != tipo.getTamanho()){
            throw new DocumentoInvalidoException(
                    String.format("Numero %s invalido para %s", numero, tipo), getClass().getPackageName());
        }
        if (this.tipo == null) {
            throw new DocumentoInvalidoException(
                    String.format("Tipo de documento %s obrigatório",tipo), getClass().getPackageName());
        }

    }

}
