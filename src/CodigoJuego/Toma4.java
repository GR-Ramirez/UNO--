package CodigoJuego;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Toma4 extends Comodin{

    Toma4(){
        super();
    }
    @Override
    void efecto(){
        super.efecto();
        Juego.siguiente().tomarCartas(4);
        Juego.siguiente().pasar(1);
    }
    @Override
   public String toString(){
        StringBuilder s= new StringBuilder();
        s.append("-Este es un Toma4.");
        if (color.equals(color.ROJO)||color.equals(color.AZUL)||color.equals(color.AMARILLO)||color.equals(color.VERDE))
            s.append(" Se le ha asignado el color " + color.masculino);
        return s.toString();
    }

}
