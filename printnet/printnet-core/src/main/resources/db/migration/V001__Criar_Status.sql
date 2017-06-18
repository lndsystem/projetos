CREATE TABLE [prodkit_inspire].[dbo].[status](
	[id_status] [bigint] IDENTITY(1,1) NOT NULL,
	[descricao] [varchar](70) NOT NULL,
	[cor] [varchar](7) NOT NULL,
	CONSTRAINT PK_status PRIMARY KEY NONCLUSTERED(id_status)
)
GO

INSERT INTO [prodkit_inspire].[dbo].[status] (descricao,cor) VALUES ('Processamento Manual','#FFD700')
GO

INSERT INTO [prodkit_inspire].[dbo].[status] (descricao,cor) VALUES ('Processamento Default','#40E0D0')
GO

INSERT INTO [prodkit_inspire].[dbo].[status] (descricao,cor) VALUES ('Processamento Prioridade 1','#6A5ACD')
GO

INSERT INTO [prodkit_inspire].[dbo].[status] (descricao,cor) VALUES ('Processamento Prioridade 2','#0000CD')
GO

INSERT INTO [prodkit_inspire].[dbo].[status] (descricao,cor) VALUES ('Processamento Prioridade 3','#6495ED')
GO

INSERT INTO [prodkit_inspire].[dbo].[status] (descricao,cor) VALUES ('Processamento Prioridade 4','#00BFFF')
GO

INSERT INTO [prodkit_inspire].[dbo].[status] (descricao,cor) VALUES ('Processamento Prioridade 5','#ADD8E6')
GO

INSERT INTO [prodkit_inspire].[dbo].[status] (descricao,cor) VALUES ('Em execução','#D3D3D3')
GO

INSERT INTO [prodkit_inspire].[dbo].[status] (descricao,cor) VALUES ('Erro no processamento','#FF6347')
GO

INSERT INTO [prodkit_inspire].[dbo].[status] (descricao,cor) VALUES ('Processamento Finalizado','#32CD32')
GO

INSERT INTO [prodkit_inspire].[dbo].[status] (descricao,cor) VALUES ('Processamento Cancelado','#EE82EE')
GO