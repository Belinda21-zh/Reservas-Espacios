package PROYECTO_121;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListarEspaciosPanel extends JPanel {
    private GestorReservasGUI gestor;
    private JTextArea textArea;
    private MainFrame frame;

    public ListarEspaciosPanel(GestorReservasGUI gestor, MainFrame frame) {
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
    }

    public void actualizarLista() {
        ArrayList<EspacioPublico> espacios = gestor.obtenerEspacios();
        if (espacios == null || espacios.isEmpty()) {
            textArea.setText("No hay espacios registrados.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (EspacioPublico e : espacios) {
                sb.append(e.toString()).append("\n");
            }
            textArea.setText(sb.toString());
        }
    }
}

