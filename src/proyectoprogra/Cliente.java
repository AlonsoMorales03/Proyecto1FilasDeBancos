
package proyectoprogra;

/**
 *
 * @author Jefferson
 */

    public class Cliente {
        private String nombre;
        private int consecutivo;
        private char prioridad;
        private int tiempoTramite;
        private int tolerancia;
        private int tiempoEspera;
    //Metodo Contructor
    public Cliente(String nombre, int consecutivo, char prioridad, int tiempoTramite, int tolerancia) {
        this.nombre = nombre;
        this.consecutivo = consecutivo;
        this.prioridad = prioridad;
        this.tiempoTramite = tiempoTramite;
        this.tolerancia = tolerancia;
        this.tiempoEspera = 0;
    }
   //Getters de la clase y Metodos seVaSinAtender y aumentarEspera
    public char getPrioridad() {
        return prioridad;
    }

    public int getTolerancia() {
        return tolerancia;
    }

    public int getTiempoTramite() {
        return tiempoTramite;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void aumentarEspera() {
        this.tiempoEspera++;
    }

    public boolean seVaSinAtender() {
        return tiempoEspera >= tolerancia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    @Override
    public String toString() {
        return nombre + " - " + consecutivo + prioridad + " (Tramite: " + tiempoTramite + " minutos)";
    }
    
    
    
    
}
