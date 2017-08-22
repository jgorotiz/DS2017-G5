/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.models;

import java.sql.Timestamp;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import smartfood.classes.constants.Constantes;
import smartfood.classes.user.Usuario;

/**
 *
 * @author jlmp1
 */
public class PagosTest {
    
    Usuario u;
    TarjetaCreditoStrategy tarjetaExpirada, tarjetaNoExpirada;
    CarneInteligenteStrategy carneConSaldo, carneSinSaldo;
    Almuerzo estudiantil, ejecutivo, ejecutivoConPostre, ejecutivoConBebida;
    Almuerzo ejecutivoConAmbas;

    @Before
    public void setUp() {
        
        u = new Usuario();
        tarjetaExpirada = new TarjetaCreditoStrategy();
        tarjetaNoExpirada = new TarjetaCreditoStrategy();
        carneConSaldo = new CarneInteligenteStrategy();
        carneSinSaldo = new CarneInteligenteStrategy();
        
        tarjetaExpirada.setFechaExpiracion(Timestamp.valueOf("2017-07-01 0:0:0.0"));
        tarjetaNoExpirada.setFechaExpiracion(Timestamp.valueOf("2019-07-01 0:0:0.0"));
        tarjetaExpirada.setSaldo(1000);
        tarjetaNoExpirada.setSaldo(1000);
        
        carneConSaldo.setSaldo(10); // Puede comprar cualquier almuerzo
        carneSinSaldo.setSaldo(2); // No puede comprar cualquier almuerzo
        
        estudiantil = new Almuerzo();
        estudiantil.setCosto(Constantes.VALOR_ESTUDIANTIL);
        estudiantil.setTipo("Estudiantil");
        
        ejecutivo = new Almuerzo();
        ejecutivo.setCosto(Constantes.VALOR_EJECUTIVO);
        ejecutivo.setTipo("Ejecutivo");
        
    }
    
    @Test
    public void testTarjetaExpirada() {
        boolean esperado = false;
        assertEquals(esperado, u.pagar(estudiantil.getCosto(), tarjetaExpirada));
    }
    
    @Test
    public void testTarjetaNoExpirada() {
        boolean esperado = true;
        assertEquals(esperado, u.pagar(estudiantil.getCosto(), tarjetaNoExpirada));
    }
    
    @Test
    public void testTarjetaNoExpiradaConFondos() {
        boolean esperado = true;
        assertEquals(esperado, u.pagar(1000, tarjetaNoExpirada));
    }
    
    @Test
    public void testTarjetaNoExpiradaSinFondos() {
        boolean esperado = false;
        assertEquals(esperado, u.pagar(2000, tarjetaNoExpirada));
    }
    
    @Test
    public void testCarneSinFondos() {
        boolean esperado = false;
        assertEquals(esperado, u.pagar(ejecutivo.getCosto(), carneSinSaldo));
    }
    
    @Test
    public void testCarneConFondos() {
        boolean esperado = true;
        assertEquals(esperado, u.pagar(ejecutivo.getCosto(), carneConSaldo));
    }
    
//    @Test
//    public void testCostoEstudiantil() {
//        float esperado = Constantes.VALOR_ESTUDIANTIL; // 2.50
//        assertEquals(esperado, estudiantil.getCosto(), 0.0);
//    }
//    
//    @Test
//    public void testCostoEjecutivoSinDecorator() {
//        float esperado = Constantes.VALOR_EJECUTIVO; // 3.00
//        assertEquals(esperado, ejecutivo.getCosto(), 0.0);
//    }
//    
//    @Test
//    public void testCostoEjecutivoSoloPostre() {
//        ejecutivoConPostre = new Postre(ejecutivoConPostre);
//        float esperado = Constantes.VALOR_EJECUTIVO + Constantes.VALOR_POSTRE;
//        // 3.75
//        assertEquals(esperado, ejecutivoConPostre.getCosto(), 0.0);
//    }
//    
//    @Test
//    public void testCostoEjecutivoSoloBebida() {
//        ejecutivoConBebida = new Bebida(ejecutivoConBebida);
//        float esperado = Constantes.VALOR_EJECUTIVO + Constantes.VALOR_BEBIDA;
//        // 3.50
//        assertEquals(esperado, ejecutivoConBebida.getCosto(), 0.0);
//    }
//    
//    @Test
//    public void testCostoEjecutivoAmbos() {
//        ejecutivoConAmbas = new Postre(new Bebida(ejecutivoConAmbas));
//        float esperado = Constantes.VALOR_EJECUTIVO + Constantes.VALOR_BEBIDA
//                + Constantes.VALOR_POSTRE;
//        // 4.25
//        assertEquals(esperado, ejecutivoConAmbas.getCosto(), 0.0);
//    }
    
    
}
