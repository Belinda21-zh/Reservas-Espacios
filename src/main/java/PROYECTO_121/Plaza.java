package PROYECTO_121;

import java.util.Scanner;

public class Plaza extends EspacioPublico {
    private int cantBancas;
    private boolean tieneMonumento;
    private int cantArboles;

    public Plaza() {}

    @Override
    public void leer() {
        super.leer();
        Scanner sc = new Scanner(System.in);
        System.out.print("Cantidad de bancas: ");
        cantBancas = sc.nextInt();
        System.out.print("¿Tiene monumento? (true/false): ");
        tieneMonumento = sc.nextBoolean();
        System.out.print("Cantidad de árboles: ");
        cantArboles = sc.nextInt();
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Cantidad de bancas: " + cantBancas);
        System.out.println("Tiene monumento: " + (tieneMonumento ? "Sí" : "No"));
        System.out.println("Cantidad de árboles: " + cantArboles);
    }

    public int getCantBancas() {
        return cantBancas;
    }

    public void setCantBancas(int cantBancas) {
        this.cantBancas = cantBancas;
    }

    public boolean isTieneMonumento() {
        return tieneMonumento;
    }

    public void setTieneMonumento(boolean tieneMonumento) {
        this.tieneMonumento = tieneMonumento;
    }

    public int getCantArboles() {
        return cantArboles;
    }

    public void setCantArboles(int cantArboles) {
        this.cantArboles = cantArboles;
    }
}