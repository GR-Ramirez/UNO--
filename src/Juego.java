/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Juego {
    static Jugador[] jugadores;
    static int activo;
    static private byte direccion;
    static Carta enJuego;

    Juego(Jugador... jug){
        jugadores= jug;
        direccion = 1;
        enJuego= Baraja.obtenerCarta();
    }

    static void cambioDir(){
        direccion *= -1;
    }

    static Jugador siguiente(){
        return jugadores[Juego.sigue()];
    }

    static int sigue(){
        int seguis= activo + direccion;
        if (seguis == jugadores.length)
            seguis = 0;
        if (seguis == -1)
            seguis = jugadores.length -1;
        return seguis;
    }
}
