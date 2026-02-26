CREATE TABLE telefones (
    id BIGSERIAL PRIMARY KEY,

    telefone VARCHAR(20) NOT NULL UNIQUE,

    pessoa_id BIGINT NOT NULL,

    CONSTRAINT fk_telefone_pessoa
        FOREIGN KEY (pessoa_id)
        REFERENCES pessoas(id)
        ON DELETE CASCADE
);