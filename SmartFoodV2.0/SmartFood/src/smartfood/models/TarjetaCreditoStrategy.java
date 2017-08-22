/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.models;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

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
    public boolean pagar(double pago) {
        if (!this.verificarFechaExpiracion()) {
            return false;
        }
        else if (this.verificarCredito(pago)) {
            this.saldo -= pago;
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarCredito(double pago) {        
        return this.saldo - pago >= 0;
    }
    
    private boolean verificarFechaExpiracion() {
                
        // Obtener día actual
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        Timestamp currentTimestamp = new Timestamp(now.getTime());
        
        return (currentTimestamp.compareTo(this.fechaExpiracion) <= 0);
        
    }
}
