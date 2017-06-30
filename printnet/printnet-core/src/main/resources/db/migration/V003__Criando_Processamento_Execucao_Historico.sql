CREATE TABLE [prodkit_inspire].[dbo].[processamento] (
    id_processamento BIGINT IDENTITY(1,1) NOT NULL,
    id_requisicao BIGINT NOT NULL,
    id_job BIGINT,
    id_lote BIGINT,    
	id_cliente_global BIGINT NOT NULL,
	id_sistema_global BIGINT NOT NULL,
	id_status BIGINT NOT NULL DEFAULT 2,
	ambiente VARCHAR(20) NOT NULL,
    identificacao_externa VARCHAR(50),
	tipo_execucao VARCHAR(30) NOT NULL,
    data_cadastro DATETIME NOT NULL DEFAULT GETDATE(),
	CONSTRAINT PK_processamento PRIMARY KEY NONCLUSTERED(id_processamento),
	CONSTRAINT FK_processamento_status FOREIGN KEY (id_status) 
		REFERENCES [prodkit_inspire].[dbo].[status] (id_status)
)
GO

CREATE TABLE [prodkit_inspire].[dbo].[parametro] (
	id_parametro BIGINT IDENTITY(1,1) NOT NULL,
	id_processamento BIGINT NOT NULL,
	chave VARCHAR(100) NOT NULL,
	valor VARCHAR(600) NOT NULL,
	CONSTRAINT PK_parametro PRIMARY KEY NONCLUSTERED(id_parametro),
	CONSTRAINT FK_parametro_processamento FOREIGN KEY (id_processamento)
		REFERENCES [prodkit_inspire].[dbo].[processamento]
)
GO

CREATE TABLE [prodkit_inspire].[dbo].[execucao] (
	id_execucao BIGINT IDENTITY(1,1) NOT NULL,
	id_processamento BIGINT NOT NULL,
	inicio_execucao DATETIME NOT NULL DEFAULT GETDATE(),
	fim_execucao DATETIME,
	id_status BIGINT NOT NULL,
	CONSTRAINT PK_execucao PRIMARY KEY NONCLUSTERED(id_execucao),
	CONSTRAINT FK_execucao_processamento FOREIGN KEY (id_processamento)
		REFERENCES [prodkit_inspire].[dbo].[processamento],
	CONSTRAINT FK_execucao_status FOREIGN KEY (id_status)
		REFERENCES [prodkit_inspire].[dbo].[status]
)
GO