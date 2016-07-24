/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminasq;

import java.util.Scanner;

/**
 *
 * @author Maurisio
 */
public class Juego {
   
    private static Scanner scanner;
    private static Tablero tablero;
    private static boolean perdio;
    public static void main(String args[]){
        scanner=new Scanner(System.in);
        perdio=false;
        inicializarTablero();
        tablero.imprimir();
        while(!perdio){
            jugar();
        }
        
    }

    private static void inicializarTablero() {
        System.out.println("Indique la dimension del tablero");
        int tamanho=scanner.nextInt();
        tablero=new Tablero(tamanho);
        tablero.colocarCasillas();
        tablero.colcarMinas(tamanho);
        for(int i=0;i<tablero.matriz.length;i++){
            for(int j=0;j<tablero.matriz.length;j++){
                tablero.contarMinasAlrededor(i, j);
            }
        }
    }

    private static void jugar() {
        int x;
        int y;
        do{
            System.out.println("Ingrese una coodenada en x");
            x =scanner.nextInt();
            System.out.println("Ingrese una coodenada en y");
            y=scanner.nextInt();
        }while(!tablero.posicionValida(x, y));
        if(tablero.matriz[x][y].minada){
            System.out.println("Perdiste");
            perdio=true;
            
        }else{
            if(tablero.contarCasillasNoReveladas()==tablero.contarMinas())System.out.println("Ganaste");
            else{
                cambiarEstado(x,y);
            }
        }
    }

    private static void cambiarEstado(int x, int y) {
        Casilla casilla=tablero.matriz[x][y];
        if(casilla.minasCercanas>0){
            casilla.estado=""+casilla.minasCercanas;
        }else{
            tablero.revelarCasilla(x, y);
        }
        tablero.imprimir();
    }
    
    
}


