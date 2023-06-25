package GUIs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana4 extends JFrame implements ActionListener {

    JLabel opcionesText;
    JComboBox opciones;
    JLabel tiempoText;
    JLabel tiempo;
    JLabel valorText;
    JLabel valor;
    JLabel guardarText;
    JButton atras;
    JButton guardar;

    public Ventana4(){
        initVentana4();
        this.setTitle("Cotizador de Manicura");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initVentana4(){
        JPanel panel = new JPanel();
        JLabel opcionesText = new JLabel("Sus elecciones son: ");
        //usar getter en los espacios en blanco
        String[] elecciones = {"Largo: "+"", "Material: "+"", "Cantidad de colores: "+"", "Cantidad de diseños: "+"", "Cantidad de decoraciones: "+""};
        JComboBox eleccion = new JComboBox<>(elecciones);

        JLabel valorText = new JLabel("Valor total: ");
        // pa settear
        JLabel valor = new JLabel();

        JLabel tiempoText = new JLabel("Tiempo estimado: ");
        //pa settear
        JLabel tiempo = new JLabel();

        JLabel guardarText = new JLabel("¿Desea guardar su cotización?");

        JButton atras = new JButton();
        atras.setText("Atrás");

        JButton guardar = new JButton();
        guardar.setText("Guardar y finalizar");

        panel.add(opcionesText);
        panel.add(eleccion);
        panel.add(valorText);
        panel.add(valor);
        panel.add(tiempoText);
        panel.add(tiempo);
        panel.add(guardarText);
        panel.add(atras);
        panel.add(guardar);

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cerrarVentana4();
                Controlador.abrirVentana3();
            }
        });

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cerrarVentana4();
                Controlador.abrirVentana5();
            }
        });
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
