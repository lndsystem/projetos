CREATE TABLE [prodkit_inspire].[dbo].[recuperacao_senha] (
    id_recuperacao_senha BIGINT IDENTITY(1,1) NOT NULL,
    id_usuario BIGINT NOT NULL,
    data_solicitacao DATETIME NOT NULL,
    ultima_senha VARCHAR(120)
	CONSTRAINT PK_recuperacao_senha PRIMARY KEY NONCLUSTERED(id_recuperacao_senha),
	CONSTRAINT FK_recuperacao_senha FOREIGN KEY (id_usuario) 
		REFERENCES [dbo].[usuario] (id_usuario)
)
GO