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
public class TarjetaCreditoStrategy implements PagoStrategy {
    
    private String numeroTarjeta;
    
    private String cvv;
    
    private float saldo;
    
    private Timestamp fechaExpiracion;

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Timestamp getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Timestamp fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
 
    @Override
    public boolean pagar(float pago) {
        if (this.verificarCredito(pago)) {
            this.saldo -= pago;
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarCredito(float pago) {
        return this.saldo - pago >= 0;
    }
    
}
