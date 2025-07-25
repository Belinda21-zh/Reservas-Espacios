package PROYECTO_121;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    private GestorReservasGUI gestor;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private JPanel menuPanel;
    private RegistrarReservaPanel registrarPanel;
    private ListarReservasPanel listarReservasPanel;
    private ListarUsuariosPanel listarUsuariosPanel;
    private ListarEspaciosPanel listarEspaciosPanel;

    public MainFrame() {
        gestor = new GestorReservasGUI();
        initComponents();
        setupFrame();
    }

    private void initComponents() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        createMenuPanel();
        registrarPanel = new RegistrarReservaPanel(this, gestor);
        listarReservasPanel = new ListarReservasPanel(gestor, this);
        listarUsuariosPanel = new ListarUsuariosPanel(gestor, this);
        listarEspaciosPanel = new ListarEspaciosPanel(gestor, this);

        mainPanel.add(menuPanel, "MENU");
        mainPanel.add(registrarPanel, "REGISTRAR");
        mainPanel.add(listarReservasPanel, "LISTAR_RESERVAS");
        mainPanel.add(listarUsuariosPanel, "LISTAR_USUARIOS");
        mainPanel.add(listarEspaciosPanel, "LISTAR_ESPACIOS");

        add(mainPanel);
    }

    private void createMenuPanel() {
        menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        menuPanel.setBackground(new Color(245, 245, 245));

        JLabel titleLabel = new JLabel("Sistema de Reservas de Espacios Públicos", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 51, 51));
        titleLabel.setBorder(new EmptyBorder(20, 0, 30, 0));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setOpaque(false);

        JButton btnRegistrar = createStyledButton(" Registrar Nueva Reserva", new Color(173, 217, 207));
        JButton btnReservas = createStyledButton(" Ver Todas las Reservas", new Color(186, 204, 218));
        JButton btnUsuarios = createStyledButton(" Ver Usuarios", new Color(237, 211, 241));
        JButton btnEspacios = createStyledButton("️ Ver Espacios Públicos", new Color(229, 205, 171));

        btnRegistrar.addActionListener(e -> showPanel("REGISTRAR"));
        btnReservas.addActionListener(e -> {
            listarReservasPanel.actualizarLista();
            showPanel("LISTAR_RESERVAS");
        });
        btnUsuarios.addActionListener(e -> {
            listarUsuariosPanel.actualizarLista();
            showPanel("LISTAR_USUARIOS");
        });
        btnEspacios.addActionListener(e -> {
            listarEspaciosPanel.actualizarLista();
            showPanel("LISTAR_ESPACIOS");
        });

        buttonPanel.add(btnRegistrar);
        buttonPanel.add(btnReservas);
        buttonPanel.add(btnUsuarios);
        buttonPanel.add(btnEspacios);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(buttonPanel);

        menuPanel.add(titleLabel, BorderLayout.NORTH);
        menuPanel.add(centerPanel, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(color);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(300, 50));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });

        return button;
    }

    private void setupFrame() {
        setTitle("Sistema de Reservas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(700, 500));
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public void volverAlMenu() {
        showPanel("MENU");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
