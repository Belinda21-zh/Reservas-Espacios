package PROYECTO_121;

import java.io.Serializable;
import java.util.Scanner;

public class Pago implements Serializable {
    private double monto;
    private String metodoPago;
    private String fechaPago;

    public Pago() {}

    public Pago(double monto, String metodoPago, String fechaPago) {
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = fechaPago;
    }

    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Monto: ");
        monto = sc.nextDouble();
        sc.nextLine();
        System.out.print("Método de pago: ");
        metodoPago = sc.nextLine();
        System.out.print("Fecha de pago: ");
        fechaPago = sc.nextLine();
    }

    public void mostrar() {
        System.out.println("Monto: " + monto);
        System.out.println("Método de pago: " + metodoPago);
        System.out.println("Fecha: " + fechaPago);
    }

    public boolean esPagado() {
        return monto > 0;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public String toString() {
        return "Monto: Bs. " + monto + " | Método: " + metodoPago + " | Fecha: " + fechaPago;
    }
}
