ALTER TABLE [prodkit_inspire].[dbo].[processamento] 
	ADD id_produto_pk bigint not null, 
		id_produto_sub_pk bigint;
GO

INSERT INTO [prodkit_inspire].[dbo].[processamento] (id_requisicao,id_job,id_lote,id_cliente_global,id_sistema_global,id_status,ambiente,identificacao_externa,tipo_execucao,id_produto_pk,data_cadastro) VALUES 
	(1,301,501,789,135,7,'PRODUCAO','Exemplo.wfd','PRINTNET', 85, GETDATE()),
	(2,302,502,789,135,6,'PRODUCAO','Exemplo.wfd','PRINTNET', 85, GETDATE()),
	(3,303,503,789,135,5,'HOMOLOGACAO','Exemplo.wfd','PRINTNET', 85, GETDATE()),
	(4,304,504,789,135,4,'PRODUCAO','Exemplo.wfd','PRINTNET', 85, GETDATE()),
	(5,305,505,789,135,3,'DESENVOLVIMENTO','Exemplo.wfd','PRINTNET', 85, GETDATE()),
	(6,306,506,789,135,2,'PRODUCAO','Exemplo.wfd','PRINTNET', 85, GETDATE()),
	(7,307,507,789,135,1,'PRODUCAO','Exemplo.wfd','PRINTNET', 85, GETDATE());
GO

INSERT INTO [prodkit_inspire].[dbo].[parametro] VALUES
	(1, '-o', 'SAIDA'),
	(1, '-e', 'PDF'),
	(1, '-c', 'Exemplo.job'),
	(1, '-difEntrada', '/nome_arquivo.txt'),
	(1, '-maxPagParamProc', '100');
GO

INSERT INTO [prodkit_inspire].[dbo].[parametro] VALUES
	(2, '-o', 'SAIDA'),
	(2, '-e', 'PDF'),
	(2, '-c', 'Exemplo.job'),
	(2, '-difEntrada', '/nome_arquivo.txt'),
	(2, '-maxPagParamProc', '200');
GO

INSERT INTO [prodkit_inspire].[dbo].[parametro] VALUES
	(3, '-o', 'SAIDA'),
	(3, '-e', 'PDF'),
	(3, '-c', 'Exemplo.job'),
	(3, '-difEntrada', '/nome_arquivo.txt'),
	(3, '-maxPagParamProc', '300');
GO

INSERT INTO [prodkit_inspire].[dbo].[parametro] VALUES
	(4, '-o', 'SAIDA'),
	(4, '-e', 'PDF'),
	(4, '-c', 'Exemplo.job'),
	(4, '-difEntrada', '/nome_arquivo.txt'),
	(4, '-maxPagParamProc', '400');
GO

INSERT INTO [prodkit_inspire].[dbo].[parametro] VALUES
	(5, '-o', 'SAIDA'),
	(5, '-e', 'PDF'),
	(5, '-c', 'Exemplo.job'),
	(5, '-difEntrada', '/nome_arquivo.txt'),
	(5, '-maxPagParamProc', '500');
GO

INSERT INTO [prodkit_inspire].[dbo].[parametro] VALUES
	(6, '-o', 'SAIDA'),
	(6, '-e', 'PDF'),
	(6, '-c', 'Exemplo.job'),
	(6, '-difEntrada', '/nome_arquivo.txt'),
	(6, '-maxPagParamProc', '600');
GO

INSERT INTO [prodkit_inspire].[dbo].[parametro] VALUES
	(7, '-o', 'SAIDA'),
	(7, '-e', 'PDF'),
	(7, '-c', 'Exemplo.job'),
	(7, '-difEntrada', '/nome_arquivo.txt'),
	(7, '-maxPagParamProc', '700');
GO