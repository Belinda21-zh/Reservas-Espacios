package PROYECTO_121;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class GestorReservas {
    private ArchUsuario archUsuarios = new ArchUsuario();
    private ArchReservas archReservas = new ArchReservas();
    private ArchEspacioPublico archEspacios = new ArchEspacioPublico();
    private Scanner sc;

    public GestorReservas(Scanner sc) {
        this.sc = sc;
    }

    public void registrarReserva() {
        try {
            System.out.println("=== REGISTRAR RESERVA ===");
            System.out.print("Nombre del usuario: ");
            String nombre = sc.nextLine();
            System.out.print("CI del usuario: ");
            String ci = sc.nextLine();
            System.out.print("Teléfono del usuario: ");
            String telefono = sc.nextLine();
            Usuario usuario = new Usuario(nombre, ci, telefono);

            System.out.print("Nombre del espacio: ");
            String nombreEspacio = sc.nextLine();
            System.out.print("Ubicación del espacio: ");
            String ubicacion = sc.nextLine();
            System.out.print("Capacidad del espacio: ");
            int capacidad = sc.nextInt();
            sc.nextLine();
            EspacioPublico espacio = new EspacioPublico(nombreEspacio, ubicacion, capacidad, true);

            if (!espacio.isDisponible()) {
                System.out.println("El espacio seleccionado ya está ocupado. No se puede reservar.");
                return;
            }

            System.out.print("Fecha de la reserva (dd/mm/aaaa): ");
            String fecha = sc.nextLine();
            System.out.print("Hora de la reserva (hh:mm): ");
            String hora = sc.nextLine();
            System.out.print("Duración en horas: ");
            int duracionHoras = sc.nextInt();
            sc.nextLine();

            System.out.println("--- Datos del pago ---");
            System.out.print("Monto (Bs.): ");
            double monto = sc.nextDouble();
            sc.nextLine();
            System.out.print("Método de pago: ");
            String metodoPago = sc.nextLine();
            System.out.print("Fecha de pago (dd/mm/aaaa): ");
            String fechaPago = sc.nextLine();
            Pago pago = new Pago(monto, metodoPago, fechaPago);

            Reserva reserva = new Reserva(fecha, hora, duracionHoras, pago, usuario, espacio);

            archUsuarios.adicionar(usuario);
            archEspacios.adicionar(espacio);
            archReservas.adicionar(reserva);

            System.out.println("Reserva registrada correctamente.\n");

        } catch (IOException e) {
            System.out.println("Error al guardar la reserva: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }

    }

    public void mostrarReservas() {
        System.out.println("=== LISTA DE RESERVAS ===");
        ArrayList<Reserva> reservas = archReservas.listar();
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            for (Reserva r : reservas) {
                System.out.println(r.toString());
                System.out.println("-----------");
            }
        }
    }

    public void mostrarUsuarios() {
        System.out.println("=== LISTA DE USUARIOS ===");
        ArrayList<Usuario> usuarios = archUsuarios.listar();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario u : usuarios) {
                System.out.println(u.toString());
                System.out.println("-----------");
            }
        }
    }

    public void mostrarEspacios() {
        System.out.println("=== LISTA DE ESPACIOS PÚBLICOS ===");
        ArrayList<EspacioPublico> espacios = archEspacios.listar();
        if (espacios.isEmpty()) {
            System.out.println("No hay espacios registrados.");
        } else {
            for (EspacioPublico e : espacios) {
                System.out.println(e.toString());
                System.out.println("-----------");
            }
        }
    }
    public void cancelarReserva() {
        ArrayList<Reserva> reservas = archReservas.listar();
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }

        System.out.println("=== CANCELAR RESERVA ===");
        for (int i = 0; i < reservas.size(); i++) {
            System.out.println((i + 1) + ". " + reservas.get(i).toString());
        }

        System.out.print("Ingrese el número de la reserva a cancelar: ");
        int num = sc.nextInt();
        sc.nextLine();

        if (num < 1 || num > reservas.size()) {
            System.out.println("Número inválido.");
            return;
        }

        reservas.remove(num - 1);

        try {
            archReservas.crear();
            for (Reserva r : reservas) {
                archReservas.adicionar(r);
            }
            System.out.println("Reserva cancelada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cancelar la reserva: " + e.getMessage());
        }
    }

}
