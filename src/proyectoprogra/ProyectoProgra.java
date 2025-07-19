/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoprogra;

import javax.swing.JOptionPane;

/**
 *
 * @author Alonso
 */
public class ProyectoProgra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //System.out.println("Creacion de repo y conexion a IDE");
        BCR banco = new BCR();
        String[] opciones = {"Registrar Cliente", "Simular Atención", "Ver Reportes", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Banco con Colas de Prioridad",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0 -> banco.registrarCliente();
                case 1 -> banco.simularPasoTiempo();
                case 2 -> banco.mostrarReportes();
            }
        } while (opcion != 3);
    }
    }
    

