package Consola;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import CodigoJuego.*;
/**
 *
 * @author Owner
 */

import java.util.Scanner;
public class MainParaConsola {
    static Scanner lea= new Scanner(System.in);
    public static void main(String args[]){
        Juego jueg;
        System.out.println("Cuantos jugadores jugarán?");
        int canti= lea.nextInt();
        String juga[]= new String[canti];
        for(int i=0; i<canti; i++){
            System.out.println("Ingrese el nombre del jugador numero " + (i+1));
            while (true){
                String jug= lea.next();
                boolean wo= true;
                for(int j=0;j<i;j++)
                    if(jug.equals(juga[j]))
                        wo= false;
                if(wo){
                  juga[i]=jug;
                  break;
            } else
                    System.out.println("Ya existe un jugador con este mismo nombre");
            }
      }
      jueg= new Juego(juga);
      jueg.flujoJuego();
    }

}
