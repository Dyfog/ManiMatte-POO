package org.example.guis;

import org.example.datos.ManejoArchivo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana5 extends JFrame implements ActionListener {

    JLabel texto;
    JButton iniciarOtra;

    public Ventana5() {
        initVentana5();
        setTitle("Cotizador de Manicura");
        setSize(310, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initVentana5() {
        JPanel panel = new JPanel();
        texto = new JLabel("Cotización finalizada! Gracias por su preferencia");

        iniciarOtra = new JButton();
        iniciarOtra.setText("Comenzar una nueva cotización");

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(texto)
                        .addComponent(iniciarOtra)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(texto)
                        .addGap(20) // Espacio vertical entre el texto y el botón
                        .addComponent(iniciarOtra)
        );

        add(panel);
        iniciarOtra.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==iniciarOtra){
            ManejoArchivo.guardarCotizacion(Controlador.cotizacion);
            Controlador.cerrarVentana5();
            Controlador.resetVentanas();
            Controlador.cotizacion = null;
            Controlador.abrirVentana1();

        }
    }
}
