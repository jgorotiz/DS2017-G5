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

