/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.models;

import smartfood.classes.constants.Constantes;

/**
 *
 * @author jlmp1
 */
public class Postre extends AlmuerzoDecorator {

    public Postre(Almuerzo almuerzo) {
        super(almuerzo);
    }
    
    @Override
    public double getCosto() {
        return this.almuerzo.getCosto() + Constantes.VALOR_POSTRE;
    }
    
    public static Almuerzo undecorate(Postre p) {
        return (Almuerzo)p.almuerzo;
    }
}
    
