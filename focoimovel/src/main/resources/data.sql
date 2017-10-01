INSERT INTO FINALIDADE(descricao,label_exibicao) VALUES('Vender', 'Compar'),('Alugar', 'Alugar');

INSERT INTO PARAMETRO(chave,valor) VALUES('email', 'contato@focoimovel.com.br');

INSERT INTO estado (nome,sigla) VALUES ('Acre','AC'),
('Alagoas','AL'),
('Amapá','AP'),
 ('Amazonas','AM'),
 ('Bahia','BA'),
 ('Ceará','CE'),
 ('Distrito Federal','DF'),
 ('Espírito Santo','ES'),
 ('Goiás','GO'),
 ('Maranhão','MA'),
 ('Mato Grosso','MT'),
 ('Mato Grosso do Sul','MS'),
 ('Minas Gerais','MG'),
 ('Pará','PA'),
 ('Paraíba','PB'),
 ('Paraná','PR'),
 ('Pernambuco','PE'),
 ('Piauí','PI'),
 ('Rio de Janeiro','RJ'),
 ('Rio Grande do Norte','RN'),
 ('Rio Grande do Sul','RS'),
 ('Rondônia','RO'),
 ('Roraima','RR'),
 ('Santa Catarina','SC'),
 ('São Paulo','SP'),
 ('Sergipe','SE'),
 ('Tocantins','TO');

INSERT INTO cidade (nome,id_estado) VALUES ('São Bernardo do Campo',25),
('Santo André',25),
('São Caetano do Sul',25),
('Osasco', 25),
('Carapicuiba',25);

INSERT INTO diferenciais (descricao) VALUES  ('Academia'),
 ('Aquecimento'),
 ('Ar Condicionado'),
 ('Área de Serviço'),
 ('Churrasqueira'),
 ('Cozinha'),
 ('Depósito'),
 ('Elevador'),
 ('Escritório'),
 ('Espaço Gourmet'),
 ('Espaço Verde / Parque'),
 ('Garagem'),
 ('Gramado'),
 ('Jardim'),
 ('Lareira'),
 ('Lavanderia'),
 ('Mobiliado'),
 ('Piscina'),
 ('Playground'),
 ('Quadra Poliesportiva'),
 ('Quintal'),
 ('Sacada'),
 ('Salão de Festas'),
 ('Sauna'),
 ('TV a Cabo'),
 ('Varanda Gourmet');

INSERT INTO imovel ( 
	ativo, 
	descricao, 
	bairro, 
	cep, 
	id_cidade, 
	complemento, 
	logradouro, 
	numero, 
	referencia, 
	id_finalidade, 
	area_total, 
	area_util, 
	banheiros, 
	dormitorios, 
	lavabos, 
	suites, 
	vagas, 
	valor_aluguel, 
	valor_condominio, 
	valor_iptu, 
	valor_venda, 
	termos, 
	titulo
) VALUES (
	1, 
	'Casa térria com cobrado, apenas 2 minutos do rodoanel', 
	'Jardim do Mar', 
	'99999999', 
	1, 
	null,
	'Rua Xpto do Abc', 
	123, 
	null, 
	1, 
	null, 
	91, 
	1,
	3, 
	0, 
	1, 
	2, 
	1390.00, 
	300.00, 
	30.00, 
	500000.00, 
	1, 
	'Lindo Apartamento'
);

INSERT INTO imovel_diferenciais(codigo_imovel,codigo_diferenciais) VALUES (1,5), (1,7), (1,9), (1,13), (1,18); 

INSERT INTO foto(
	content_type,
	foto,
	principal,
	tamanho,
	codigo_imovel
) VALUES (
	'img',
	'/img/foto_imoveis/sem_foto.jpg',
	1,
	1234,
	1
);

INSERT INTO foto(
	content_type,
	foto,
	principal,
	tamanho,
	codigo_imovel
) VALUES (
	'img',
	'/img/foto_imoveis/foto_anuncio1_1.jpg',
	1,
	1234,
	1
);

INSERT INTO imovel ( 
	ativo, 
	descricao, 
	bairro, 
	cep, 
	id_cidade, 
	complemento, 
	logradouro, 
	numero, 
	referencia, 
	id_finalidade, 
	area_total, 
	area_util, 
	banheiros, 
	dormitorios, 
	lavabos, 
	suites, 
	vagas, 
	valor_aluguel, 
	valor_condominio, 
	valor_iptu, 
	valor_venda, 
	termos, 
	titulo
) VALUES (
	1, 
	'Casa térria com cobrado, apenas 2 minutos do rodoanel', 
	'Jardim do Mar', 
	'99999999', 
	1, 
	null,
	'Rua Xpto do Abc', 
	123, 
	null, 
	2, 
	null, 
	91, 
	1,
	3, 
	0, 
	1, 
	2, 
	1390.00, 
	300.00, 
	30.00, 
	0.00, 
	1, 
	'Lindo Apartamento'
);




