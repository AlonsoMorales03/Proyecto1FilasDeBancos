
package proyectoprogra;
//importaciones necesarias
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



/**
 *
 * @author Alonso Y Jefferson
 */

    //Comprobar si el error esta arreglado 
    //Si se arreglo compañero xd
public class ColaPrioridad {
    private List<Cliente> fila = new ArrayList<>();

    public void agregarCliente(Cliente c) {
        fila.add(c);
        fila.sort(Comparator.comparingInt(a -> prioridadValor(a.getPrioridad())));
    }

    private int prioridadValor(char p) {
        return switch (p) {
            case 'A' -> 1;
            case 'B', 'C' -> 2;
            case 'D' -> 3;
            case 'E' -> 4;
            case 'F', 'G' -> 5;
            default -> 6;
        };
    }

    public Cliente siguienteClienteExcepto(char letra) {
        for (Cliente c : fila) {
            if (c.getPrioridad() != letra) {
                fila.remove(c);
                return c;
            }
        }
        return null;
    }

    public Cliente siguienteClienteSolo(char letra) {
        for (Cliente c : fila) {
            if (c.getPrioridad() == letra) {
                fila.remove(c);
                return c;
            }
        }
        return null;
    }

    public void eliminarClientesPorTolerancia() {
        fila.removeIf(Cliente::seVaSinAtender);
    }

    public List<Cliente> getFila() {
        return fila;
    }
}
