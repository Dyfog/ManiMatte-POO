package org.example.guis;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase (ventana) es simplemente una ventana que da aviso que todo el proceso termino correctamente
 */
public class Ventana5 extends JFrame implements ActionListener {

    protected JLabel texto;
    protected JButton iniciarOtra;

    /**
     * Este constructor crea la ventana5, dandole su tamaño y todos los valores necesarios.
     */
    protected Ventana5() {
        initVentana5();
        setTitle("Cotizador de Manicura");
        setSize(310, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Este metodo es el encargado de darle a la ventana sus botones, campos de texto y todo lo necesario para su correcto funcionamiento.
     */
    private void initVentana5() {
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
            Controlador.cerrarVentana5();
            Controlador.resetVentanas();
            Controlador.cotizacion = null;
            Controlador.abrirVentana1();

        }
    }
}
