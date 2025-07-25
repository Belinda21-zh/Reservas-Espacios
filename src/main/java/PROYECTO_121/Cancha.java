package PROYECTO_121;

import java.util.Scanner;

public class Cancha extends EspacioPublico {
    private String dimension;
    private String materialSuelo;
    private boolean tieneTecho;

    public Cancha() {}

    @Override
    public void leer() {
        super.leer();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.print("Dimensión de la cancha: ");
        dimension = sc.nextLine();
        System.out.print("Material del suelo: ");
        materialSuelo = sc.nextLine();
        System.out.print("¿Tiene techo? (true/false): ");
        tieneTecho = sc.nextBoolean();
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Dimension: " + dimension);
        System.out.println("Material del suelo: " + materialSuelo);
        System.out.println("Tiene techo: " + (tieneTecho ? "Sí" : "No"));
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getMaterialSuelo() {
        return materialSuelo;
    }

    public void setMaterialSuelo(String materialSuelo) {
        this.materialSuelo = materialSuelo;
    }

    public boolean isTieneTecho() {
        return tieneTecho;
    }

    public void setTieneTecho(boolean tieneTecho) {
        this.tieneTecho = tieneTecho;
    }
}
