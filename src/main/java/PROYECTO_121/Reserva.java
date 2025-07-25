package PROYECTO_121;

import java.io.Serializable;

public class Reserva implements Serializable {
    private String fecha;
    private String hora;
    private int duracionHoras;
    private Pago pago;
    private Usuario usuario;
    private EspacioPublico espacio;

    public Reserva() {}

    public Reserva(String fecha, String hora, int duracionHoras, Pago pago, Usuario usuario, EspacioPublico espacio) {
        this.fecha = fecha;
        this.hora = hora;
        this.duracionHoras = duracionHoras;
        this.pago = pago;
        this.usuario = usuario;
        this.espacio = espacio;
    }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public int getDuracionHoras() { return duracionHoras; }
    public Pago getPago() { return pago; }
    public Usuario getUsuario() { return usuario; }
    public EspacioPublico getEspacio() { return espacio; }

    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setHora(String hora) { this.hora = hora; }
    public void setDuracionHoras(int duracionHoras) { this.duracionHoras = duracionHoras; }
    public void setPago(Pago pago) { this.pago = pago; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setEspacio(EspacioPublico espacio) { this.espacio = espacio; }

    @Override
    public String toString() {
        return "---------------------------------------\n" +
                "Fecha: " + (fecha != null ? fecha : "No asignada") + "\n" +
                "Hora: " + (hora != null ? hora : "No asignada") + "\n" +
                "Duración: " + duracionHoras + " hora(s)\n" +
                "Usuario: " + (usuario != null ? usuario.getNombre() : "No asignado") + "\n" +
                "Espacio: " + (espacio != null ? espacio.getNomEspacio() : "No asignado") + "\n" +
                "Pago: " + (pago != null ? pago.toString() : "No registrado");
    }
    public void asignarPago(Pago pago){
        this.pago = pago;
    }
    public void asignarUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public void asignarEspacio(EspacioPublico espacio){
        this.espacio = espacio;
    }
}


