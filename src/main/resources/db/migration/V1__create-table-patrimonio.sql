CREATE TABLE patrimonio (
    id VARCHAR(255) PRIMARY KEY UNIQUE NOT NULL,
    numero_patrimonio VARCHAR(255) NOT NULL UNIQUE,
    nome_patrimonio VARCHAR(255) NOT NULL,
    setor VARCHAR(255) NOT NULL
);

