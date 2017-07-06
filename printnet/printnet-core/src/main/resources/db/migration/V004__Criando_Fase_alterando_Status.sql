CREATE TABLE [prodkit_inspire].[dbo].[fase] (
    id_fase BIGINT IDENTITY(1,1) NOT NULL,
    nome_fase VARCHAR(50) NOT NULL,
	CONSTRAINT PK_fase PRIMARY KEY NONCLUSTERED(id_fase)	
)
GO

INSERT INTO [prodkit_inspire].[dbo].[fase] (nome_fase) VALUES ('Processamento PrintNet')
GO

ALTER TABLE [prodkit_inspire].[dbo].[status] 
	ADD id_fase BIGINT NOT NULL;
GO

ALTER TABLE [prodkit_inpire].[dbo].[status]
	ADD CONSTRAINT FK_status_fase
	FOREIGN KEY (id_fase) REFERENCES [prodkit_inspire].[dbo].[fase] (id_fase);
GO

UPDATE [prodkit_inspire].[dbo].[status] SET id_fase=1;
GO