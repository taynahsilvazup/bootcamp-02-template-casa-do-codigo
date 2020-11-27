    CREATE TABLE pais (
        id BIGINT NOT NULL AUTO_INCREMENT,
        nome VARCHAR(160) NOT NULL,
        data_cadastro DATETIME NOT NULL,
        PRIMARY KEY (id));

        CREATE TABLE estado (
            id BIGINT NOT NULL AUTO_INCREMENT,
            nome VARCHAR(160) NOT NULL,
            pais_id BIGINT NOT NULL,
            data_cadastro DATETIME NOT NULL,
            PRIMARY KEY (id),
            FOREIGN KEY (pais_id) REFERENCES pais(id));