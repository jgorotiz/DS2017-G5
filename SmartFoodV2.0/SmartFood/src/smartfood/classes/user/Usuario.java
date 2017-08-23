/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.classes.user;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import smartfood.classes.connection.Conexion;
import smartfood.models.PagoStrategy;

/**
 *
 * @author Jose Masson
 */
public class Usuario {
    
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String usuario;
    private String contrasenia;
    private String rol;
    private Date fechaRegistro;
    private boolean activo;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String apellido, String correo,
            String usuario, String contrasenia, String rol, Date fechaRegistro, 
            boolean activo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public boolean pagar(double pago, PagoStrategy strategy) {
        return strategy.pagar(pago);
    }
     
    public static ArrayList<String> buscarUsuario(String usuario, 
            String clave) {
        Conexion cn = new Conexion();
        
        
        ArrayList<String> validadorUsuario = new ArrayList<>();
        
        int res, idU;
        
        String rol = "";
        
        res = idU = -1;
        
        try{
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.getConnection().
                    prepareCall("{call  login(?,?,?,?,?)}");
            // Parametro 1 del procedimiento almacenado
            
            //String username= "fblayedr";
            cst.setString(1, usuario);
            //String contrasenia= "turtoise";
            cst.setString(2, clave);

            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(3, java.sql.Types.INTEGER);
            
            cst.registerOutParameter(4, java.sql.Types.INTEGER);
            
            cst.registerOutParameter(5, java.sql.Types.INTEGER);

            // Ejecuta el procedimiento almacenado
            cst.execute();

            // Se obtienen la salida del procedimineto almacenado
            res = cst.getInt(3);
            rol = cst.getString(4);
            idU = cst.getInt(5);
        } 
        catch (SQLException ex) {
            System.out.println("Error SQL");
        } 
        finally {
            try {
                cn.getConnection().close();
            } catch (SQLException ex) {
                System.out.println("Error en cierre de conexion");
            }
        }
        
        validadorUsuario.add(Integer.toString(res));
        validadorUsuario.add(rol);
        validadorUsuario.add(Integer.toString(idU));
        
        return validadorUsuario;
    }              
            
}
