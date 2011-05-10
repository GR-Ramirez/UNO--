/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Toma4 extends Comodin{


    void efecto(){
        super.efecto();
        Juego.siguiente().tomarCartas(4);
        Juego.siguiente().pasar(1);
    }

}
