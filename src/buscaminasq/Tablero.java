/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminasq;

import java.util.Random;

/**
 *
 * @author Maurisio
 */
 public class Tablero {
    public Casilla[][] matriz;
    
    public Tablero(int tamanho){
        matriz=new Casilla[tamanho][tamanho];
        
        
    }

    public boolean valido() {
        return matriz.length>0;
    }

    
    public void colocarCasillas() {
        for(int i = 0; i < matriz.length; i++ ){
          for(int j = 0; j < matriz.length; j++ ){
              matriz[i][j] = new Casilla();
          }
         }
    }

    public int contarMinas() {
        int respuesta=0;
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                if(matriz[i][j].minada==true){
                    respuesta+=1;
                }
            }
        }
        return respuesta;
    }

    public boolean posicionValida(int x, int y) {
        return x>=0&&y>=0&&x<matriz.length&&y<matriz[0].length;
    }

    public int contarMinasAlrededor(int x, int y) {
        int respuesta=0;
        if(posicionValida(x+1,y)&&matriz[x+1][y].minada)respuesta+=1;
        if(posicionValida(x-1,y)&&matriz[x-1][y].minada)respuesta+=1;
        if(posicionValida(x,y-1)&&matriz[x][y-1].minada)respuesta+=1;
        if(posicionValida(x,y+1)&&matriz[x][y+1].minada)respuesta+=1;
        if(posicionValida(x+1,y-1)&&matriz[x+1][y-1].minada)respuesta+=1;
        if(posicionValida(x-1,y-1)&&matriz[x-1][y-1].minada)respuesta+=1;
        if(posicionValida(x-1,y+1)&&matriz[x-1][y+1].minada)respuesta+=1;
        if(posicionValida(x+1,y+1)&&matriz[x+1][y+1].minada)respuesta+=1;
        matriz[x][y].minasCercanas=respuesta;
        return respuesta;
    }

    public void colcarMinas(int i) {
        Random random=new Random();
        int r=1;
        while(r<=i){
            int x=random.nextInt(matriz.length);
            int y=random.nextInt(matriz.length);
            if(!matriz[x][y].minada) {
                matriz[x][y].minar();
                r++;
            }
        }
    }     

    public void revelarCasilla(int x, int y) {
        matriz[x][y].destapar();
    }

    public int contarCasillasNoReveladas() {
       int respuesta=0;
       for(int i=0;i<matriz.length;i++){
           for(int j=0;j<matriz.length;j++){
               if(matriz[i][j].casillaTapada()){
                   respuesta+=1;
               }
           }
       }
       return respuesta;
    }
    public void imprimir(){
        for(int i=0;i<matriz.length;i++){
           for(int j=0;j<matriz.length;j++){
               System.out.print(matriz[i][j].estado);
           }
           System.out.println("");
       }
    }
}
