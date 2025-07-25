package PROYECTO_121;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegistrarReservaPanel extends JPanel {
    private MainFrame frame;
    private GestorReservasGUI gestor;

    private JTextField txtNombreUsuario, txtCI, txtTelefono;
    private JTextField txtNombreEspacio, txtUbicacion, txtCapacidad;
    private JTextField txtFecha, txtHora, txtDuracion;
    private JTextField txtMonto, txtMetodoPago, txtFechaPago;

    public RegistrarReservaPanel(MainFrame frame, GestorReservasGUI gestor) {
        this.frame = frame;
        this.gestor = gestor;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        panel.add(new JLabel("Nombre del Usuario:"));
        txtNombreUsuario = new JTextField();
        panel.add(txtNombreUsuario);

        panel.add(new JLabel("CI del Usuario:"));
        txtCI = new JTextField();
        panel.add(txtCI);

        panel.add(new JLabel("Teléfono del Usuario:"));
        txtTelefono = new JTextField();
        panel.add(txtTelefono);

        panel.add(new JLabel("Nombre del Espacio:"));
        txtNombreEspacio = new JTextField();
        panel.add(txtNombreEspacio);

        panel.add(new JLabel("Ubicación del Espacio:"));
        txtUbicacion = new JTextField();
        panel.add(txtUbicacion);

        panel.add(new JLabel("Capacidad del Espacio:"));
        txtCapacidad = new JTextField();
        panel.add(txtCapacidad);

        panel.add(new JLabel("Fecha de la Reserva (dd/mm/aaaa):"));
        txtFecha = new JTextField();
        panel.add(txtFecha);

        panel.add(new JLabel("Hora de la Reserva (hh:mm):"));
        txtHora = new JTextField();
        panel.add(txtHora);

        panel.add(new JLabel("Duración (horas):"));
        txtDuracion = new JTextField();
        panel.add(txtDuracion);

        panel.add(new JLabel("Monto (Bs):"));
        txtMonto = new JTextField();
        panel.add(txtMonto);

        panel.add(new JLabel("Método de Pago:"));
        txtMetodoPago = new JTextField();
        panel.add(txtMetodoPago);

        panel.add(new JLabel("Fecha de Pago (dd/mm/aaaa):"));
        txtFechaPago = new JTextField();
        panel.add(txtFechaPago);

        JButton btnGuardar = new JButton("Registrar Reserva");
        btnGuardar.addActionListener(this::guardarReserva);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> frame.volverAlMenu());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);

        add(new JScrollPane(panel), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void guardarReserva(ActionEvent e) {
        try {
            String nombre = txtNombreUsuario.getText();
            String ci = txtCI.getText();
            String telefono = txtTelefono.getText();

            String nombreEspacio = txtNombreEspacio.getText();
            String ubicacion = txtUbicacion.getText();
            int capacidad = Integer.parseInt(txtCapacidad.getText());

            String fecha = txtFecha.getText();
            String hora = txtHora.getText();
            int duracionHoras = Integer.parseInt(txtDuracion.getText());

            double monto = Double.parseDouble(txtMonto.getText());
            String metodoPago = txtMetodoPago.getText();
            String fechaPago = txtFechaPago.getText();

            Pago pago = new Pago(monto, metodoPago, fechaPago);

            Usuario usuario = new Usuario(nombre, ci, telefono);
            EspacioPublico espacio = new EspacioPublico(nombreEspacio, ubicacion, capacidad, true);

            boolean exito = gestor.registrarReserva(usuario, espacio, fecha, hora, duracionHoras, pago);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Reserva registrada correctamente.");
                frame.volverAlMenu();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la reserva.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Revise los campos numéricos (Capacidad, Duración, Monto).");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
