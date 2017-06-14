use smartfood;

/*procedimiento pra el login*/
drop procedure if exists login;
delimiter //
create procedure login (in nombre varchar(50), in contrasenia varchar(50), out numUsuario int, out rol varchar(45), out idUser int)
begin 
	select count(idUsuario), nombreRol, idUsuario into numUsuario, rol, idUser
    from rol,usuario
    where rol.idRol = usuario.rol and usuario = nombre and usuario.contrasenia = contrasenia ;
end//

delimiter ;


/* platillos por restaurante dada una categoria*/
drop procedure if exists platilloXCategoria;
delimiter //
create procedure platilloXCategoria(in categoria varchar(50))
begin
	select nombre, descripcion, img, nombreTipo, nombreCategoria
    from plato,categoria, tipo
    where plato.categoria =  categoria.idCategoria and plato.tipo =  tipo.idTipo and  categoria = nombreCategoria ;
end// 

delimiter ;


/* platillos por restaurante dado un tipo*/
drop procedure if exists platilloXTipo;
delimiter //
create procedure platilloXTipo(in tipo varchar(50))
begin
	select nombre, descripcion, img, nombreTipo, nombreCategoria
    from plato,tipo, categoria
    where plato.tipo =  tipo.idTipo and plato.categoria =  categoria.idCategoria and tipo = tipo.nombreTipo;
end// 
delimiter ;

/* platillos dada una descripcion*/
drop procedure if exists platilloXDescripcion;
delimiter //
create procedure platilloXDescripcion(in nDescripcion varchar(70))
begin
	select plato.nombre, descripcion, nombreTipo, nombreCategoria, restaurante.nombre as nombreRestaurante, img
    from plato,categoria, tipo,restaurante
    where plato.categoria =  categoria.idCategoria and restaurante.idRestaurante = plato.restaurante and plato.tipo =  tipo.idTipo and  plato.descripcion like CONCAT('%', nDescripcion, '%');
end// 
delimiter ;

/* platillos dado un nombre*/
drop procedure if exists platilloXNombre;
delimiter //
create procedure platilloXNombre(in nNombre varchar(70))
begin
	select plato.nombre, descripcion, nombreTipo, nombreCategoria, restaurante.nombre as nombreRestaurante, img
    from plato,categoria, tipo,restaurante
    where plato.categoria =  categoria.idCategoria and restaurante.idRestaurante = plato.restaurante and plato.tipo =  tipo.idTipo and  plato.nombre like CONCAT('%', nNombre, '%');
end// 
delimiter ;

/* actualizar valores de platillos*/
drop procedure if exists actualizarPlatilo;
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
drop procedure if exists cantidadDePLatillosXCategoria;
delimiter //
create procedure cantidadDePLatillosXCategoria()
begin
	select idCategoria, count(nombre), nombreCategoria
    from plato, categoria
    where  plato.categoria =  categoria.idCategoria
    group by idCategoria;
end// 
delimiter ;


/* platillos por restaurante dada una id categoria*/
drop procedure if exists platilloXIDCategoria;
delimiter //
create procedure platilloXIDCategoria(in claveCategoria int)
begin
	select plato.nombre, descripcion, nombreTipo, nombreCategoria, restaurante.nombre as nombreRestaurante, img
    from plato,categoria, tipo,restaurante
    where plato.categoria =  categoria.idCategoria and restaurante.idRestaurante = plato.restaurante and plato.tipo =  tipo.idTipo and  claveCategoria = categoria.idCategoria;
end// 

delimiter ;

/* platillos por restaurante dada una id categoria*/
drop procedure if exists platilloXIDCategoriaIDRestaurante;
delimiter //
create procedure platilloXIDCategoriaIDRestaurante(in claveCategoria int, in idRes int)
begin
	select idPlato, plato.nombre, descripcion, nombreTipo, nombreCategoria, img, servido.nombreServido
    from plato,categoria, tipo, servido
    where plato.categoria =  categoria.idCategoria and servido.idServido = plato.servido and plato.tipo =  tipo.idTipo and  claveCategoria = categoria.idCategoria 
    and plato.restaurante = idRes;
end// 

delimiter ;


/* actualizar imagen*/
drop procedure if exists actualizarImg;
delimiter //
create procedure actualizarImg(in platillo int, in nuevaImagen blob)
begin
	update plato
    set img = nuevaImagen
    where platillo = idPlato;
end// 

delimiter ;


/* obtener imagen*/
drop procedure if exists obtenerImg;
delimiter //
create procedure obtenerImg(in platillo int, out nuevaImagen blob)
begin
	select img into nuevaImagen
    from plato
    where idPlato = platillo;
end// 

delimiter ;

/* obtener id de restaurante dado un id de asistente*/
drop procedure if exists obtenerIdRestaurante;
delimiter //
create procedure obtenerIdRestaurante(in encargado int, out restauranteACargo int)
begin
	select restaurante into restauranteACargo
    from usuariorestaurante
    where usuario = encargado;
end// 

delimiter ;


/* insersion de un pato */
drop procedure if exists insertarPlato;
delimiter //
create procedure insertarPlato(in nombre varchar(50), in descripcion varchar(200), in img longblob,
	in categoria int, in servido int, in tipo int, restaurante int, in fechaRegistro datetime)
begin
	insert into plato (plato.nombre, plato.descripcion, plato.img, plato.categoria, plato.servido, plato.tipo, plato.restaurante, plato.fechaRegistro) 
    values(nombre,descripcion, img, categoria, servido, tipo, restaurante, fechaRegistro);
end// 

delimiter ;


/* Obtener tipos */
drop procedure if exists obtenerTipos;
delimiter //
create procedure obtenerTipos()
begin
	select idTipo, nombreTipo
    from tipo;
end// 

delimiter ;


/* Obtener categorias */
drop procedure if exists obtenerCategorias;
delimiter //
create procedure obtenerCategorias()
begin
	select idCategoria, nombreCategoria
    from categoria;
end// 

delimiter ;


/* Obtener servidos */
drop procedure if exists obtenerServido;
delimiter //
create procedure obtenerServido()
begin
	select idServido, nombreServido
    from servido;
end// 

delimiter ;


/*platillos de un restaurante*/
drop procedure if exists platoXRestaurante;
delimiter //
create procedure platoXRestaurante(in idRestaurante int)
begin
	select idPlato, nombre, descripcion, img, nombreCategoria, nombreTipo
    from plato, tipo, categoria
    where idRestaurante = restaurante and plato.categoria = categoria.idCategoria and plato.tipo = tipo.idTipo;
end// 

delimiter ;


/*nombre de categoria*/
drop procedure if exists obtenerCategoria;
delimiter //
create procedure obtenerCategoria(in categoria int)
begin
	select nombreCategoria
    from categoria
    where idCategoria = categoria;
end// 

delimiter ;

/*nombre de restaurante*/
drop procedure if exists obtenerNombreRestaurante;
delimiter //
create procedure obtenerNombreRestaurante(in idRest int, out nombreRes varchar(45))
begin
	select nombre into nombreRes
    from restaurante
    where idRestaurante = idRest;
end// 

delimiter ;


/*numero de platos por categoria de un restaurante*/
drop procedure if exists cantidaddePlatosXCategoria;
delimiter //
create procedure cantidaddePlatosXCategoria(in restauranteConsulta int)
begin
	select nombreCategoria, count(idPlato)
    from plato, categoria
    where  plato.categoria =  categoria.idCategoria and restauranteConsulta = restaurante
    group by idCategoria;
end// 

delimiter ;

drop procedure if exists cantidadDePLatillosXCategoriaXRestaurante;
delimiter //
create procedure cantidadDePLatillosXCategoriaXRestaurante(in restaurante int)
begin
	select idCategoria, count(nombre), nombreCategoria
    from plato, categoria
    where  plato.categoria =  categoria.idCategoria and plato.restaurante = restaurante
    group by idCategoria;
end// 

delimiter ;



