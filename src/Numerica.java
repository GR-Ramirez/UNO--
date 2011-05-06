/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Numerica extends Carta {
   final static int[] legales= {0, 1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
   final int numero;

   public Numerica(int num, Color color){
        numero= num;
        this.color= color;
        valor= num;
   }

   @Override
   boolean aceptar(Carta evaluar){
        if (!super.aceptar(evaluar))
            return false;
        if (evaluar.color.equals(this.color))
             return true;
        return true;
   }

   void efecto(){
       //nada
   }


}


