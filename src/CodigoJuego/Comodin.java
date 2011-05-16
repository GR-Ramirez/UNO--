package CodigoJuego;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Comodin extends Carta{
    Comodin(){
        valor= 50;
    }
    @Override
    boolean aceptar(Carta evalu){
        if (super.aceptar(evalu))
            return true;
        if (evalu.color.equals(this.color))
            return true;
        return false;
    }

    void efecto(){
       //codigo para cambiar de color
    }

    public String toString(){
        StringBuilder s= new StringBuilder();
        s.append("-Este es un comodín.");
        if (color.equals(color.ROJO)||color.equals(color.AZUL)||color.equals(color.AMARILLO)||color.equals(color.VERDE))
            s.append(" Se le ha asignado el color " + color.masculino);
        return s.toString();
    }
}
