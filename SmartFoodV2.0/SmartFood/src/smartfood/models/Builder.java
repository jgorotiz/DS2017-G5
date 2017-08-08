/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.models;

import java.sql.Timestamp;
import javafx.scene.image.Image;
import smartfood.classes.food.Plato;

/**
 *
 * @author jlmp1
 */
public interface Builder {
    
    public abstract void setNombre(String nombre);
    
    public abstract void setDescripcion(String descripcion);
    
    public abstract void setCosto(float costo);
    
    public abstract void setImagen(Image imagen);

    public abstract void setCategoria(String categoria);
    
    public abstract void setTipo(String tipo);
    
    public abstract void setServido(String servido);
    
    public abstract void setRestaurante(String restaurante);
    
    public abstract void setFechaRegistro(Timestamp fechaRegistro);
    
    public abstract Plato getPlato();


    
}
