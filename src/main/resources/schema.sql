create schema if not exists useradmindb;

create table if not exists users (
	username varchar(16) unique,
	password varchar(16) not null,
	firstname varchar(24),
	lastname varchar(24) not null,
	emailaddress varchar(32) not null, 
	active char(1) default 'Y',
	check (active in ( 'Y', 'N' ))
);