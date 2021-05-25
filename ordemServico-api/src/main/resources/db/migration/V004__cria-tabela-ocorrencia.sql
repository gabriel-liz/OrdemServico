create table ocorrencia (

	id bigint not null auto_increment,
    ordem_servico_id bigint not null,
    descricao text not null,
    data_registro datetime not null,
    
    primary key(id)
);

alter table ocorrencia add constraint fk_ocorrencia_ordem_servico
foreign key (ordem_servico_id) references ordem_servico (id);

