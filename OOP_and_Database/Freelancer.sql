DROP DATABASE IF EXISTS freelancer;
CREATE DATABASE freelancer;
use freelancer;

#colocar os innodbs
CREATE TABLE IF NOT EXISTS portifolio(
	portifolio_id int not null primary key auto_increment
)ENGINE=INNODB, auto_increment = 100;

CREATE TABLE IF NOT EXISTS usuarioGeral(
	usuario_id int not null primary key auto_increment,
    nome varchar(30) not null,
    email varchar(50) not null unique,
    cpf varchar(11) not null,
    cnpj varchar(15) not null,
    senha varchar(16) not null,
    telefone varchar(10) not null,
    imagem varchar(200),
    id_portifolio int,
    id_proposta int,
    CONSTRAINT fk_id_portifolio FOREIGN KEY (id_portifolio)
		REFERENCES portifolio(portifolio_id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS projeto(
	projeto_id int not null primary key auto_increment,
    nomeProjeto varchar(15) not null unique,
    descricaoProjeto varchar(500) not null,
    categoria varchar(20) not null,
    precoMin float not null,
    precoMax float not null,
    statusProjeto int not null,
    id_cliente int not null,
    id_usuarioo int not null,
    id_portifolioo int,
    CONSTRAINT fk_id_usuarioo FOREIGN KEY (id_usuarioo)
		REFERENCES usuarioGeral(usuario_id),
    CONSTRAINT fk_id_cliente FOREIGN KEY (id_cliente)
		REFERENCES usuarioGeral(usuario_id),
    CONSTRAINT fk_id_portifolioo FOREIGN KEY (id_portifolioo)
		REFERENCES portifolio(portifolio_id)    
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS proposta(
	proposta_id int not null primary key auto_increment,
    propostaRealizada varchar(500) not null unique,
    valorProposta float not null,
    id_usuario int not null,
    id_projeto int not null,
    id_client int not null,
    CONSTRAINT fk_id_projeto FOREIGN KEY (id_projeto)
		REFERENCES projeto(projeto_id),
    CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario)
		REFERENCES usuarioGeral(usuario_id),
	CONSTRAINT fk_id_client FOREIGN KEY (id_client)
		REFERENCES projeto(id_cliente)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS conhecimento(
	conhecimento_id int not null primary key auto_increment,
	nomeConhecimento varchar(14) not null	
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS usuarioGeral_has_conhecimento(
	id_usuariooo int not null,
    id_conhecimentooo int not null,
    primary key (id_usuariooo, id_conhecimentooo),
    CONSTRAINT fk_id_usuariooo FOREIGN KEY (id_usuariooo)
		REFERENCES usuarioGeral(usuario_id),
	CONSTRAINT fk_id_conhecimentooo FOREIGN KEY (id_conhecimentooo)
		REFERENCES conhecimento(conhecimento_id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS projeto_has_conhecimento(
	id_projeto int not null,
    id_conhecimento_projeto int not null,
    primary key (id_projeto, id_conhecimento_projeto),
    CONSTRAINT fk_id_projeto_has FOREIGN KEY (id_projeto)
		REFERENCES projeto(projeto_id),
	CONSTRAINT fk_id_conhecimento_projeto FOREIGN KEY (id_conhecimento_projeto)
		REFERENCES conhecimento(conhecimento_id)
)ENGINE=INNODB;

insert into conhecimento (nomeConhecimento) values ('PHP');
insert into conhecimento (nomeConhecimento) values ('HTML');
insert into conhecimento (nomeConhecimento) values ('JAVA');
insert into conhecimento (nomeConhecimento) values ('SWIFT');
insert into conhecimento (nomeConhecimento) values ('PHYTON');
insert into conhecimento (nomeConhecimento) values ('JAVASCRIPT');
insert into conhecimento (nomeConhecimento) values ('COMUNICAÇÃO');
insert into conhecimento (nomeConhecimento) values ('ARTES GRÁFICAS');
insert into conhecimento (nomeConhecimento) values ('SOLUÇÕES');
insert into conhecimento (nomeConhecimento) values ('CÁLCULOS');
insert into conhecimento (nomeConhecimento) values ('GESTÃO');
insert into conhecimento (nomeConhecimento) values ('REDES');

insert into usuarioGeral (usuario_id, nome, email, cpf, cnpj, senha, telefone, imagem) values ('-1','default', 'default', 'default', 'default', 'default', 'default', 'default');

select * from usuarioGeral;
select * from projeto;
select * from proposta;
select * from conhecimento;
select * from usuarioGeral_has_conhecimento order by id_usuariooo;
select * from projeto_has_conhecimento;
SELECT usuario_id FROM usuarioGeral WHERE nome='nome' AND email='email';