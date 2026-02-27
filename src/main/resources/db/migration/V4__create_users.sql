CREATE TABLE users (

    id BIGSERIAL PRIMARY KEY,

    password VARCHAR(255) NOT NULL,

    pessoa_id BIGINT NOT NULL UNIQUE,

    CONSTRAINT fk_user_pessoa
        FOREIGN KEY (pessoa_id)
        REFERENCES pessoas(id)
        ON DELETE CASCADE

);