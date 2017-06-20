CREATE TABLE [prodkit_inspire].[dbo].[processamento] (
    id_processamento BIGINT IDENTITY(1,1) NOT NULL,
    id_requisicao BIGINT NOT NULL,
    id_job BIGINT,
    id_lote BIGINT,
    tabelas VARCHAR(355),
    nome_arquivo_wfd VARCHAR(355) NOT NULL,
    nome_engine VARCHAR(80) NOT NULL,
    nome_output VARCHAR(80) NOT NULL,
    nome_job VARCHAR(355) NOT NULL,
    mascara_saida VARCHAR(355) NOT NULL,
    caminho_saida VARCHAR(355),
    arquivo_entrada_1 VARCHAR(355),
    arquivo_entrada_2 VARCHAR(355),
    arquivo_entrada_3 VARCHAR(355),
	arquivo_entrada_4 VARCHAR(355),
	arquivo_entrada_5 VARCHAR(355),
	arquivo_script_1 VARCHAR(355),
	arquivo_script_2 VARCHAR(355),
	arquivo_spript_3 VARCHAR(355),
	arquivo_script_4 VARCHAR(355),
	arquivo_script_5 VARCHAR(355),
	id_status BIGINT NOT NULL DEFAULT 2,
	ambiente VARCHAR(20) NOT NULL,
    identificacao_externa VARCHAR(50),
    data_cadastro DATETIME NOT NULL DEFAULT GETDATE(),
	CONSTRAINT PK_processamento PRIMARY KEY NONCLUSTERED(id_processamento),
	CONSTRAINT FK_processamento_status FOREIGN KEY (id_status) 
		REFERENCES [prodkit_inspire].[dbo].[status] (id_status)
)
GO

CREATE TABLE [prodkit_inspire].[dbo].[retorno] (
	id_retorno BIGINT IDENTITY(1,1) NOT NULL,
	caminho_share VARCHAR(355),
	usuario_share VARCHAR(60),
	senha_share VARCHAR(60),
	ip_ftp VARCHAR(20),
	usuario_ftp VARCHAR(45),
	senha_ftp VARCHAR(45),
	diretorio_ftp VARCHAR(255),
	nome_retorno VARCHAR(155),
	id_processamento BIGINT NOT NULL,
	CONSTRAINT PK_retorno PRIMARY KEY NONCLUSTERED(id_retorno),
	CONSTRAINT FK_retorno_processamento FOREIGN KEY (id_processamento)
		REFERENCES [prodkit_inspire].[dbo].[processamento]
)
GO

CREATE TABLE [prodkit_inspire].[dbo].[execucao] (
	
)
GO