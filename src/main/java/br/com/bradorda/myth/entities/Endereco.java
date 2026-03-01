package br.com.bradorda.myth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "enderecos")
@Getter @Setter @ToString @EqualsAndHashCode @AllArgsConstructor @NoArgsConstructor
public class Endereco implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false, length = 40)
    private String rua;

    @Column(nullable = false, length = 8)
    private String numero;

    @Column(length = 40)
    private String complemento;

    @Column(nullable = false, length = 40)
    private String cidade;

    @Column(nullable = false, length = 40)
    private String estado;

    @Column(nullable = false, length = 40)
    private String pais;

    @OneToOne
    @JoinColumn(name = "pessoa_id",nullable = false, unique = true)
    @JsonIgnore
    private Pessoa pessoa;

}
