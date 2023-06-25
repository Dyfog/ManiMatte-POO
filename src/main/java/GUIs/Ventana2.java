package GUIs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana2 extends JFrame implements ActionListener {
    JLabel instrucciones;
    JLabel simplesText;
    JSlider simples;
    JLabel sofisticadosText;
    JSlider sofisticados;
    JButton atras;
    JButton siguiente;

    public Ventana2(){
        initVentana2();
        this.setTitle("Cotizador de Manicura");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initVentana2(){
        JPanel panel = new JPanel();
        JLabel instrucciones = new JLabel("Seleccione la cantidad de diseños que desea, considere que son 10 como máximo");

        JLabel simplesText = new JLabel("Simples: ");
        JSlider simples = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        simples.setMajorTickSpacing(1);
        simples.setPaintTicks(true);
        simples.setPaintLabels(true);

        JLabel sofisticadosText = new JLabel("Sofisticados: ");
        JSlider sofisticados = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        sofisticados.setMajorTickSpacing(1);
        sofisticados.setPaintTicks(true);
        sofisticados.setPaintLabels(true);

        JButton atras = new JButton();
        atras.setText("Atrás");

        JButton siguiente = new JButton();
        siguiente.setText("Siguiente");

        panel.add(instrucciones);
        panel.add(simplesText);
        panel.add(simples);
        panel.add(sofisticadosText);
        panel.add(sofisticados);
        panel.add(atras);
        panel.add(siguiente);

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cerrarVentana2();
                Controlador.abrirVentana1();
            }
        });

        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cerrarVentana2();
                Controlador.abrirVentana3();
            }
        });

        this.add(panel);
    }

    public void generarAlerta(){
        JOptionPane alerta = new JOptionPane("Recuerda! \n" +
                "La cantidad total de diseños no puede ser más de 10");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
