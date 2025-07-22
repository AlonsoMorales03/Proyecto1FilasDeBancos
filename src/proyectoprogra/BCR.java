
package proyectoprogra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Alonso y Jefferson
 */
//Esta sera la clase banco a la que nombramos BRC
public class BCR {
    private ColaPrioridad cola = new ColaPrioridad();
    private List<Cajero> cajas = new ArrayList<>();
    private Cajero cajaPlataforma = new Cajero(99, 'E');
    private int consecutivo = 1;

    public BCR() {
        // Configuración visual de JOptionPane
    UIManager.put("OptionPane.background", new java.awt.Color(0, 0, 0));
    UIManager.put("Panel.background", new java.awt.Color(0, 0, 0)); // Fondo del área interna
    UIManager.put("OptionPane.messageForeground", new java.awt.Color(255, 192, 192)); // Color del texto
    UIManager.put("Button.background", new java.awt.Color(255, 192, 203)); // Color del botón
        
    for (int i = 1; i <= 5; i++) {
            cajas.add(new Cajero(i, 'X')); // 'X' atiende todas letras excepto 'E'
        }
    }
    
    

    public void registrarCliente() {
        String nombre = JOptionPane.showInputDialog("Ingrese el Nombre del cliente:");
    if (nombre == null || nombre.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nombre invalido.");
        return;
    }

    // Validación: solo letras y espacios
    if (!nombre.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+")) {
        JOptionPane.showMessageDialog(null, "El nombre solo se puede componer de letras. Intenta de nuevo, gracias.");
        return;
    }
        
        String[] opciones = {
            "Adulto Mayor (A)",
            "Mujer embarazada / Niño en brazos (B)",
            "Discapacidad (C)",
            "Varios trámites (D)",
            "Plataforma (E)",
            "Otro (Mujer) (F)",
            "Otro (Hombre) (G)"
        };
        int tipo = JOptionPane.showOptionDialog(null, "Tipo de cliente:", "Categoría",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (tipo == -1) return; // Cancelar

        char letra = switch (tipo) {
            case 0 -> 'A';
            case 1 -> 'B';
            case 2 -> 'C';
            case 3 -> 'D';
            case 4 -> 'E';
            case 5 -> 'F';
            default -> 'G';
        };

        int tramite = new Random().nextInt(111) + 10;  // 10 a 120 minutos
        int tolerancia = new Random().nextInt(146) + 5; // 5 a 150 minutos

        Cliente nuevo = new Cliente(nombre, consecutivo++, letra, tramite, tolerancia);
        cola.agregarCliente(nuevo);
        JOptionPane.showMessageDialog(null, "Tiquete generado: " + nuevo);
    }

    public void simularPasoTiempo() {
        // Incrementar tiempo de espera y eliminar clientes que superan tolerancia
        for (Cliente c : new ArrayList<>(cola.getFila())) {
            c.aumentarEspera();
        }
        cola.eliminarClientesPorTolerancia();

        // Atender clientes en cajas normales (excepto 'E')
        for (Cajero c : cajas) {
            Cliente siguiente = cola.siguienteClienteExcepto('E');
            if (siguiente != null) {
                c.atenderCliente(siguiente);
            }
        }

        // Atender clientes de Plataforma (letra 'E')
        Cliente clientePlataforma = cola.siguienteClienteSolo('E');
        if (clientePlataforma != null) {
            cajaPlataforma.atenderCliente(clientePlataforma);
        }
    }

    public void mostrarReportes() {
        StringBuilder sb = new StringBuilder("Reporte de atención:\n\n");
        int totalAtendidos = 0;
        for (Cajero c : cajas) {
            sb.append("Cajero ").append(c.getId()).append(": atendió ")
              .append(c.getCantidadAtendidos()).append(" clientes. Promedio: ")
              .append(String.format("%.2f", c.getPromedioAtencion())).append(" min\n");
            totalAtendidos += c.getCantidadAtendidos();
        }
        sb.append("Caja Plataforma: atendió ").append(cajaPlataforma.getCantidadAtendidos())
          .append(" clientes. Promedio: ").append(String.format("%.2f", cajaPlataforma.getPromedioAtencion()))
          .append(" min\n");

        int totalClientes = consecutivo - 1;
        int sinAtender = cola.getFila().size();

        sb.append("\nTotal clientes que entraron: ").append(totalClientes);
        sb.append("\nClientes sin atender: ").append(sinAtender);
        sb.append("\nClientes atendidos: ").append(totalAtendidos + cajaPlataforma.getCantidadAtendidos());

        // Conteo por categorías
        Map<Character, Integer> conteoCategorias = new HashMap<>();
        for (Cajero c : cajas) {
            for (Cliente cl : c.atendidos) {
                conteoCategorias.put(cl.getPrioridad(),
                    conteoCategorias.getOrDefault(cl.getPrioridad(), 0) + 1);
            }
        }
        for (Cliente cl : cajaPlataforma.atendidos) {
            conteoCategorias.put(cl.getPrioridad(),
                conteoCategorias.getOrDefault(cl.getPrioridad(), 0) + 1);
        }

        sb.append("\n\nClientes atendidos por categoría:");
        for (Map.Entry<Character, Integer> entry : conteoCategorias.entrySet()) {
            sb.append("\n - ").append(entry.getKey()).append(": ").append(entry.getValue());
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
   
}
