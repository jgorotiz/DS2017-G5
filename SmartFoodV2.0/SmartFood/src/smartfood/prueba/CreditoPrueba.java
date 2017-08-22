/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.prueba;

import java.sql.Timestamp;
import java.util.Calendar;
import smartfood.classes.user.Usuario;
import smartfood.models.PagoStrategy;
import smartfood.models.TarjetaCreditoStrategy;

/**
 *
 * @author jlmp1
 */
public class CreditoPrueba {
    
    public static void main(String[] args) {
        
        Calendar calendar = Calendar.getInstance();

    // 2) get a java.util.Date from the calendar instance.
    //    this date will represent the current instant, or "now".
    java.util.Date now = calendar.getTime();
    
        System.out.println(now);
        
        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2017-07-01 0:0:0.0");
    
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        System.out.println(currentTimestamp.compareTo(timestamp));
        
        Usuario u = new Usuario();
        TarjetaCreditoStrategy estrategia;
        
        estrategia = new TarjetaCreditoStrategy();
        estrategia.setFechaExpiracion(Timestamp.valueOf("2017-07-01 0:0:0.0"));
        estrategia.setSaldo(1000F);
        System.out.println(estrategia.getFechaExpiracion());
        System.out.println(u.pagar(1000, estrategia));
        
        
        
    }
    
}
