INSERT INTO processamento (id_requisicao,id_job,id_lote,id_cliente_global,id_sistema_global,id_status,ambiente,identificacao_externa,tipo_execucao,data_cadastro) VALUES 
	(1,123,456,789,469,7,'PRODUCAO','Exemplo.wfd','PRINTNET', GETDATE()),
	(2,123,456,789,469,6,'PRODUCAO','Exemplo.wfd','PRINTNET', GETDATE()),
	(3,123,456,789,469,5,'HOMOLOGACAO','Exemplo.wfd','PRINTNET', GETDATE()),
	(4,123,456,789,469,4,'PRODUCAO','Exemplo.wfd','PRINTNET', GETDATE()),
	(5,123,456,789,469,3,'DESENVOLVIMENTO','Exemplo.wfd','PRINTNET', GETDATE()),
	(6,123,456,789,469,2,'PRODUCAO','Exemplo.wfd','PRINTNET', GETDATE()),
	(7,123,456,789,469,1,'PRODUCAO','Exemplo.wfd','PRINTNET', GETDATE());
GO