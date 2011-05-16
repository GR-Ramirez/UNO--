package CodigoJuego;

import java.util.Scanner;

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
       Scanner sc= new Scanner(System.in);
        System.out.println("\nElija el nuevo color del comodín: \n1. Rojo \n2. Verde"+
                "\n3. Amarillo \n4. Azul");
       veriCol:
        while (true){
        byte y= sc.nextByte();
            switch(y){
               case 1:
                    color= Color.ROJO;
                    break veriCol;
                case 2:
                    color= Color.VERDE;
                    break veriCol;
                case 3:
                    color= Color.AMARILLO;
                    break veriCol;
                case 4:
                    color= Color.AZUL;
                    break veriCol;
                default:
                    System.out.println("Esa no es una opción valida.");
             }
       }
    }

    public String toString(){
        StringBuilder s= new StringBuilder();
        s.append("-Este es un comodín.");
        if (color != null)           s.append(" Se le ha asignado el color " + color.masculino);
        return s.toString();
    }
}
