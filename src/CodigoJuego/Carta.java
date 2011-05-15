package CodigoJuego;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Owner
 */
public abstract class Carta{
    public enum Color {ROJO, AZUL, VERDE, AMARILLO}
    Color color;
    int valor;


  boolean aceptar(Carta evaluada){
       boolean sePuede= true;
       if (evaluada instanceof Comodin)
           return sePuede;
       if (evaluada instanceof Toma4){
           for (Carta enMano: Juego.jugadores[Juego.activo].exponer()){
               if (enMano.color.equals(Juego.enJuego.color))
                   return false;
           }
       }
       else
           sePuede=false;
       return sePuede;
   }

   abstract void efecto();

}

