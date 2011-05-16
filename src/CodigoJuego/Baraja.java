package CodigoJuego;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Baraja {

    private static LinkedList<Carta> baraja= new LinkedList();

    private Baraja(){

    }

    public static void crear(){
       int i=0;
       for( Carta.Color col: Carta.Color.values()){
            for(int num: Numerica.legales)
                baraja.add(new Numerica(num,col));
            for(i=0; i<2; i++){
                baraja.add(new Reversa(col));
                baraja.add(new TomaDos(col));
                baraja.add(new Salta(col));
            }
       }
       for(i=0; i<4; i++){
           baraja.add(new Comodin());
           baraja.add(new Toma4());
       }
       Random aleatorio= new Random(Math.round(Math.random()*10));// trata de crear la semilla más aleatoria posible
       Collections.shuffle(baraja,aleatorio);
    }

    public static void rebarajar(){
         baraja= new LinkedList();
         crear();
         for(Jugador adores: Juego.jugadores){
                for(Carta aQuitar: adores.exponer())
                    baraja.remove(aQuitar);
            }
         baraja.remove(Juego.enJuego);
    }

    static Carta obtenerCarta(){
       if (barajaVacia())
           rebarajar();
       return baraja.pollFirst();
    }

    private static boolean barajaVacia(){
        return baraja.isEmpty();
    }
    
}
