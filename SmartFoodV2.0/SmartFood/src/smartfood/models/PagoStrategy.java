/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.models;

/**
 *
 * @author jlmp1
 */
public interface PagoStrategy {
    
    public abstract boolean pagar(double pago);
    
    public abstract boolean verificarCredito(double pago);
    
}
