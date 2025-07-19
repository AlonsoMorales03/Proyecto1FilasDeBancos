
package proyectoprogra;

/**
 *
 * @author Jefferson
 */
public class Cliente {
    //Atributos de la clase Cliente
    private String nombre;
    private  int consecutivo;
    private char prioridad;
    private int tiempoTramite;
    private int toleranciaCliente;
    private int tiempoEspera;
    //Metodo Constructor de la clase
    public Cliente(String nombre, int consecutivo, char prioridad, int tiempoTramite, int tolerancia) {
        this.nombre = nombre;
        this.consecutivo = consecutivo;
        this.prioridad = prioridad;
        this.tiempoTramite = tiempoTramite;
        this.toleranciaCliente = toleranciaCliente;
        this.tiempoEspera = 0;
    }
    //Getter de la Clase Cliente para obtener el valor de un atributo privado 
    public String getNombre() {
        return nombre;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public char getPrioridad() {
        return prioridad;
    }

    public int getTiempoTramite() {
        return tiempoTramite;
    }

    public int getToleranciaCliente() {
        return toleranciaCliente;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }
    //Metodos de la clase Cliente
    //Este metodo incrementa en 1 valor del atributo tiempoEspera
    public void aumentarEspera(){
        this.tiempoEspera++;
    }
    //Este metodo proporciona el valor de el tiempo de espera del Cliente
    public boolean sinAtencion(){
        return tiempoEspera>= toleranciaCliente; 
    }
    //Metodo toString
    @Override
    public String toString() {
        return nombre + " - " + consecutivo + prioridad + " (Tramite: " + tiempoTramite + " minutos)";
    }
    
    
    
    
}
