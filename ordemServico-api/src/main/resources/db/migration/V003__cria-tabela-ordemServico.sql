create table ordem_servico(

	id bigint not null auto_increment,
	cliente_id bigint not null,
	responsavel_id bigint not null,
    descricao_solucao varchar(500),
    data_inicio datetime not null,
    data_fim datetime,	
    status varchar(20) not null,
    
    equipamento_tipo varchar(60) not null,
    equipamento_marca varchar(60) not null,
    equipamento_descricao varchar(255) not null,
    
CONSTRAINT fk_ordemServico_cliente FOREIGN KEY (cliente_id) REFERENCES Cliente (Id),
CONSTRAINT fk_ordemServico_responsavel FOREIGN KEY (responsavel_id) REFERENCES Responsavel (Id),

	primary key (id)
);

