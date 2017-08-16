/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.models;

import java.sql.Timestamp;

/**
 *
 * @author jlmp1
 */
public interface Builder {
    
    public abstract void setSopa(String sopa);
    
    public abstract void setSegundo(String segundo);
    
    public abstract void setTipo(String tipo);
    
    public abstract void setRestaurante(String restaurante);
    
    public abstract void setCosto(double costo);
    
    public abstract void setFechaRegistro(Timestamp fechaRegistro);
    
    public abstract Almuerzo getAmuerzo();


    
}
