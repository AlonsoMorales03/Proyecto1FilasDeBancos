
package proyectoprogra;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alonso
 */
//Atributos para la siguiente clase CAJERO 
public class Cajero {
    //Atributos de la clase Cajero
   private int id;
    private char tipo; // 'E' es para plataforma y 'X' para cajas normales
    public List<Cliente> atendidos = new ArrayList<>();
    private int tiempoTotal = 0;
    //Metodo Contructor
    public Cajero(int id, char tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    //Getter necesarios de la Clase y un metodo llamado PromedioAtencion
    public void atenderCliente(Cliente c) {
        atendidos.add(c);
        tiempoTotal += c.getTiempoTramite();
    }

    public int getId() {
        return id;
    }

    public int getCantidadAtendidos() {
        return atendidos.size();
    }

    public double getPromedioAtencion() {
        return atendidos.isEmpty() ? 0 : (double) tiempoTotal / atendidos.size();
    }
}
