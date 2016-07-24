/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import buscaminasq.Casilla;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maurisio
 */
public class TestCasilla {
    
     @Test
    public void testVerificarCasillaTapada(){
        Casilla casilla=new Casilla();
        boolean respuesta=casilla.casillaTapada();
        
        assertTrue(respuesta);
    }
    
    @Test
    public void testVerificarCasillaDestapada(){
        Casilla casilla=new Casilla();
        casilla.destapar();
        boolean respuesta=casilla.casillaTapada();
        
        assertFalse(respuesta);
    }
    @Test
    public void testVerificarCasillaMinada(){
        Casilla casilla=new Casilla();
        casilla.minar();
        boolean respuesta=casilla.minada;
        assertTrue(respuesta);
    }


}
