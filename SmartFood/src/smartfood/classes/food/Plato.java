/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.classes.food;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.image.Image;
import smartfood.classes.connection.Conexion;

/**
 *
 * @author Jose Masson
 */
public class Plato {
    
    private int idPlatillo;
    private String nombre;
    private String descripcion;
    private Image imagen;
    private String categoria;
    private String tipo;
    private String restaurante;
    private Date fechaRegistro;

    public Plato(int idPlatillo, String nombre, String descripcion, 
            Image imagen, String categoria, String tipo, String restaurante, 
            Date fechaRegistro) {
        this.idPlatillo = idPlatillo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.categoria = categoria;
        this.tipo = tipo;
        this.restaurante = restaurante;
        this.fechaRegistro = fechaRegistro;
    }

    public Plato(String nombre, String descripcion,
            String categoria, String tipo, String restaurante, Image imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tipo = tipo;
        this.restaurante = restaurante;
        this.imagen = imagen;
    }
    
    public int getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(int idPlatillo) {
        this.idPlatillo = idPlatillo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public static ResultSet getListadoXCategoria(Conexion cn, int categoria) {
        
        try {
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " platilloXIDCategoria(?)}");
            cst.setInt(1, categoria);
            cst.execute(); 
            return cst.getResultSet();

        } catch (SQLException ex) {
            return null;   
        }
        
    }
    
    public static ResultSet getListadoXNombre(Conexion cn, String nombre) {
        
        try {
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " platilloXNombre(?)}");
            cst.setString(1, nombre);
            cst.execute(); 
            return cst.getResultSet();

        } catch (SQLException ex) {
            return null;   
        }
        
    }
    
    public static ResultSet getListadoXDescripcion(Conexion cn, String des) {
        
        try {
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " platilloXDescripcion(?)}");
            cst.setString(1, des);
            cst.execute(); 
            return cst.getResultSet();

        } catch (SQLException ex) {
            return null;   
        }
        
    }
}
