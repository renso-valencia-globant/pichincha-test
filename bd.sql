create table persona(
	id int auto_increment primary key,
	nombre varchar(250) not null,
    genero char(1) null,
    edad int, 
    identificacion varchar(50) not null,
    direccion varchar(300)not null,
    telefono varchar(20)null
);

create table cliente(
	id int auto_increment primary key,
	clave varchar(200)not null,
	estado char(1)not null,
	id_persona int,
	FOREIGN KEY(id_persona) REFERENCES persona(id)
);

create table cuenta(
	id int auto_increment primary key,
	id_cliente int not null,
	numero_cuenta varchar(200) not null,
	tipo_cuenta varchar(200) not null,
	saldo double,
	estado char(1)not null
);

create table movimiento(
	id int auto_increment primary key,
	id_cuenta int not null,
	fecha date not null,
	tipo_movimiento varchar(200) not null,
	valor varchar(200) not null,
	saldo double
);

select now();

-- Generar reporte (Estado de cuenta) e - /movimientos
select p.nombre, c.clave, cc.numero_cuenta, cc.tipo_cuenta, 
cc.saldo, m.fecha, m.tipo_movimiento, m.saldo  
from persona p inner join cliente c on p.id = c.id_persona
inner join cuenta cc on cc.id_cliente = c.id
inner join movimiento m on (m.id_cuenta  = cc.id);

insert into movimiento (id_cuenta, fecha, tipo_movimiento, valor, saldo)
values(1, current_date(), 'Corriente', 'Deposito de 500 soles', 100);

insert into movimiento (id_cuenta, fecha, tipo_movimiento, valor, saldo)
values(1, current_date(), 'Normal', 'Deposito de 600 soles', 700);

insert into cuenta(id_cliente, numero_cuenta, tipo_cuenta, saldo, estado)
values(2, '478758', 'Ahorro', 5000, '1');

insert into persona(nombre, genero, edad, identificacion, direccion, telefono)
values('Renso Valencia', 'M', 30, '47911488', 'Av juan velazco alvarado cuadra 12', '987269551');

insert into persona(nombre, genero, edad, identificacion, direccion, telefono)
values('Vanessa Valencia', 'F', 21, '01234567', 'Av la paz cuadra 15', '985201474');

select * from persona;

insert into cliente (clave, estado, id_persona)values('123456', '1', 1);
insert into cliente (clave, estado, id_persona)values('6554321', '0', 2);

-- /clientes
select * from cliente c ;

select p.nombre, c.clave, cc.numero_cuenta, cc.tipo_cuenta, 
cc.saldo, m.fecha, m.tipo_movimiento, m.saldo  from persona p inner join cliente c on p.id = c.id_persona 
inner join cuenta cc on cc.id_cliente = c.id 
inner join movimiento m on (m.id_cuenta  = cc.id)

-- /cuentas
select * from cuenta cc;


select p.nombre, p.genero, p.direccion, c.clave, c.estado  from persona p 
inner join cliente c on c.id_persona = p.id ;