/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartfood.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import smartfood.classes.constants.Constantes;

/**
 *
 * @author jlmp1
 */
public class AlmuerzoTest {
    
    Almuerzo estudiantil, ejecutivo, ejecutivoConPostre, ejecutivoConBebida;
    Almuerzo ejecutivoConAmbas;

    @Before
    public void setUp() {
        estudiantil = new Almuerzo();
        estudiantil.setCosto(Constantes.VALOR_ESTUDIANTIL);
        estudiantil.setTipo("Estudiantil");
        ejecutivo = new Almuerzo();
        ejecutivo.setCosto(Constantes.VALOR_EJECUTIVO);
        ejecutivo.setTipo("Ejecutivo");
        ejecutivoConPostre = new Almuerzo();
        ejecutivoConPostre.setCosto(Constantes.VALOR_EJECUTIVO);
        ejecutivoConPostre.setTipo("Ejecutivo");
        ejecutivoConBebida = new Almuerzo();
        ejecutivoConBebida.setCosto(Constantes.VALOR_EJECUTIVO);
        ejecutivoConBebida.setTipo("Ejecutivo");
        ejecutivoConAmbas  = new Almuerzo();
        ejecutivoConAmbas.setCosto(Constantes.VALOR_EJECUTIVO);
        ejecutivoConAmbas.setTipo("Ejecutivo");
    }
    
    @Test
    public void testCostoEstudiantil() {
        float esperado = Constantes.VALOR_ESTUDIANTIL; // 2.50
        assertEquals(esperado, estudiantil.getCosto(), 0.0);
    }
    
    @Test
    public void testCostoEjecutivoSinDecorator() {
        float esperado = Constantes.VALOR_EJECUTIVO; // 3.00
        assertEquals(esperado, ejecutivo.getCosto(), 0.0);
    }
    
    @Test
    public void testCostoEjecutivoSoloPostre() {
        ejecutivoConPostre = new Postre(ejecutivoConPostre);
        float esperado = Constantes.VALOR_EJECUTIVO + Constantes.VALOR_POSTRE;
        // 3.75
        assertEquals(esperado, ejecutivoConPostre.getCosto(), 0.0);
    }
    
    @Test
    public void testCostoEjecutivoSoloBebida() {
        ejecutivoConBebida = new Bebida(ejecutivoConBebida);
        float esperado = Constantes.VALOR_EJECUTIVO + Constantes.VALOR_BEBIDA;
        // 3.50
        assertEquals(esperado, ejecutivoConBebida.getCosto(), 0.0);
    }
    
    @Test
    public void testCostoEjecutivoAmbos() {
        ejecutivoConAmbas = new Postre(new Bebida(ejecutivoConAmbas));
        float esperado = Constantes.VALOR_EJECUTIVO + Constantes.VALOR_BEBIDA
                + Constantes.VALOR_POSTRE;
        // 4.25
        assertEquals(esperado, ejecutivoConAmbas.getCosto(), 0.0);
    }
    
    
}
