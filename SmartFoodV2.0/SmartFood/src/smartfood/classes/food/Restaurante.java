/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.classes.food;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import smartfood.classes.connection.Conexion;

/**
 *
 * @author Jose Masson
 */
public class Restaurante {
    
    private int idRestaurante;
    private String nombre;
    private String ubicacion;

    public Restaurante(int idRestaurante, String nombre, String ubicacion) {
        this.idRestaurante = idRestaurante;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public static int obtenerIDRes(int idU) {
        Conexion cn = new Conexion();
        
        int res;
        
        res = -1;
        
        try{
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.getConnection().
                    prepareCall("{call obtenerIdRestaurante(?,?)}");
            // Parametro 1 del procedimiento almacenado
            
            cst.setInt(1, idU);
 
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.INTEGER);

            // Ejecuta el procedimiento almacenado
            cst.execute();

            // Se obtienen la salida del procedimineto almacenado
            res = cst.getInt(2);
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
        
        return res;
        
    } 
    
}
