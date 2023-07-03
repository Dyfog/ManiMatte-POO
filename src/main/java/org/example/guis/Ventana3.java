package org.example.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana3 extends JFrame implements ActionListener {

    protected JPanel panelInstrucciones = new JPanel();
    protected JPanel panelCristales = new JPanel();
    protected JPanel panelAccesorios = new JPanel();
    protected JPanel panelBotones = new JPanel();
    protected JLabel instrucciones;
    protected JLabel cristalesText;
    protected JSlider cristales;
    protected JLabel accesorios3dText;
    protected JSlider accesorios3d;
    protected JButton atras;
    protected JButton siguiente;

    protected Ventana3() {
        initVentana3();
        this.setTitle("Cotizador de Manicura");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initVentana3() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(4, 1));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        instrucciones = new JLabel("Seleccione la cantidad de decoraciones que desea, considere que son 10 como máximo");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panelInstrucciones.add(instrucciones, constraints);

        cristalesText = new JLabel("Cristales:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        panelCristales.add(cristalesText, constraints);

        cristales = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        cristales.setMajorTickSpacing(1);
        cristales.setPaintTicks(true);
        cristales.setPaintLabels(true);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        panelCristales.add(cristales, constraints);

        accesorios3dText = new JLabel("Accesorios 3D:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        panelAccesorios.add(accesorios3dText, constraints);

        accesorios3d = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        accesorios3d.setMajorTickSpacing(1);
        accesorios3d.setPaintTicks(true);
        accesorios3d.setPaintLabels(true);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        panelAccesorios.add(accesorios3d, constraints);

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
        contentPane.add(panelCristales);
        contentPane.add(panelAccesorios);
        contentPane.add(panelBotones);

        this.setContentPane(contentPane);

        // Ajustar el tamaño de los componentes
        cristales.setPreferredSize(new Dimension(300, cristales.getPreferredSize().height));
        accesorios3d.setPreferredSize(new Dimension(300, accesorios3d.getPreferredSize().height));
        atras.setPreferredSize(new Dimension(100, atras.getPreferredSize().height));
        siguiente.setPreferredSize(new Dimension(100, siguiente.getPreferredSize().height));

        atras.addActionListener(this);
        siguiente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==atras){
            Controlador.cerrarVentana3();
            Controlador.abrirVentana2();
        }
        if (e.getSource()==siguiente){
            int totalDiseños = cristales.getValue() + accesorios3d.getValue();
            if (totalDiseños > 10) {
                JOptionPane.showMessageDialog(this, "La suma de los diseños no puede ser superior a 10");
                if (cristales.getValue() > 10 - accesorios3d.getValue()) {
                    cristales.setValue(10 - accesorios3d.getValue());
                } else {
                    accesorios3d.setValue(10 - cristales.getValue());
                }
            } else {
                Controlador.cerrarVentana3();
                Controlador.abrirVentana4();
                Controlador.actualizarVentanaResumen();
            }
        }
    }
}
