package GUIs;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana1 extends JFrame implements ActionListener {
    JLabel bienvenida;
    JLabel largosText;
    JComboBox largos;
    JLabel materialText;
    JComboBox materiales;
    JLabel cantColoresText;
    JSlider cantColores;
    JButton siguiente;

    public Ventana1(){
        initVentana1();
        this.setTitle("Cotizador de Manicura");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initVentana1(){
        JPanel panel = new JPanel();
        JLabel bienvenida = new JLabel("Bienvenid@, defina sus elecciones: ");

        JLabel largosText = new JLabel("Largo: ");
        String[] opcionesLargos = {"Natural", "S", "M", "L"};
        JComboBox largos = new JComboBox(opcionesLargos);

        JLabel materialText = new JLabel("Material: ");
        String[] opcionesMaterial = {"Acrílico", "PolyGel", "GelX"};
        JComboBox materiales = new JComboBox(opcionesLargos);

        JLabel cantColoresText = new JLabel("Cantidad de colores");
        JSlider cantColores = new JSlider(JSlider.HORIZONTAL, 0, 5, 0);
        cantColores.setMajorTickSpacing(1);
        cantColores.setPaintTicks(true);
        cantColores.setPaintLabels(true);

        JButton siguiente = new JButton();
        siguiente.setText("Siguiente");

        panel.add(bienvenida);
        panel.add(largosText);
        panel.add(largos);
        panel.add(materialText);
        panel.add(materiales);
        panel.add(cantColoresText);
        panel.add(cantColores);
        panel.add(siguiente);

        largos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        materiales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //action del JSlider

        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cerrarVentana1();
                Controlador.abrirVentana2();
            }
        });

        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
