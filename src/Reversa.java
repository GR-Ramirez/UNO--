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

    @Override
    boolean aceptar(Carta eval){
        if (super.aceptar(eval))
            return true;
        if ((eval instanceof Reversa)||(eval.color.equals(this.color)))
            return true;
        return false;

    }

    void efecto(){
        Juego.cambioDir();
    }
}
