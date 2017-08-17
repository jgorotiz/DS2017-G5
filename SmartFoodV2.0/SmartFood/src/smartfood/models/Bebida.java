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
public class Bebida extends AlmuerzoDecorator {

//    protected Almuerzo almuerzo;
    
    @Override
    public double getCosto() {
        return this.almuerzo.getCosto() + Constantes.VALOR_BEBIDA;
    }
    
}
