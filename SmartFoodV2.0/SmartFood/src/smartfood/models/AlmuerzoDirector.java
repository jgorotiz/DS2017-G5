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
public class AlmuerzoDirector {
    
    private AlmuerzoBuilder almuerzoBuilder;

    public void setAlmuerzoBuilder(AlmuerzoBuilder almuerzoBuilder) {
        this.almuerzoBuilder = almuerzoBuilder;
    }
        
    public Almuerzo getAlmuerzo() {
        return this.almuerzoBuilder.getAmuerzo();
    }
    
    public void construirAlmuerzo(String sopa, String segundo, double costo,
            String tipo, String restaurante, Timestamp fechaRegistro) {
        this.almuerzoBuilder.crearAlmuerzo();
        this.almuerzoBuilder.setSopa(sopa);
        this.almuerzoBuilder.setSegundo(segundo);
        this.almuerzoBuilder.setCosto(costo);
        this.almuerzoBuilder.setRestaurante(restaurante);
        this.almuerzoBuilder.setTipo(tipo);
        this.almuerzoBuilder.setFechaRegistro(fechaRegistro);
    }
}
