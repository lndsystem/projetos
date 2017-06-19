CREATE TABLE [prodkit_inspire].[dbo].[processamento] (
    id_processamento BIGINT IDENTITY(1,1) NOT NULL,
    id_requisicao BIGINT,
    id_job BIGINT,
    id_lote BIGINT,
    tabelas VARCHAR(255),
    
    nome_arquivo_wfd VARCHAR(350) NOT NULL,
    nome_engine VARCHAR(80) NOT NULL,
    nome_output VARCHAR(80) NOT NULL,
    nome_job VARCHAR(350) NOT NULL,
    
    
    
    
    
    id_grupo BIGINT NOT NULL,
	CONSTRAINT PK_processamento PRIMARY KEY NONCLUSTERED(id_processamento),
	CONSTRAINT FK_usuario_grupo FOREIGN KEY (id_usuario) 
		REFERENCES [dbo].[usuario] (id_usuario),
	CONSTRAINT FK_grupo_usuario FOREIGN KEY (id_grupo)
		REFERENCES [dbo].[grupo] (id_grupo)
)
GO