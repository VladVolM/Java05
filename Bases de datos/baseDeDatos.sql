--Tabla compañia
drop table compania cascade;
create table compania(
	codigoCompania 		integer,
	presidente 			varchar(20),
	nombreCompania 		varchar(40),
	fechaApertura 		date,
	calidadPrecio 		varchar(30),
	constraint PK_COMPA primary key (codigoCompania)
	);
insert into compania values(1, 'Min-Liang Tan', 'Razer Inc', '2/27/1998', null);
insert into compania values(2, 'Guerrino De Luca', 'Logitech International S.A.', '10/2/1981', null);
insert into compania values(3, 'Andy Paul', 'Corsair Components, Inc', '1/1/1994', null);
insert into compania values(4, 'Ububububue osas', 'Mars Gaming S.A.', '9/26/2010', null);
insert into compania values(5, 'El presidente', 'Presicompany S.L.', '2/12/2000', null);


drop table hardware cascade;
create table hardware(
	codigoCompania 		integer,
	nModelo 			varchar(30),
	precio 				float(2),
	fechaLanzamiento 	date,
	nombreModelo 		varchar(30),
	constraint PK_HARD primary key (nModelo),
	constraint FK_HARD foreign  key (codigoCompania) references compania
	);
insert into hardware values(1, 'RZ01-02550100-R3M1', 169.99, '5/23/2018', 'Razer Viper');
insert into hardware values(2, '920-002518', 10.99, '11/18/2015', 'Logitech Keyboard K120');
insert into hardware values(1, 'RZ03-02861400-R311', 97.99, '6/1/2019', 'Razer BlackWidow 2019');
insert into hardware values(3, 'CH-9301111-EU', 24.99, '5/10/2018', 'Corsair Harpoon RGB');
insert into hardware values(3, 'CH-9115020-ES', 81.99, '3/12/2019', 'Corsair K63');
insert into hardware values(2, '910-004845', 22.99, '7/9/2017', 'Logitech G203 Prodigy');
insert into hardware values(4, 'MM218', 17.95, '1/29/2016', 'Tacens Mars Gaming MM218');
insert into hardware values(4, 'MK5RES', 45.90, '11/2/2017', 'Tacens Mars Gaming MK5');
insert into hardware values(2, '910-003357', 4.99, '6/15/2010', 'Logitech B100');

drop table raton cascade;
create table raton(
	nModelo 			varchar(30),
	dpi 				integer,
	numeroBotones 		integer,
	tecnologiaSensor 	varchar(20),
	constraint FK_RAT foreign key (nModelo) references hardware
	);
insert into raton values('RZ01-02550100-R3M1', 16000, 8, 'optico');
insert into raton values('CH-9301111-EU', 12000, 6, 'optico');
insert into raton values('910-004845', 8000, 6, 'optico');
insert into raton values('MM218', 10000, 7, 'optico');
insert into raton values('910-003357', 800, 3, 'optico');
drop table teclado cascade;
create table teclado(
	nModelo 			varchar(30),
	distribucion 		varchar(20),
	tipo 				varchar(20),
	antiGhosting 		boolean,
	constraint FK_TEC foreign key (nModelo) references hardware
	);
insert into teclado values('920-002518', 'qwerty', 'membrana', false);
insert into teclado values('RZ03-02861400-R311', 'qwerty', 'mecanico', true);
insert into teclado values('CH-9115020-ES', 'qwerty', 'mecanico', true);
insert into teclado values('MK5RES', 'qwerty', 'mecanico', false);