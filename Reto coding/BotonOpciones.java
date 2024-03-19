import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotonOpciones extends JFrame {
    private JButton botonSi;
    private JButton botonNo;

    public BotonOpciones() {
        setTitle("Opciones");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los botones
        botonSi = new JButton("Sí");
        botonNo = new JButton("No");

        // Agregar acción al botón "No"
        botonNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener la posición actual del botón
                Point posicionActual = botonNo.getLocation();
                // Cambiar la posición del botón a una nueva ubicación
                int newX = (int) (Math.random() * (getWidth() - botonNo.getWidth()));
                int newY = (int) (Math.random() * (getHeight() - botonNo.getHeight()));
                botonNo.setLocation(newX, newY);
            }
        });

        // Agregar acción al botón "Sí"
        botonSi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana
                dispose();
            }
        });

        // Crear panel y agregar botones
        JPanel panel = new JPanel();
        panel.add(botonSi);
        panel.add(botonNo);
        add(panel);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BotonOpciones ventana = new BotonOpciones();
                ventana.setVisible(true);
            }
        });
    }
}
