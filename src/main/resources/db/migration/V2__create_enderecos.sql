CREATE TABLE enderecos (
    id BIGSERIAL PRIMARY KEY,

    cep VARCHAR(8) NOT NULL,
    rua VARCHAR(40) NOT NULL,
    numero VARCHAR(8) NOT NULL,
    complemento VARCHAR(40),

    cidade VARCHAR(40) NOT NULL,
    estado VARCHAR(40) NOT NULL,
    pais VARCHAR(40) NOT NULL,

    pessoa_id BIGINT NOT NULL UNIQUE,

    CONSTRAINT fk_endereco_pessoa
        FOREIGN KEY (pessoa_id)
        REFERENCES pessoas(id)
        ON DELETE CASCADE
);