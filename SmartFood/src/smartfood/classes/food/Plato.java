/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.classes.food;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Timestamp;
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
    private File img;
    private String categoria;
    private String tipo;
    private String servido;
    private String restaurante;
    private Timestamp fechaRegistro;

    public Plato(int idPlatillo, String nombre, String descripcion, 
            Image imagen, String categoria, String tipo, String restaurante, 
            Timestamp fechaRegistro) {
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

    public Plato(String nombre, String descripcion, File img, 
            String categoria, String tipo, String servido, String restaurante, 
            Timestamp fechaRegistro) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
        this.categoria = categoria;
        this.tipo = tipo;
        this.servido = servido;
        this.restaurante = restaurante;
        this.fechaRegistro = fechaRegistro;
    }

    public Plato(int idPlatillo, String nombre, String descripcion, 
            Image imagen, String categoria, String tipo, String servido, 
            String restaurante) {
        this.idPlatillo = idPlatillo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.categoria = categoria;
        this.tipo = tipo;
        this.servido = servido;
        this.restaurante = restaurante;
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

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }

    public String getServido() {
        return servido;
    }

    public void setServido(String servido) {
        this.servido = servido;
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
    
    public static ResultSet getListadoXRestaurante(Conexion cn, int idR) {
        
        try {
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " platoXRestaurante(?)}");
            cst.setInt(1, idR);
            cst.execute(); 
            return cst.getResultSet();

        } catch (SQLException ex) {
            return null;   
        }
        
    }
    
    public static InputStream obtenerBinarioImagen(File f) {
        try {
            FileInputStream x;
            x = new FileInputStream(f);
            return (InputStream) x;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }
    
    public static boolean agregarPlatillo(Conexion cn, Plato p) {
        
        try {
            FileInputStream x;
            x = new FileInputStream(p.getImg());
            
            
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " insertarPlato(?,?,?,?,?,?,?,?)}");
            cst.setString(1, p.getNombre());
            cst.setString(2, p.getDescripcion());
            
            cst.setBinaryStream(3, (InputStream) x, (int) p.getImg().length());
            cst.setInt(4, Integer.parseInt(p.getCategoria()));
            cst.setInt(5, Integer.parseInt(p.getServido()));
            cst.setInt(6, Integer.parseInt(p.getTipo()));
            cst.setInt(7, Integer.parseInt(p.getRestaurante()));
            cst.setTimestamp(8, p.getFechaRegistro());
            
            cst.execute(); 
            
            return true;
            

        } catch (SQLException | FileNotFoundException ex) {
            return false;   
        }
    
    }
}
