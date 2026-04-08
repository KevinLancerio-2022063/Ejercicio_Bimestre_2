drop database if exists Ejercicio_in5cm;

create database Ejercicio_in5cm;
use Ejercicio_in5cm;

create table Clientes (
	dpi_cliente int not null primary key auto_increment,
	nombre_cliente varchar (50) not null,
	apellido_cliente varchar (50) not null,
    direccion varchar (100) not null,
	estado int not null
);

create table Usuarios (
	codigo_usuario int not null primary key auto_increment,
	username varchar (45),
	password varchar (45),
    email varchar (60),
    rol varchar (45),
    estado int
);

create table Productos (
	codigo_producto int not null primary key auto_increment,
	nombre_producto varchar (60) not null,
    precio decimal (10,2) not null,
    stock int not null,
    estado int not null
);

create table Ventas (
	codigo_venta int not null primary key auto_increment,
    fecha_venta date not null,
    total decimal (10,2) not null,
    estado int not null,
    clientes_dpi_cliente int not null,
    foreign key (clientes_dpi_cliente) references Clientes (dpi_cliente) on delete cascade,
	usuarios_codigo_usuario int not null,
    foreign key (usuarios_codigo_usuario) references Usuarios (codigo_usuario) on delete cascade
);

create table DetalleVentas (
	codigo_detalle_venta int not null primary key auto_increment,
    cantidad int not null,
    precio_unitario decimal (10,2) not null,
    subtotal decimal (10,2) not null,
    productos_codigo_producto int not null,
    foreign key (productos_codigo_producto) references Productos (codigo_producto) on delete cascade,
	ventas_codigo_venta int not null,
    foreign key (ventas_codigo_venta) references Ventas (codigo_venta) on delete cascade
);

-- Listar Cliente --
delimiter $$
	create procedure sp_listarClientes()
	begin
		select * from Clientes order by dpi_cliente;
	end $$
delimiter ;

-- Agregar Cliente --
delimiter $$
	create procedure sp_agregarCliente (
		in p_nombre_cliente varchar (50),
		in p_apellido_cliente varchar (50),
		in p_direccion varchar (100),
        in p_estado int
        )
        begin
			insert into Clientes (nombre_cliente, apellido_cliente, direccion, estado) values
            (p_nombre_cliente, p_apellido_cliente, p_direccion, p_estado);
		end $$
delimiter ;

call sp_agregarCliente ("Juan", "Gómez", "7 Calle 8-21 Zona 2", 0);
call sp_agregarCliente ("Luis", "Castro", "8 Calle 3-21 Zona 10", 1);
call sp_agregarCliente ("Pedro", "García", "4 Calle 2-55 Zona 2", 1);

-- Editar Cliente --
delimiter $$
	create procedure sp_editarCliente (
		in dpi_cliente int,
        in nombre_cliente varchar (50),
        in apellido_cliente varchar (50),
        in direccion varchar (100),
        in estado int
		)
        begin
			update Clientes c
			set
            c.nombre_cliente = nombre_cliente,
            c.apellido_cliente = apellido_cliente,
            c.direccion = direccion,
            c.estado = estado
            where c.dpi_cliente = dpi_cliente;
		end $$
delimiter ;

-- Eliminar Cliente --
delimiter $$
	create procedure sp_eliminarCliente (
    in dpi_clien int
    )
	begin
		delete from Clientes where dpi_cliente = dpi_clien;
	end $$
delimiter ;

-- Listar Usuario --
delimiter $$
	create procedure sp_listarUsuario ()
    begin
		select * from Usuarios order by codigo_usuario;
	end $$
delimiter ;

-- Agregar Usuario --
delimiter $$
	create procedure sp_agregarUsuario (
    in p_username varchar (45),
    in p_password varchar (45),
    in p_email varchar (60),
    in p_rol varchar (45),
    in p_estado int
    )
    begin
		insert into Usuarios (username, password, email, rol, estado) values
        (p_username, p_password, p_email, p_rol, p_estado);
	end $$
delimiter ;

call sp_agregarUsuario ("Enrique", "abc", "enrique@gmail.com", "Gerente", 1);
call sp_agregarUsuario ("Josué", "12345", "josue@gmail.com", "Proveedpr", 0);
call sp_agregarUsuario ("Miguel", "123de", "miguel@gmail.com", "Soporte Técnico", 1);

-- Editar Usuario --
delimiter $$
	create procedure sp_editarUsuario (
    in codigo_usuario int,
    in username varchar (45),
    in password varchar (45),
    in email varchar (45),
    in rol varchar (45),
    in estado int
	)
	begin
		update Usuarios u
        set
        u.codigo_usuario = codigo_usuario,
        u.username = username,
        u.password = password,
        u.email = email,
        u.rol = rol,
        u.estado = estado
        where u.codigo_usuario = codigo_usuario;
	end $$
delimiter ;

-- Eliminar Usuario --
delimiter $$
	create procedure sp_eliminarUsuario (
    in codigo_usua int
    )
	begin
		delete from Usuarios where codigo_usua = codigo_usuario;
	end $$
delimiter ;

-- Listar Productos --
delimiter $$
	create procedure sp_listarProductos ()
    begin
		select * from Productos order by codigo_producto;
	end $$
delimiter ;

-- Agregar Producto
delimiter $$
	create procedure sp_agregarProducto (
		in p_nombre_producto varchar (60),
        in p_precio decimal (10,2),
        in p_stock int,
        in p_estado int
        )
		begin
			insert into Productos (nombre_producto, precio, stock, estado) values 
			(p_nombre_producto, p_precio, p_stock, p_estado);
		end $$
delimiter ;

call sp_agregarProducto ("Jabones", 10.50, 200, 0);
call sp_agregarProducto ("Toallas", 7.00, 100, 1);
call sp_agregarProducto ("Papel higiénico", 5.50, 150, 1);

-- Editar Producto --
delimiter $$
	create procedure sp_editarProducto (
    in codigo_producto int,
    in nombre_producto varchar (60),
    in precio decimal (10,2),
    in stock int,
    in estado int
    )
    begin
		update Productos p
        set
        p.nombre_producto = nombre_producto,
        p.precio = precio,
        p.stock = stock,
        p.estado = estado
        where p.codigo_producto = codigo_producto;
	end $$
delimiter ;

-- Eliminar Producto
delimiter $$
	create procedure sp_eliminarProducto (
    in codigo_produc int
    )
    begin
		delete from Productos where codigo_producto = codigo_produc;
	end $$
delimiter ;

-- Listar Ventas --
delimiter $$
	create procedure sp_listarVentas ()
	begin
		select * from Ventas order by codigo_venta;
	end $$
delimiter ;

-- Agregar Venta --
delimiter $$
	create procedure sp_agregarVenta (
		in p_fecha_venta date,
        in p_total decimal (10,2),
        in p_estado int,
        in p_clientes_dpi_cliente int,
        in p_usuarios_codigo_usuario int
        )
        begin
			insert into Ventas (fecha_venta, total, estado, clientes_dpi_cliente, usuarios_codigo_usuario) values
			(p_fecha_venta, p_total, p_estado, p_clientes_dpi_cliente, p_usuarios_codigo_usuario);
		end $$
delimiter ;

call sp_agregarVenta ("2026-03-12", 14.50, 1, 1 ,1);
call sp_agregarVenta ("2026-02-10", 20.00, 0, 1, 2);
call sp_agregarVenta ("2026-01-24", 30.50, 0, 3, 2);

-- Editar Venta --
delimiter $$
	create procedure sp_editarVenta (
    in codigo_venta int,
    in fecha_venta date,
    in total decimal (10,2),
    in estado int,
    in clientes_dpi_cliente int,
    in usuarios_codigo_usuario int
    )
	begin
		update Ventas v
        set
        v.fecha_venta = fecha_venta,
        v.total = total,
        v.estado = estado,
        v.clientes_dpi_cliente = clientes_dpi_cliente,
        v.usuarios_codigo_usuario = usuarios_codigo_usuario
		where v.codigo_venta = codigo_venta;
	end $$
delimiter ;

-- Eliminar Venta --
delimiter $$
	create procedure sp_eliminarVenta (
    in codigo_ven int
    )
	begin
		delete from Ventas where codigo_venta = codigo_ven;
	end $$
delimiter ;

-- Listar DetalleVenta --
delimiter $$
	create procedure sp_listarDetalleVenta ()
	begin
		select * from DetalleVentas order by codigo_detalle_venta;
	end $$
delimiter ;

-- Agregar DetalleVenta --
delimiter $$
	create procedure sp_agregarDetalleVenta (
    in p_cantidad int,
    in p_precio_unitario decimal (10,2),
    in p_subtotal decimal (10,2),
    in p_productos_codigo_producto int,
    in p_ventas_codigo_venta int
    )
    begin
		insert into DetalleVentas (cantidad, precio_unitario, subtotal, productos_codigo_producto, ventas_codigo_venta) values
        (p_cantidad, p_precio_unitario, p_subtotal, p_productos_codigo_producto, p_ventas_codigo_venta);
	end $$
delimiter ;

call sp_agregarDetalleVenta (10, 4.50, 35.50, 2, 3);
call sp_agregarDetalleVenta (15, 5.00, 42.00, 1, 2);
call sp_agregarDetalleVenta (12, 7.00, 28.50, 2, 3);

-- Editar DetalleVenta --
delimiter $$
	create procedure sp_editarDetalleVenta (
    in codigo_detalle_venta int,
    in cantidad int,
    in precio_unitario decimal (10,2),
    in subtotal decimal (10,2),
    in productos_codigo_producto int,
    in ventas_codigo_venta int
    )
	begin
		update DetalleVentas dt
        set
        dt.cantidad = cantidad,
        dt.precio_unitario = precio_unitario,
        dt.subtotal = subtotal,
        dt.productos_codigo_producto = productos_codigo_producto,
        dt.ventas_codigo_venta = ventas_codigo_venta
        where dt.codigo_detalle_venta = codigo_detalle_venta;
	end $$
delimiter ;

-- Eliminar DetalleVenta --
delimiter $$
	create procedure sp_eliminarDetalleVenta (
    in codigo_detalle_ven int
    )
    begin
		delete from DetalleVentas where codigo_detalle_venta = codigo_detalle_ven;
	end $$
delimiter ;

select * from Clientes;
select * from Usuarios;
select * from Productos;
select * from Ventas;
select * from DetalleVentas;