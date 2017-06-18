CREATE TABLE [prodkit_inspire].[dbo].[usuario] (
    [id_usuario] [BIGINT] IDENTITY(1,1) NOT NULL,
    [nome] [VARCHAR](50) NOT NULL,
    [email] [VARCHAR](50) NOT NULL,
    [senha] [VARCHAR](120) NOT NULL,
    [ativo] [bit] ,
    [data_cadastro] [DATE] NOT NULL DEFAULT GETDATE(),
	CONSTRAINT PK_usuario PRIMARY KEY NONCLUSTERED(id_usuario)
)
GO

INSERT INTO [prodkit_inspire].[dbo].[usuario] (nome,email,senha,ativo) 
VALUES ('Leandro Coelho e Silva', 'leandroces@gmail.com', '$2a$10$wXQajpBUu/c2okcYFUCPOe1aTF09j5HDcBVUHrKF3pNHnyTlc4obS',1)
GO 
	
CREATE TABLE [prodkit_inspire].[dbo].[grupo] (
    id_grupo BIGINT IDENTITY(1,1) NOT NULL,
    nome VARCHAR(50) NOT NULL,
	CONSTRAINT PK_grupo PRIMARY KEY NONCLUSTERED(id_grupo)
)
GO

INSERT INTO [prodkit_inspire].[dbo].[grupo] (nome) VALUES ('Administrador')
GO
	
CREATE TABLE [prodkit_inspire].[dbo].[permissao] (
    id_permissao BIGINT IDENTITY(1,1) NOT NULL,
    nome VARCHAR(50) NOT NULL,
	CONSTRAINT PK_permissao PRIMARY KEY NONCLUSTERED(id_permissao)
)
GO

INSERT INTO [prodkit_inspire].[dbo].[permissao] (nome) VALUES ('ROLE_ADMIN')
GO
	
CREATE TABLE [prodkit_inspire].[dbo].[usuario_grupo] (
    id_usuario BIGINT  NOT NULL,
    id_grupo BIGINT NOT NULL,
	CONSTRAINT PK_usuario_grupo PRIMARY KEY NONCLUSTERED(id_usuario, id_grupo),
	CONSTRAINT FK_usuario_grupo FOREIGN KEY (id_usuario) 
		REFERENCES [dbo].[usuario] (id_usuario),
	CONSTRAINT FK_grupo_usuario FOREIGN KEY (id_grupo)
		REFERENCES [dbo].[grupo] (id_grupo)
)
GO

INSERT INTO [prodkit_inspire].[dbo].[usuario_grupo] (id_usuario, id_grupo) VALUES(1,1)
GO
	
CREATE TABLE [prodkit_inspire].[dbo].[grupo_permissao] (
    id_grupo BIGINT NOT NULL,
    id_permissao BIGINT NOT NULL,
	CONSTRAINT PK_grupo_permissao PRIMARY KEY NONCLUSTERED(id_grupo, id_permissao),
	CONSTRAINT FK_grupo_permissao FOREIGN KEY (id_grupo)
		REFERENCES [dbo].[grupo] (id_grupo),
	CONSTRAINT FK_permissao_grupo FOREIGN KEY (id_permissao)
		REFERENCES [dbo].[permissao] (id_permissao)
)
GO

INSERT INTO [prodkit_inspire].[dbo].[grupo_permissao] (id_grupo, id_permissao) VALUES (1,1)