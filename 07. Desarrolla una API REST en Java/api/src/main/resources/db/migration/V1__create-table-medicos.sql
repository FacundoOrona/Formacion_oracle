CREATE TABLE medicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    documento VARCHAR(12) NOT NULL UNIQUE,
    especialidad VARCHAR(100),
    calle VARCHAR(100) NOT NULL,
    barrio VARCHAR(100) NOT NULL,
    codigo_postal VARCHAR(9) NOT NULL,
    complemento VARCHAR(100),
    numero VARCHAR(100),
    ciudad VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);
