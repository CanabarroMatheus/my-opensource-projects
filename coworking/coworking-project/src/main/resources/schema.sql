create database coworking;

create table contact_types(
	id bigserial not null primary key,
	title text not null
);

create table clients(
	id bigserial not null primary key,
	name text not null,
	cpf varchar(11) unique not null,
	birthdate date not null
);

create table contacts(
	id bigserial not null primary key,
	value text not null,
	contact_types_id bigint not null references contact_types(id),
	client_id bigint not null references clients(id)
);

create table rooms(
	id bigserial not null primary key,
	name text not null,
	maximum_capacity int not null,
	price numeric(12, 2) not null
);

create table packs(
	id bigserial not null primary key,
	price numeric(12, 2) not null
);

create table rooms_packs(
	id bigserial not null primary key,
	hiring_type smallint not null,
	quantity int not null,
	expiration int not null,
	room_id bigint not null references rooms(id),
	pack_id bigint not null references packs(id)
);

create table clients_packs(
	id bigserial not null primary key,
	quantity int not null,
	client_id bigint not null references clients(id),
	pack_id bigint not null references packs(id)
);

create table hirings(
	id bigserial not null primary key,
	hiring_type smallint not null,
	quantity int not null,
	expiration int not null,
	discount decimal(3, 2),
	hiring_status smallint not null,
	room_id bigint not null references rooms(id),
	client_id bigint not null references clients(id)
);

create table payments(
	id bigserial not null primary key,
	payment_type smallint not null,
	clients_packs_id bigint not null references clients_packs(id),
	hiring_id bigint not null references hirings(id)
);

create table client_balances(
	hiring_type smallint not null,
	quantity int not null,
	duedate date not null,
	client_id bigint not null references clients(id),
	room_id bigint not null references rooms(id),
	primary key(client_id, room_id)
);

create table access(
	id bigserial not null primary key,
	is_entrada boolean not null,
	access_date timestamp not null,
	is_exception boolean not null,
	client_id bigint not null,
	room_id bigint not null,
	foreign key (client_id, room_id) references client_balances(client_id, room_id)
);

insert into contact_types(id, title) values(default, 'telefone');
insert into contact_types(id, title) values(default, 'e-mail');
insert into contact_types(id, title) values(default, 'skype');
insert into contact_types(id, title) values(default, 'facebook');
insert into contact_types(id, title) values(default, 'instagram');