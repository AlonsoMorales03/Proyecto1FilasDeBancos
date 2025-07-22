/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoprogra;

import java.awt.Image;
import javax.swing.ImageIcon;
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
        // Cargar la imagen (usa una ruta correcta relativa al proyecto)
        ImageIcon icono = new ImageIcon("src/Imagenes/BCR.png");
        
        // Escalar a tamaño pequeño tipo logo (32x32 píxeles)
        Image imagenEscalada = icono.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon logoPequeno = new ImageIcon(imagenEscalada);
        
        // Crear instancia del sistema bancario
        BCR banco = new BCR();

        // Opciones para el menú
        String[] opciones = {"Registrar Cliente", "Simular Atención", "Ver Reportes", "Salir"};
        int opcion;

        do {
            // Mostrar el menú con logo personalizado
            opcion = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción",
                "Banco con Colas de Prioridad",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                logoPequeno,
                opciones,
                opciones[0]
            );

            switch (opcion) {
                case 0 -> banco.registrarCliente();
                case 1 -> banco.simularPasoTiempo();
                case 2 -> banco.mostrarReportes();
            }
        } while (opcion != 3);
    }
        
    }
    

