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
public class PlatoBuilder implements Builder {
    
    protected Plato plato;
    
    @Override
    public void setNombre(String nombre) {
        this.plato.setNombre(nombre);
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.plato.setDescripcion(descripcion);
    }

    @Override
    public void setCosto(float costo) {
        
    }

    @Override
    public void setImagen(Image imagen) {
        this.plato.setImagen(imagen);
    }

    @Override
    public void setCategoria(String categoria) {
        this.plato.setCategoria(categoria);
    }

    @Override
    public void setTipo(String tipo) {
        this.plato.setTipo(tipo);
    }

    @Override
    public void setServido(String servido) {
        this.plato.setServido(servido);
    }

    @Override
    public void setRestaurante(String restaurante) {
        this.plato.setRestaurante(restaurante);
    }

    @Override
    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.plato.setFechaRegistro(fechaRegistro);
    }

    @Override
    public Plato getPlato() {
        return this.plato;
    }
    
}
