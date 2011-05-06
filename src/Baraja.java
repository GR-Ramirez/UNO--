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
        Random aleatorio= new Random(Math.round(Math.random()));// trata de crear la semilla más aleatoria posible
        Collections.shuffle(baraja,aleatorio);
    }

    public static void rebarajar(){
         baraja= new LinkedList();
         crear();
         for(Jugador adores: Juego.jugadores){
                for(Carta aQuitar: adores.exponer())
                    baraja.remove(aQuitar);
            }
    }

    public static Carta obtenerCarta(){
       return baraja.pollFirst();
    }

    public static boolean barajaVacia(){
        return baraja.isEmpty();
    }
    
}
