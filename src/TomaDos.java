/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class TomaDos extends Carta{
    

    TomaDos(Color color){
        this.color= color;
    }

    void efecto(){
        Juego.siguiente().tomarCartas(2);
        Juego.siguiente().pasar(1);
    }
}
