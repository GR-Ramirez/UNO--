/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Reversa extends Carta{

    Reversa(Color col){
        color= col;
    }

    boolean aceptar(Carta eval){
        if (!super.aceptar(eval))
            return false;

    }

    void efecto(){
        Juego.cambioDir();
    }
}
