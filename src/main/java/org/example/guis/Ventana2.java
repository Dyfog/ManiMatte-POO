package org.example.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana2 extends JFrame implements ActionListener {

    JPanel panelInstrucciones = new JPanel();
    JPanel panelSimples = new JPanel();
    JPanel panelSofisticados = new JPanel();
    JPanel panelBotones = new JPanel();
    JLabel instrucciones;
    JLabel simplesText;
    JSlider simples;
    JLabel sofisticadosText;
    JSlider sofisticados;
    JButton atras;
    JButton siguiente;

    public Ventana2() {
        initVentana2();
        this.setTitle("Cotizador de Manicura");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initVentana2() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(4, 1));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        instrucciones = new JLabel("Seleccione la cantidad de diseños que desea, considere que son 10 como máximo");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panelInstrucciones.add(instrucciones, constraints);

        simplesText = new JLabel("Diseños simples:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        panelSimples.add(simplesText, constraints);

        simples = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        simples.setMajorTickSpacing(1);
        simples.setPaintTicks(true);
        simples.setPaintLabels(true);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        panelSimples.add(simples, constraints);

        sofisticadosText = new JLabel("Diseños sofisticados:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        panelSofisticados.add(sofisticadosText, constraints);

        sofisticados = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        sofisticados.setMajorTickSpacing(1);
        sofisticados.setPaintTicks(true);
        sofisticados.setPaintLabels(true);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        panelSofisticados.add(sofisticados, constraints);

        atras = new JButton("Atrás");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        panelBotones.add(atras, constraints);

        siguiente = new JButton("Siguiente");
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        panelBotones.add(siguiente, constraints);

        contentPane.add(panelInstrucciones);
        contentPane.add(panelSimples);
        contentPane.add(panelSofisticados);
        contentPane.add(panelBotones);

        this.setContentPane(contentPane);

        // Ajustar el tamaño de los componentes
        simples.setPreferredSize(new Dimension(300, simples.getPreferredSize().height));
        sofisticados.setPreferredSize(new Dimension(300, sofisticados.getPreferredSize().height));
        atras.setPreferredSize(new Dimension(100, atras.getPreferredSize().height));
        siguiente.setPreferredSize(new Dimension(100, siguiente.getPreferredSize().height));

        atras.addActionListener(this);
        siguiente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==atras){
            Controlador.cerrarVentana2();
            Controlador.abrirVentana1();
        }
        if (e.getSource()==siguiente){
            int totalDiseños = simples.getValue() + sofisticados.getValue();
            if (totalDiseños > 10) {
                JOptionPane.showMessageDialog(this, "La suma de los diseños no puede ser superior a 10");
                if (simples.getValue() > 10 - sofisticados.getValue()) {
                    simples.setValue(10 - sofisticados.getValue());
                } else {
                    sofisticados.setValue(10 - simples.getValue());
                }
            } else {
                Controlador.cerrarVentana2();
                Controlador.abrirVentana3();
            }
        }
    }
}
