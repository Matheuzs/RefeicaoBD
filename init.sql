CREATE TABLE restaurante (
	cnpj VARCHAR ( 20 ) UNIQUE NOT NULL,
	nome_oficial VARCHAR ( 100 ) UNIQUE NOT NULL,
	nome_fantasia VARCHAR ( 100 ) NOT NULL,
    endereco VARCHAR ( 100 ) NOT NULL,
	telefone VARCHAR ( 20 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	created_on TIMESTAMP NOT NULL,
        last_login TIMESTAMP 
);

CREATE TABLE cliente (
	rg VARCHAR ( 200 ) PRIMARY KEY,
	cpf VARCHAR ( 100 ) UNIQUE NOT NULL,
	nome VARCHAR ( 100 ) UNIQUE NOT NULL,
	email VARCHAR ( 100 ) UNIQUE NOT NULL,
	endereco VARCHAR ( 100 ) NOT NULL,
	telefone VARCHAR ( 20 ) NOT NULL,
	created_on TIMESTAMP NOT NULL,
    last_login TIMESTAMP 
);