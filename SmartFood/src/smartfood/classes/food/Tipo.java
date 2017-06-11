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
import smartfood.classes.connection.Conexion;

/**
 *
 * @author Jose Masson
 */
public class Tipo {
    
    private int idTipo;
    private String nombreTipo;
    private Timestamp fechaRegistro;

    public Tipo(int idTipo, String nombreTipo, Timestamp fechaRegistro) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
        this.fechaRegistro = fechaRegistro;
    }

    public Tipo(int idTipo, String nombreTipo) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    @Override
    public String toString() {
        return this.nombreTipo;
    }
    
    public static ResultSet getListadoTipos(Conexion cn) {
        
        try {
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " obtenerTipos()}");
            cst.execute(); 
            return cst.getResultSet();

        } catch (SQLException ex) {
            return null;   
        }
        
    }
}
