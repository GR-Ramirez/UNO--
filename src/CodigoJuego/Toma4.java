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
         System.out.println(Juego.siguiente().nombre + " pierde un turno y toma 4 cartas.");
        Juego.siguiente().tomarCartas(4);
        Juego.siguiente().pasar(1);
    }
    @Override
   public String toString(){
        StringBuilder s= new StringBuilder();
        s.append("-Este es un Toma4.");
        if (color != null)
            s.append(" Se le ha asignado el color " + color.masculino);
        return s.toString();
    }

}
