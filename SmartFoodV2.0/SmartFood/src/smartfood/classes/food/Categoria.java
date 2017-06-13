/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.classes.food;

import java.sql.CallableStatement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import smartfood.classes.connection.Conexion;

/**
 *
 * @author Jose Masson
 */
public class Categoria {
    
    private int idCategoria;
    private String nombreCategoria;
    private int totalPlatillos;
    private Timestamp fechaRegistro;

    public Categoria(int idCategoria, String nombreCategoria, 
            Timestamp fechaRegistro) {
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

    public Categoria(String nombreCategoria) {
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

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        return Objects.equals(this.nombreCategoria, other.nombreCategoria);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombreCategoria);
        return hash;
    }

    
    public static ResultSet getListadoCategoriasXRestaurante(Conexion cn, 
            int idR) {
        
        try {
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " cantidadDePLatillosXCategoriaXRestaurante(?)}");
            cst.setInt(1, idR);
            cst.execute(); 
            return cst.getResultSet();

        } catch (SQLException ex) {
            return null;   
        }
        
    }

}
