package PROYECTO_121;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListarReservasPanel extends JPanel {
    private GestorReservasGUI gestor;
    private JTextArea textArea;
    private MainFrame frame;

    public ListarReservasPanel(GestorReservasGUI gestor, MainFrame frame) {
        this.gestor = gestor;
        this.frame = frame;
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolver.addActionListener(e -> frame.volverAlMenu());
        JPanel panelBoton = new JPanel();
        panelBoton.add(btnVolver);
        add(panelBoton, BorderLayout.SOUTH);

        actualizarLista();


        JButton btnCancelar = new JButton("Cancelar Reserva");
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCancelar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Ingrese el número de la reserva a cancelar:");
            if (input != null) {
                try {
                    int num = Integer.parseInt(input) - 1;
                    boolean ok = gestor.cancelarReserva(num);
                    if (ok) {
                        JOptionPane.showMessageDialog(this, "Reserva cancelada correctamente.");
                        actualizarLista();
                    } else {
                        JOptionPane.showMessageDialog(this, "Número inválido.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar un número válido.");
                }
            }
        });
        panelBoton.add(btnCancelar);

    }

    public void actualizarLista() {
        ArrayList<Reserva> reservas = gestor.obtenerReservas();
        if (reservas == null || reservas.isEmpty()) {
            textArea.setText("No hay reservas registradas.");
        } else {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (Reserva r : reservas) {
                sb.append("RESERVA #").append(count++).append("\n").append(r.toString()).append("\n\n");
            }
            textArea.setText(sb.toString());
        }
    }


}

