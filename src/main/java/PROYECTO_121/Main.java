package PROYECTO_121;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean sw = true;
        Scanner sc = new Scanner(System.in);
        GestorReservas gestor = new GestorReservas(sc);

        while (sw) {
            System.out.println("\n=== MENU DE RESERVAS ===");
            System.out.println("1. Registrar reserva");
            System.out.println("2. Mostrar reservas");
            System.out.println("3. Mostrar usuarios");
            System.out.println("4. Mostrar espacios publicos");
            System.out.println("5. Cancelar reserva");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            String resp = sc.nextLine();
            switch (resp){
                    case "1":
                        gestor.registrarReserva();
                        break;
                    case "2":
                        gestor.mostrarReservas();
                        break;
                    case "3":
                        gestor.mostrarUsuarios();
                        break;
                    case "4":
                        gestor.mostrarEspacios();
                        break;
                    case "5":
                        gestor.cancelarReserva();
                        break;
                    case "0":
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        sw = false;
            }
        }
    }
}
