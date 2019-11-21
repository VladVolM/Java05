drop table ATable cascade;
create table ATable(
	nif 				varchar(9),
	usuario 			varchar(30),
	contra 				varchar(20),
	constraint PK_NIF primary key (nif)
	);
insert into ATable values('123456789', 'Liang', 'jsdhj4svuw');
insert into ATable values('234567890', 'Luca', 'itg3omfdd');
insert into ATable values('345678901', 'Andy', 'pqrnc6laug');
insert into ATable values('456789012', 'Osas', 'ncoe742d');
insert into ATable values('567890123', 'Volo', '12345');


drop table BTable cascade;
create table BTable(
	nif			 		varchar(9),
	codigo 				integer,
	imagen 				varchar(30),
	fechaLanzamiento 	date,
	constraint PK_COD primary key (codigo),
	constraint FK_NIF foreign  key (nif) references ATable
	);
insert into BTable values('567890123', 123, '1.png', '1/15/2015' );
insert into BTable values('567890123', 456, '1.png', '11/11/2011');
insert into BTable values('567890123', 789, '1.png', '7/23/2018' );
insert into BTable values('567890123', 0  , '1.png', '9/9/2017'  );

drop table DTable cascade;
create table DTable(
	codigo				integer,
	descuento 			integer,
	constraint PK_COD2 primary key (codigo)
	);
insert into DTable values(1, 10);
insert into DTable values(2, 18);
insert into DTable values(3, 26);
insert into DTable values(4, 34);
insert into DTable values(5, 42);
insert into DTable values(6, 50);
insert into DTable values(7, 58);

drop table CTable cascade;
create table CTable(
	codB 				integer,
	codD 				integer,
	contador 			integer,
	calculo			 	float(2),
	constraint PK_CONTADOR primary key (contador,codB,codD),
	constraint FK_B foreign key (codB) references BTable,
	constraint FK_D foreign key (codD) references DTable
	);
insert into CTable values(123, 7, 1, 30);
insert into CTable values(123, 2, 2, 30);
insert into CTable values(123, 4, 3, 30);
insert into CTable values(456, 6, 1, 30);
insert into CTable values(789, 6, 1, 30);
insert into CTable values(  0, 1, 1, 30);


