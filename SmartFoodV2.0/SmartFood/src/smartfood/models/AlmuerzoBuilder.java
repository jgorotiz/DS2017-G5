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
public class AlmuerzoBuilder implements Builder {

    private Almuerzo almuerzo;
    
    public void crearAlmuerzo() {
        this.almuerzo = new Almuerzo();
    }
    
    @Override
    public void setSopa(String sopa) {
        this.almuerzo.setSopa(sopa);
    }

    @Override
    public void setSegundo(String segundo) {
        this.almuerzo.setSegundo(segundo);
    }
    
    @Override
    public void setTipo(String tipo) {
        this.almuerzo.setTipo(tipo);
    }
    
    @Override
    public void setRestaurante(String restaurante) {
        this.almuerzo.setRestaurante(restaurante);
    }

    @Override
    public void setCosto(double costo) {
        this.almuerzo.setCosto(costo);
    }

    @Override
    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.almuerzo.setFechaRegistro(fechaRegistro);
    }

    @Override
    public Almuerzo getAmuerzo() {
        return this.almuerzo;
    }
    
}
