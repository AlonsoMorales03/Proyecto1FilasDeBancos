
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
public class ColaConPrioridad {
    //Se  declara una lista la cual se llama fila y los objetos que contendra son de tipo cliente 
    private List<Cliente> fila = new ArrayList<>();
    // El metodo prioridad valor convierte la letra en un numero 
    //El cambio de numeros sera para que la letra con menor valor numerico tenga mayor prioridad
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
    //Este metodo de buscay  devuelve el primer cliente cuya prioridad no sea igual a la letra asignada 
    //Al devolverlo de la fila lo elimina, si no hay ninguno lo retornara como vacio(null)
    public Cliente siguienteClienteExcepto(char letra) {
        for (Cliente c : fila) {
            if (c.getPrioridad() != letra) {
                fila.remove(c);
                return c;
            }
        }
        return null;
    }
    //Este metodo busca y devuelve el primer cliente cuya prioridad si coincida con la letra asignada 
    //El resto es igual que el metodo anterior
    public Cliente siguienteClienteSolo(char letra) {
        for (Cliente c : fila) {
            if (c.getPrioridad() == letra) {
                fila.remove(c);
                return c;
            }
        }
        return null;
    }
    //Este metodo elimina todos los clientes que cumplan con la condicion de atencion
    public void eliminarClientesPorTolerancia() {
        fila.removeIf(Cliente::sinAtencion);
    }
    //Acá  se devuelve la lista  actual de clientes en la fila 
    public List<Cliente> getFila() {
        return fila;
    }
    //Se agrega un cliente a la cola 
    //Esta ordena la lista mediante el metodo prioridad valor y convierte la prioridad en tipo char para facilitar la comparacion 
     public void agregarCliente(Cliente c) {
        fila.add(c);
        fila.sort(Comparator.comparingInt(a -> prioridadValor(a.getPrioridad())));
    }
}
