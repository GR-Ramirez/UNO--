package CodigoJuego;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Salta extends Carta{
    Salta(Color col){
        color= col;
        valor= 20;
    }
    @Override
    boolean aceptar(Carta eva){
        if (super.aceptar(eva))
            return true;
        if (color.equals(eva.color))
                return true;
        return false;
    }

    void efecto(){
        System.out.println(Juego.siguiente().nombre + " pierde un turno");
        Juego.siguiente().pasar(1);
    }

    public String toString(){
        StringBuilder s= new StringBuilder();
        s.append("-Una Carta Salta ");
        s.append(color.femenino);
        return s.toString();
    }
}

