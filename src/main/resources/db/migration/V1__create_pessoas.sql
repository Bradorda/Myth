CREATE TABLE pessoas (
    id BIGSERIAL PRIMARY KEY,

    nome VARCHAR(255) NOT NULL,

    email VARCHAR(255) NOT NULL UNIQUE,

    -- Documento (Embeddable)
    tipo VARCHAR(20) NOT NULL,
    numero VARCHAR(14) NOT NULL UNIQUE
);