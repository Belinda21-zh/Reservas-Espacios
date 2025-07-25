package PROYECTO_121;

import java.util.Scanner;

public class Biblioteca extends EspacioPublico {
    private int cantLibros;
    private int cantSalas;
    private boolean tieneInternet;
    private int niveles;

    public Biblioteca() {}

    @Override
    public void leer() {
        super.leer();
        Scanner sc = new Scanner(System.in);
        System.out.print("Cantidad de libros: ");
        cantLibros = sc.nextInt();
        System.out.print("Cantidad de salas: ");
        cantSalas = sc.nextInt();
        System.out.print("¿Tiene Internet? (true/false): ");
        tieneInternet = sc.nextBoolean();
        System.out.print("Cantidad de niveles: ");
        niveles = sc.nextInt();
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Cantidad de libros: " + cantLibros);
        System.out.println("Cantidad de salas: " + cantSalas);
        System.out.println("Tiene internet: " + (tieneInternet ? "Sí" : "No"));
        System.out.println("Niveles: " + niveles);
    }

    public int getCantLibros() {
        return cantLibros;
    }

    public void setCantLibros(int cantLibros) {
        this.cantLibros = cantLibros;
    }

    public int getCantSalas() {
        return cantSalas;
    }

    public void setCantSalas(int cantSalas) {
        this.cantSalas = cantSalas;
    }

    public boolean isTieneInternet() {
        return tieneInternet;
    }

    public void setTieneInternet(boolean tieneInternet) {
        this.tieneInternet = tieneInternet;
    }

    public int getNiveles() {
        return niveles;
    }

    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }
}
