/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import smartfood.classes.connection.Conexion;

/**
 *
 * @author Jose Luis Masson
 */
public class Almuerzo implements Cloneable {
    
    private String sopa;
    private String segundo;
    private String tipo;
    private String restaurante;
    private double costo;
    private Timestamp fechaRegistro;

    public String getSopa() {
        return sopa;
    }

    public void setSopa(String sopa) {
        this.sopa = sopa;
    }

    public String getSegundo() {
        return segundo;
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Almuerzo clonado = (Almuerzo)super.clone();
        return clonado;
    }
    
//    public static Almuerzo crearCopia(final Almuerzo a) {
//        return a;
//    }
    
    public static ResultSet getListado(Conexion cn) {
        
        try {
            CallableStatement cst = cn.getConnection().prepareCall("{call"
                    + " almuerzos()}");
            cst.execute(); 
            return cst.getResultSet();

        } catch (SQLException ex) {
            return null;   
        }
        
    }
    
}
