/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Usuarioo
 */
public class ColaConPrioridad {
    //Esta lista representa la cola de clientes segun el orden de prioridad 
    private List<Cliente> fila = new ArrayList<>();
    //Agregar un nuevo cliene a la cola y luego la ordena segun la prioridad de mas baja a mas urgente
    public void agregarCliente(Cliente c) {
        fila.add(c);
        fila.sort(Comparator.comparingInt(a -> prioridadValor(a.getPrioridad())));
    }
    //Aca se convierte el caracter a un avlor numerico para asignar las prioridades 
    //Siendo la letra A mas urgente y la G la de menos urgencia 
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
        fila.removeIf(Cliente::sinAtencion);
    }

    public List<Cliente> getFila() {
        return fila;
    }
}
