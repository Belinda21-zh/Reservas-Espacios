package PROYECTO_121;

import java.io.Serializable;
import java.util.Scanner;

public class EspacioPublico implements Serializable {
    protected String nomEspacio;
    protected String ubicacion;
    protected int capacidad;
    protected boolean estado;
    protected Reserva reserva;
    public EspacioPublico() {}

    public EspacioPublico(String nomEspacio, String ubicacion, int capacidad, boolean estado) {
        this.nomEspacio = nomEspacio;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del espacio: ");
        nomEspacio = sc.nextLine();
        System.out.print("Ubicacion: ");
        ubicacion = sc.nextLine();
        System.out.print("Capacidad: ");
        capacidad = sc.nextInt();
        System.out.print("¿Esta disponible? (true/false): ");
        estado = sc.nextBoolean();
    }

    public void mostrar() {
        System.out.println("Nombre: " + nomEspacio);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Estado: " + (estado ? "Disponible" : "No disponible"));
    }

    @Override
    public String toString() {
        return nomEspacio + " | Ubicacion: " + ubicacion + " | Capacidad: " + capacidad + " | Estado: " + (estado ? "Disponible" : "No disponible");
    }
    public String getNomEspacio() {
        return nomEspacio;
    }

    public void setNomEspacio(String nomEspacio) {
        this.nomEspacio = nomEspacio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public void asignarReserva() {
        this.estado = false;
    }

    public void liberarReserva() {
        this.estado = true;
    }

    public boolean isDisponible() {
        return this.estado;
    }

}
