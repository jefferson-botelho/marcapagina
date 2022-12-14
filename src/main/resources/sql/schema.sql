IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'Keycloak')
BEGIN
  CREATE DATABASE Keycloak;
END;
GO

CREATE SCHEMA MARCAPAGINA;
GO

CREATE TABLE MARCAPAGINA.USUARIO(
    id BIGINT IDENTITY(1,1) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL

    CONSTRAINT PK_USUARIO PRIMARY KEY (id)
);
GO

CREATE TABLE MARCAPAGINA.LIVRO(
    id BIGINT IDENTITY(1,1) NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    qtd_paginas INT NOT NULL,
    foto_capa VARCHAR(200),

    CONSTRAINT PK_LIVRO PRIMARY KEY (id)
);
GO

CREATE TABLE MARCAPAGINA.REGISTRO(
    id_usuario INT NOT NULL,
    id_livro INT NOT NULL,
    ultima_pagina_lida INT NOT NULL,
    data DATETIME NOT NULL
)
GO