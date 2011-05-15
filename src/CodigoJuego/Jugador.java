package CodigoJuego;

import CodigoJuego.Baraja;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Owner
 */
public class Jugador {
    final private String nombre;
    private long puntos= 0;
    private ArrayList<Carta> mano;
    private byte turnosAPasar= 0;
    
    public Jugador(String nombre){
        this.nombre=nombre;
        this.mano= new ArrayList(Collections.EMPTY_LIST);
    }
    
    private void tomarCartas(int cuantas, int van){
        if (cuantas==van)
            return;
        if (Baraja.barajaVacia())
            Baraja.rebarajar();
        this.mano.add(Baraja.obtenerCarta());
        tomarCartas(cuantas, ++van);
    }

    public void tomarCartas(int meta){
          tomarCartas(meta,0);
    }

    public Carta[] exponer(){
        mano.trimToSize();
        Object falsa[]= mano.toArray();
        return (Carta[])falsa;//conversion tecnicamente innecesaria, pero sirve para documentacion
    }

    void pasar(int turnos){
        this.turnosAPasar += turnos;
    }
}
