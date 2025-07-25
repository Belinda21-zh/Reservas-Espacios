package PROYECTO_121;

import java.io.Serializable;
import java.util.Scanner;

public class Usuario implements Serializable {
    private String nombre;
    private String ci;
    private String telefono;

    public Usuario() {}

    public Usuario(String nombre, String ci, String telefono) {
        this.nombre = nombre;
        this.ci = ci;
        this.telefono = telefono;
    }

    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del usuario: ");
        nombre = sc.nextLine();
        System.out.print("CI: ");
        ci = sc.nextLine();
        System.out.print("Teléfono: ");
        telefono = sc.nextLine();
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("CI: " + ci);
        System.out.println("Teléfono: " + telefono);
    }

    @Override
    public String toString() {
        return nombre + " (CI: " + ci + ", Tel: " + telefono + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public String getCi() {
        return ci;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
