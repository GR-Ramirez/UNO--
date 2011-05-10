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
        Juego.siguiente().pasar(1);
    }
}

