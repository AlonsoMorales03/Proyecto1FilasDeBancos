
package proyectoprogra;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alonso
 */
//Atributos para la siguiente clase CAJERO 
public class Cajero {
    private int id;
    private char tipo; // 'E' para plataforma, 'X' para cajas normales
    private int tiempoTotal = 0;
    //Creacion de arreglo de esta clase (lista)
    public List<Cliente> atendidos = new ArrayList<>();
    //Constructor clase cajero
    public Cajero(int id, char tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    //Getters de la clase 
    public int getId() {
        return id;
    }
    public int getCantidadAtendidos() {
        return atendidos.size();
    }
    public double getPromedioAtencion() {
        return atendidos.isEmpty() ? 0 : (double) tiempoTotal / atendidos.size();
    }
    //Metodo de la clase cajero
    public void atenderCliente(Cliente c) {
        atendidos.add(c);
        tiempoTotal += c.getTiempoTramite();
    }
}
