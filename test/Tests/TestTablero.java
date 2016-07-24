/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;


import buscaminasq.Tablero;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maurisio
 */
public class TestTablero {
    
   @Test 
  public void verificarTamanho1(){
      Tablero tablero = new Tablero(1);
      int tamanho = tablero.matriz.length;
      
      assertEquals(1,tamanho);
  }
  @Test
   public void verificartamanhonovalido(){
     Tablero tablero=new Tablero(1);
     boolean respuesta = tablero.valido();
  
     assertTrue(respuesta);
    }
   
   @Test 
   public void verificarTamanhoNoValido(){
   
     Tablero tablero=new Tablero(0);
     boolean respuesta = tablero.valido();
  
     assertFalse(respuesta);
     
    }
   
    @Test
     public void verificarUnaCasillaCreadas(){
     Tablero tablero=new Tablero(2);
     tablero.colocarCasillas();
     
     assertNotNull(tablero.matriz[0][0]);
   }
     
    @Test
    public void verificarVariasCasillasCreadas(){
     Tablero tablero=new Tablero(2);
     tablero.colocarCasillas();
     
     assertNotNull(tablero.matriz[0][0]);
     assertNotNull(tablero.matriz[1][0]);
     assertNotNull(tablero.matriz[1][1]);
     assertNotNull(tablero.matriz[0][1]);
    }
    
    @Test
    public void contarUnaMina(){
        Tablero tablero=new Tablero(2);
        tablero.colocarCasillas();
        tablero.matriz[0][0].minar();
        int respuesta= tablero.contarMinas();
        assertEquals(1,respuesta);
    }
    
    @Test
    public void contarVariasMinas(){
        Tablero tablero=new Tablero(2);
        tablero.colocarCasillas();
        tablero.matriz[0][0].minar();
        tablero.matriz[0][1].minar();
        tablero.matriz[1][1].minar();
        int respuesta=tablero.contarMinas();
        assertEquals(3,respuesta);
    }
    @Test
     public void verificarPosicionValida(){
         Tablero tablero =new Tablero(3);
         boolean respuesta= tablero.posicionValida(0,0);
         assertTrue(respuesta);
     }
     @Test
     public void verificarPosicionNoValida(){
         Tablero tablero =new Tablero(3);
         boolean respuesta= tablero.posicionValida(3,0);
         assertFalse(respuesta);
     }
     @Test
     public void contarUnaMinaAlrededorCasilla(){
         Tablero tablero=new Tablero(3);
         tablero.colocarCasillas();
         tablero.matriz[0][0].minar();
         int respuesta=tablero.contarMinasAlrededor(1,1);
         assertEquals(1,respuesta);
     }
     @Test
     public void contarMinasAlrededorCasilla(){
         Tablero tablero=new Tablero(3);
         tablero.colocarCasillas();
         tablero.matriz[0][0].minar();
         tablero.matriz[0][1].minar();
         tablero.matriz[0][2].minar();
         tablero.matriz[1][0].minar();
         int respuesta=tablero.contarMinasAlrededor(1,1);
         assertEquals(4,respuesta);
     }
     @Test
     public void colocarMinaEnTablero(){
         Tablero tablero=new Tablero(3);
         tablero.colocarCasillas();
         tablero.colcarMinas(1);
         int respuesta=tablero.contarMinas();
         assertEquals(1,respuesta);
         
     }
     @Test
     public void colocarVariasMinasEnTablero(){
         Tablero tablero=new Tablero(3);
         tablero.colocarCasillas();
         tablero.colcarMinas(3);
         int respuesta=tablero.contarMinas();
         assertEquals(3,respuesta);
         
     }
    @Test
     public void seleccionarUnaCasilla(){
        Tablero tablero=new Tablero(3);
        tablero.colocarCasillas();
        tablero.revelarCasilla(0,0);
        boolean respuesta= tablero.matriz[0][0].casillaTapada();
        assertFalse(respuesta);
    }
    @Test
    public void contarCasillasSinRevelar(){
        Tablero tablero=new Tablero(3);
        tablero.colocarCasillas();
        int respuesta=tablero.contarCasillasNoReveladas();
        assertEquals(9,respuesta);
    }
    @Test
    public void contarUnaCasillaSinRevelar(){
        Tablero tablero=new Tablero(3);
        tablero.colocarCasillas();
        tablero.matriz[0][0].destapar();
        tablero.matriz[0][1].destapar();
        tablero.matriz[0][2].destapar();
        tablero.matriz[1][0].destapar();
        tablero.matriz[1][2].destapar();
        tablero.matriz[2][0].destapar();
        tablero.matriz[2][1].destapar();
        tablero.matriz[2][2].destapar();
        int respuesta=tablero.contarCasillasNoReveladas();
        assertEquals(1,respuesta);
    }
     
}
