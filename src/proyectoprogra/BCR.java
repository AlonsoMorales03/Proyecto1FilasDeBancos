/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuarioo
 */
//Esta sera la clase banco a la que nombramos BRC
public class BCR {
    private ColaConPrioridad cola = new ColaConPrioridad();
    private List<Cajero> cajas = new ArrayList<>();
    private Cajero cajaPlataforma = new Cajero(99, 'E');
    private int consecutivo = 1;

    public BCR() {
        for (int i = 1; i <= 5; i++) {
            cajas.add(new Cajero(i, 'X')); // 'X' atiende todas letras excepto 'E'
        }
    }

    public void registrarCliente() {
        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre inválido.");
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

        int tramite = new Random().nextInt(111) + 10;  // Asignamos tiempos 10 a 120 minutos
        int tolerancia = new Random().nextInt(146) + 5; //Asignamos tiempos 5 a 150 minutos

        Cliente nuevo = new Cliente(nombre, consecutivo++, letra, tramite, tolerancia);
        cola.agregarCliente(nuevo);
        JOptionPane.showMessageDialog(null, "Tiquete generado: " + nuevo);
    }
}
