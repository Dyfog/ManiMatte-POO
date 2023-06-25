package GUIs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana5 extends JFrame implements ActionListener {

    JLabel texto;
    JButton guardar;

    public Ventana5(){
        initVentana5();
        this.setTitle("Cotizador de Manicura");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initVentana5(){
        JPanel panel = new JPanel();
        JLabel texto = new JLabel("Cotización finalizada! Gracias por su preferencia");

        JButton iniciarOtra = new JButton();
        iniciarOtra.setText("Comenzar una nueva cotización");

        panel.add(texto);
        panel.add(iniciarOtra);

        iniciarOtra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cerrarVentana5();
                Controlador.abrirVentana1();
            }
        });
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
