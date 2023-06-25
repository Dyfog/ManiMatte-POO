package GUIs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana3 extends JFrame implements ActionListener {
    JLabel instrucciones;
    JLabel acc3DText;
    JSlider acc3D;
    JLabel cristalText;
    JSlider cristales;
    JButton atras;
    JButton siguiente;

    public Ventana3(){
        initVentana3();
        this.setTitle("Cotizador de Manicura");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initVentana3(){
        JPanel panel = new JPanel();
        JLabel instrucciones = new JLabel("Seleccione la cantidad de decoraciones que desea, considere que son 10 como máximo");

        JLabel acc3DText = new JLabel("3D: ");
        JSlider acc3D = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        acc3D.setMajorTickSpacing(1);
        acc3D.setPaintTicks(true);
        acc3D.setPaintLabels(true);

        JLabel cristalesText = new JLabel("Cristales: ");
        JSlider cristales = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        cristales.setMajorTickSpacing(1);
        cristales.setPaintTicks(true);
        cristales.setPaintLabels(true);

        JButton atras = new JButton();
        atras.setText("Atrás");

        JButton siguiente = new JButton();
        siguiente.setText("Siguiente");

        panel.add(instrucciones);
        panel.add(acc3DText);
        panel.add(acc3D);
        panel.add(cristalesText);
        panel.add(cristales);
        panel.add(atras);
        panel.add(siguiente);

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cerrarVentana3();
                Controlador.abrirVentana2();
            }
        });

        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cerrarVentana3();
                Controlador.abrirVentana4();
            }
        });

        this.add(panel);
    }

    public void generarAlerta(){
        JOptionPane alerta = new JOptionPane("Recuerda! \n" +
                "La cantidad total de accesorios no puede ser más de 10");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
