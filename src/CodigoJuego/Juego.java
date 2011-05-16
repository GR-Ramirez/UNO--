package CodigoJuego;

import java.util.Scanner;




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

   public Juego(String[] jug){//no verifica que sean diferentes nombres, esto tendremos que corregirlo luego
        jugadores= new Jugador[jug.length];
        for(int i=0; i<jug.length;i++)
            jugadores[i]= new Jugador(jug[i]);
        direccion = 1;
        enJuego= Baraja.obtenerCarta();
    }

    static void cambioDir(){
        direccion *= -1;
        System.out.println("Ha cambiado la dirección del juego.");
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

    static int calcularPuntaje(){
        int cPunt= 0;
        for(Jugador jugando: jugadores)
            cPunt+= jugando.puntuacion();
        cPunt-= jugadores[activo].puntuacion();
        return cPunt;
    }

    public void flujoJuego(){//si crees que de otra manera se implementa mejor, cambialo
        Scanner lee= new Scanner(System.in);
        Baraja.crear();
        for (Jugador cadauno: jugadores)
            cadauno.tomarCartas(7);
        enJuego= Baraja.obtenerCarta();
        System.out.println("Se revela la primera carta: " + enJuego.toString());
        enJuego.efecto();
         while (true){
             System.out.println("Turno de "+ jugadores[activo].nombre +"\nLa carta activa es "+ enJuego.toString()+ "\n\tMano");
             for(Carta mn: jugadores[activo].exponer())
                 System.out.println(mn.toString());
             if(jugadores[activo].puede()){
                 System.out.println("Elije la carta que vayas a usar o pasa toma una (0):");
                 manoJugado:
                 while(true){
                     short s= lee.nextShort();
                     if(s==0){
                         jugadores[activo].tomarUna();
                         System.out.println(jugadores[activo].tomada.toString()+
                                 " La piensas jugar? \n1.Sí \n2.No");
                         for(;;){
                             s= lee.nextShort();
                             if(s==1){
                                 if(enJuego.aceptar(jugadores[activo].tomada)){
                                     enJuego= jugadores[activo].tomada;
                                     System.out.println("La carta Descartar pasa ser " + enJuego.toString());
                                     enJuego.efecto();
                                     break manoJugado;
                                 }
                                 else{
                                     System.out.println("No podes jugar esa carta.");
                                     jugadores[activo].ponerEnMano();
                                     break manoJugado;
                                 }
                             }else if(s==2){
                                 System.out.println("Como quieras.");
                                    jugadores[activo].ponerEnMano();
                                     break manoJugado;
                             } else
                                 System.out.println("Ese no es un comando reconocido");
                         }
                     }else if(s>0&&s<=jugadores[activo].exponer().length){
                         if(enJuego.aceptar(jugadores[activo].exponer()[s-1])){
                                     enJuego= jugadores[activo].exponer()[s-1];
                                     jugadores[activo].remover(s-1);
                                     System.out.println("La carta Descartar pasa ser " + enJuego.toString());
                                     enJuego.efecto();
                                     break manoJugado;
                          }  else
                             System.out.println("No podes jugar esa carta ahora.");
                     }else
                         System.out.println("Comando no reconocido.");
                 }
             }else
             System.out.println("Lo siento, pero debes turnos por pasar. No desesperes, te falta uno menos.");
             if (jugadores[activo].exponer().length==1){
                 System.out.println("Felicidades, " + jugadores[activo].nombre + " has ganado esta partida y te quedas con " + calcularPuntaje()+ " puntos!");
                return;
            }
             activo = sigue();
        }
    }
}
