IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'Keycloak')
BEGIN
  CREATE DATABASE Keycloak;
END;
GO

CREATE SCHEMA MARCAPAGINA;
GO

CREATE TABLE MARCAPAGINA.LIVRO(
    id BIGINT IDENTITY(1,1) NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    qtd_paginas INT NOT NULL,

    CONSTRAINT PK_LIVRO PRIMARY KEY (id)
);
GO

CREATE TABLE MARCAPAGINA.REGISTRO(
    id BIGINT IDENTITY(1,1) NOT NULL,
    id_usuario VARCHAR(100) NOT NULL,
    id_livro BIGINT NOT NULL,
    ultima_pagina_lida INT NOT NULL,
    data DATETIME NOT NULL,
    CONSTRAINT PK_REGISTRO PRIMARY KEY (id),
    CONSTRAINT FK_REGISTRO FOREIGN KEY (id_livro) REFERENCES MARCAPAGINA.LIVRO(id)
);
GO