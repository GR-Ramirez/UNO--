package CodigoJuego;

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
        valor= 20;
    }

    void efecto(){
        Juego.siguiente().tomarCartas(2);
        Juego.siguiente().pasar(1);
    }

    @Override
    boolean aceptar(Carta eval){
        if(super.aceptar(eval))
            return true;
        if ((eval.color.equals(this.color))||(eval instanceof TomaDos))
            return true;
        return false;
    }

    public String toString(){
        StringBuilder s= new StringBuilder();
        s.append("-Una Carta de TomaDos ");
        s.append(color.femenino);
        return s.toString();
    }
}
