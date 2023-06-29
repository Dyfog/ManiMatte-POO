package org.example.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana4 extends JFrame implements ActionListener {

    JPanel panelTextoGuia = new JPanel();
    JPanel panelResumen = new JPanel();
    JPanel panelTiempo = new JPanel();
    JPanel panelValor = new JPanel();
    JPanel panelBotonesTexto = new JPanel();
    JPanel panelBotones = new JPanel();

    JLabel textoGuia;
    JLabel opcionesText;
    JScrollPane eleccionScrollPane;
    JLabel tiempoText;
    JLabel tiempo;
    JLabel valorText;
    JLabel valor;
    JLabel guardarText;
    JButton atras;
    JButton guardar;

    public Ventana4() {
        initVentana4();
        this.setTitle("Cotizador de Manicura");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initVentana4() {
        textoGuia = new JLabel("Resumen de Cotizacion");
        panelTextoGuia.add(textoGuia);

        opcionesText = new JLabel("Sus elecciones son: ");

        eleccionScrollPane = new JScrollPane();
        eleccionScrollPane.setPreferredSize(new Dimension(280, 100));

        valorText = new JLabel("Valor total: ");
        valor = new JLabel();

        tiempoText = new JLabel("Tiempo estimado: ");
        tiempo = new JLabel();

        guardarText = new JLabel("¿Desea guardar su cotización?");

        atras = new JButton("Atras");

        guardar = new JButton("Guardar y finalizar");

        panelResumen.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panelResumen.add(opcionesText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panelResumen.add(eleccionScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelResumen.add(valorText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelResumen.add(valor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panelResumen.add(tiempoText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panelResumen.add(tiempo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelResumen.add(guardarText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panelBotonesTexto.add(atras, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panelBotonesTexto.add(guardar, gbc);

        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.add(panelBotonesTexto);

        this.setLayout(new BorderLayout());
        this.add(panelTextoGuia, BorderLayout.NORTH);
        this.add(panelResumen, BorderLayout.CENTER);
        this.add(panelBotones, BorderLayout.SOUTH);

        atras.addActionListener(this);
        guardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==atras){
            Controlador.cerrarVentana4();
            Controlador.abrirVentana3();
            Controlador.cotizacion = null;
        }
        if (e.getSource()==guardar){
            Controlador.cerrarVentana4();
            Controlador.abrirVentana5();
        }
    }
}
