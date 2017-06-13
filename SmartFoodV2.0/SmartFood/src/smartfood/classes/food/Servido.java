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
public class Servido {
    
    private int idServido;
    private String nombreServido;
    private Timestamp fechaRegistro;

    public Servido(int idServido, String nombreServido, Timestamp fechaRegistro) {
        this.idServido = idServido;
        this.nombreServido = nombreServido;
        this.fechaRegistro = fechaRegistro;
    }

    public Servido(int idServido, String nombreServido) {
        this.idServido = idServido;
        this.nombreServido = nombreServido;
    }

    public Servido(String nombreServido) {
        this.nombreServido = nombreServido;
    }

    public int getIdServido() {
        return idServido;
    }

    public void setIdServido(int idServido) {
        this.idServido = idServido;
    }

    public String getNombreServido() {
        return nombreServido;
    }

    public void setNombreServido(String nombreServido) {
        this.nombreServido = nombreServido;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    @Override
    public String toString() {
        return this.nombreServido;
    }
    
    public static ResultSet getListadoServidos(Conexion cn) {
        
        try {
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " obtenerServido()}");
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
        final Servido other = (Servido) obj;
        return Objects.equals(this.nombreServido, other.nombreServido);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.nombreServido);
        return hash;
    }



}
