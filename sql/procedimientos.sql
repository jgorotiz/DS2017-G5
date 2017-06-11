use smartfood;

/*procedimiento pra el login*/
delimiter //
create procedure login (in nombre varchar(50), in contrasenia varchar(50), out numUsuario int, out rol varchar(45))
begin 
	select count(idUsuario), nombreRol into numUsuario, rol 
    from rol,usuario
    where rol.idRol = usuario.rol and usuario = nombre and usuario.contrasenia = contrasenia ;
end//

delimiter ;
/* platillos por restaurante dada una categoria*/
delimiter //
create procedure platilloXCategoria(in categoria varchar(50))
begin
	select nombre, descripcion, img, nombreTipo, nombreCategoria
    from plato,categoria, tipo
    where plato.categoria =  categoria.idCategoria and plato.tipo =  tipo.idTipo and  categoria = nombreCategoria ;
end// 

delimiter ;


/* platillos por restaurante dado un tipo*/
delimiter //
create procedure platilloXTipo(in tipo varchar(50))
begin
	select nombre, descripcion, img, nombreTipo, nombreCategoria
    from plato,tipo, categoria
    where plato.tipo =  tipo.idTipo and plato.categoria =  categoria.idCategoria and tipo = tipo.nombreTipo;
end// 
delimiter ;

/* platillos dada una descripcion*/
delimiter //
create procedure platilloXDescripcion(in nDescripcion varchar(70))
begin
	select nombre, descripcion, img, nombreTipo, nombreCategoria
    from plato,tipo, categoria
    where plato.tipo =  tipo.idTipo and plato.categoria =  categoria.idCategoria and descripcion like nDescripcion;
end// 
delimiter ;

/* platillos dado un nombre*/
delimiter //
create procedure platilloXNombre(in nNombre varchar(70))
begin
	select nombre, descripcion, img, nombreTipo, nombreCategoria
    from plato,tipo, categoria
    where plato.tipo =  tipo.idTipo and plato.categoria =  categoria.idCategoria and nombre like nNombre;
end// 
delimiter ;

/* actualizar valores de platillos*/
delimiter //
create procedure actualizarPlatilo(in nIdPlato int, in nuevoNombre varchar(50),in nuevaDescripcion varchar(200), in nuevaImagen varchar(200),
	in nuevaCategoria int, in nuevoTipo int, in nuevoRestaurante int, in nuevaFechaRegistro datetime)
begin
	update palto
    set nombre = nuevoNombre,
		decripcion = nuevaDescripcion,
        imagen = nuevaImagen,
        categoria = nuevaCategoria,
        tipo  = nuevoTipo,
        restaurante = nuevoRestaurante,
        fechaRegistro = nuevaFechaRegistro
	where idPlato = nIdPlato;
end// 
delimiter ;


/* platillos por categoria*/
delimiter //
create procedure cantidadDePLatillosXCategoria()
begin
	select count(nombre), nombreCategoria
    from plato, categoria
    where  plato.categoria =  categoria.idCategoria
    group by idCategoria;
end// 
delimiter ;
