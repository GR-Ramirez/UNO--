package CodigoJuego;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Owner
 */
public class Jugador {
    Carta[] wey= {};
    final public String nombre;
    private long puntos= 0;
    private ArrayList<Carta> mano;
    private byte turnosAPasar= 0;
    Carta tomada;
    static boolean won;
    
    public Jugador(String nombre){
        this.nombre=nombre;
        this.mano= new ArrayList(Collections.EMPTY_LIST);
    }

    public boolean puede(){
        if(turnosAPasar== 0)
            return true;
        turnosAPasar--;
        return false;
    }
    private void tomarCartas(int cuantas, int van){
        if (cuantas==van)
            return;
       won= this.mano.add(Baraja.obtenerCarta());
        tomarCartas(cuantas, ++van);
    }

    public void tomarCartas(int meta){
          tomarCartas(meta,0);
          mano.trimToSize();
    }

    public Carta[] exponer(){
        mano.trimToSize();
        Object falsa[]= mano.toArray();
        if(falsa instanceof Carta[])
        return (Carta[])falsa;
        return wey;
   }

    void pasar(int turnos){
        this.turnosAPasar += turnos;
    }

    public void tomarUna(){
        tomada= Baraja.obtenerCarta();
    }

    public void ponerEnMano(){
        won= mano.add(tomada);
        mano.trimToSize();
    }

    public void remover(int numero){
        mano.remove(numero);
    }
    
    int puntuacion(){
        int punt= 0;
        for(Carta enMano: mano){
            punt+= enMano.valor;
        }
        return punt;
    }
}
