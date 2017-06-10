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
    from plato,categoria
    where plato.categoria =  categoria.idCategoria and categoria = nombreCategoria ;
end// 

delimiter ;
    
/* platillos por restaurante dado un tipo*/
delimiter //
create procedure platilloXTipo(in categoria varchar(50))
begin
	select nombre, descripcion, img, nombreTipo, nombreCategoria
    from plato,categoria
    where plato.categoria =  categoria.idCategoria;
end// 

delimiter ;

