package PROYECTO_121;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class GestorReservasGUI {
    private ArchUsuario archUsuarios = new ArchUsuario();
    private ArchReservas archReservas = new ArchReservas();
    private ArchEspacioPublico archEspacios = new ArchEspacioPublico();

    public boolean registrarReserva(Usuario usuario, EspacioPublico espacio, String fecha, String hora, int duracionHoras, Pago pago) {
        try {
            if (!espacio.isDisponible()) {
                JOptionPane.showMessageDialog(null, "El espacio seleccionado ya está ocupado.", "No disponible", JOptionPane.WARNING_MESSAGE);
                return false;
            }

            Reserva reserva = new Reserva(fecha, hora, duracionHoras, pago, usuario, espacio);
            reserva.asignarPago(pago);
            reserva.asignarUsuario(usuario);
            reserva.asignarEspacio(espacio);

            espacio.asignarReserva();

            archUsuarios.adicionar(usuario);
            archEspacios.adicionar(espacio);
            archReservas.adicionar(reserva);

            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar la reserva: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public ArrayList<Reserva> obtenerReservas() {
        return archReservas.listar();
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        return archUsuarios.listar();
    }

    public ArrayList<EspacioPublico> obtenerEspacios() {
        return archEspacios.listar();
    }
    public boolean cancelarReserva(int indice) {
        try {
            ArrayList<Reserva> reservas = archReservas.listar();
            if (indice < 0 || indice >= reservas.size()) {
                return false;
            }
            reservas.remove(indice);
            archReservas.crear();
            for (Reserva r : reservas) {
                archReservas.adicionar(r);
            }
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cancelar la reserva: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


}
