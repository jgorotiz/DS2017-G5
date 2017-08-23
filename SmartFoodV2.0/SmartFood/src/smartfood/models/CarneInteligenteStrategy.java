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
public class CarneInteligenteStrategy implements PagoStrategy {
    
    private String numeroMatricula;
    
    private float saldo;

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean pagar(double pago) {
        if (this.verificarCredito(pago)) {
            this.saldo -= pago;
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarCredito(double pago) {
        return this.saldo - pago >= 0;
    }
    
    
}
