package CodigoJuego;




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

    Juego(Jugador... jug){//no verifica que sean diferentes nombres, esto tendremos que corregirlo luego
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

    public static void flujoJuego(){//si crees que de otra manera se implementa mejor, cambialo
        for (Jugador cadauno: jugadores)
            cadauno.tomarCartas(7);
         while (true){//garantiza que se este repitiendo todo esto, talvez despues la cambiamos a recursiva
            //Flujo de juego, estoy apurado y no lo puedo pensar bien ahorita. 
             if (jugadores[activo].exponer().length==1){
                //codigo para felicitar al ganador
                return;
            }
        }
    }
}
