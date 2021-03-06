/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.models;

/**
 *
 * @author José Luis Massón
 */
public abstract class AlmuerzoDecorator extends Almuerzo {
    
    protected Almuerzo almuerzo;
    
    public AlmuerzoDecorator(Almuerzo almuerzo) {
        this.almuerzo = almuerzo;
    }
    
    @Override
    public abstract double getCosto(); 
    
    public Almuerzo Undecorate() {
        return (Almuerzo)this.almuerzo;
    }
}

