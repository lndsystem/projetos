ALTER TABLE [prodkit_inspire].[dbo].[execucao] 
	ADD duracao VARCHAR(14), 
		quantidade_warning BIGINT DEFAULT 0,
		quantidade_sheets BIGINT DEFAULT 0;
GO

UPDATE [prodkit_inspire].[dbo].[status]
	SET cor = '#7B68EE' WHERE id_status = 4;
GO