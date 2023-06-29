package org.example.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana1 extends JFrame implements ActionListener {
    JLabel bienvenida;
    JLabel largosText;
    JComboBox<String> largos;
    JLabel materialText;
    JComboBox<String> materiales;
    JLabel cantColoresText;
    JSlider cantColores;
    JButton siguiente;

    public Ventana1() {
        initVentana1();
        this.setTitle("Cotizador de Manicura");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initVentana1() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel superior con el texto de bienvenida
        JPanel bienvenidaPanel = new JPanel();
        bienvenida = new JLabel("Bienvenid@, defina sus elecciones: ");
        bienvenidaPanel.add(bienvenida);
        panel.add(bienvenidaPanel, BorderLayout.NORTH);

        // Panel central con los largos y materiales
        JPanel centroPanel = new JPanel(new GridLayout(2, 2));
        largosText = new JLabel("Largo: ");
        String[] opcionesLargos = {"Natural", "S", "M", "L"};
        largos = new JComboBox<>(opcionesLargos);
        materialText = new JLabel("Material: ");
        String[] opcionesMaterial = {"Acrílico", "PolyGel", "GelX"};
        materiales = new JComboBox<>(opcionesMaterial);

        // Alineación del texto al centro
        largosText.setHorizontalAlignment(SwingConstants.CENTER);
        materialText.setHorizontalAlignment(SwingConstants.CENTER);



        centroPanel.add(largosText);
        centroPanel.add(largos);
        centroPanel.add(materialText);
        centroPanel.add(materiales);
        panel.add(centroPanel, BorderLayout.CENTER);

        // Panel inferior con el slider y el botón
        JPanel inferiorPanel = new JPanel(new BorderLayout());
        JPanel cantColoresPanel = new JPanel();
        cantColoresText = new JLabel("Cantidad de colores");
        cantColores = new JSlider(JSlider.HORIZONTAL, 0, 5, 0);
        cantColores.setMajorTickSpacing(1);
        cantColores.setPaintTicks(true);
        cantColores.setPaintLabels(true);
        cantColoresPanel.add(cantColoresText);
        cantColoresPanel.add(cantColores);
        inferiorPanel.add(cantColoresPanel, BorderLayout.CENTER);

        siguiente = new JButton("Siguiente");
        inferiorPanel.add(siguiente, BorderLayout.SOUTH);
        panel.add(inferiorPanel, BorderLayout.SOUTH);

        // Acción del botón siguiente
        siguiente.addActionListener(this);

        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==siguiente){
            Controlador.cerrarVentana1();
            Controlador.abrirVentana2();
        }

    }
}
