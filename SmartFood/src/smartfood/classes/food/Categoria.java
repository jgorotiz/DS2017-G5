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
import smartfood.classes.connection.Conexion;

/**
 *
 * @author Jose Masson
 */
public class Categoria {
    
    private int idCategoria;
    private String nombreCategoria;
    private int totalPlatillos;
    private Date fechaRegistro;

    public Categoria(int idCategoria, String nombreCategoria, 
            Date fechaRegistro) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria(String nombreCategoria, 
            int totalPlatillos, int idCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.totalPlatillos = totalPlatillos;
    }

    public Categoria(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public int getTotalPlatillos() {
        return totalPlatillos;
    }

    public void setTotalPlatillos(int totalPlatillos) {
        this.totalPlatillos = totalPlatillos;
    }
    
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    @Override
    public String toString() {
        return this.nombreCategoria;
    }
    
    public static ResultSet getListadoCategorias(Conexion cn) {
        
        try {
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " obtenerCategorias()}");
            cst.execute(); 
            return cst.getResultSet();

        } catch (SQLException ex) {
            return null;   
        }
        
    }
    
    public static ResultSet getCategorias(Conexion cn) {
        
        try {
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " cantidadDePLatillosXCategoria()}");
            cst.execute(); 
            return cst.getResultSet();

        } catch (SQLException ex) {
            return null;   
        }
    }
}
