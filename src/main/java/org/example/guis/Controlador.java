package org.example.guis;

import org.example.modelo.CotizacionManicura;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase hace el cambio entre ventanas, es el medio por el cual se hacen las entradas y salidas.
 */
public enum Controlador {
    INSTANCE;

    protected static Ventana1 ventana1 = new Ventana1();
    protected static Ventana2 ventana2 = new Ventana2();
    protected static Ventana3 ventana3 = new Ventana3();
    protected static Ventana4 ventana4 = new Ventana4();
    protected static Ventana5 ventana5 = new Ventana5();
    protected static CotizacionManicura cotizacion;

    /**
     * Este metodo es el usado por el main para iniciar la secuencia de ventanas, y por tanto el programa.
     */
    public static void iniciarVentanas(){
        abrirVentana1();
    }

    /**
     * metodo que pone la ventana 1 visible
     */
    protected static void abrirVentana1(){
        ventana1.setVisible(true);
    }

    /**
     * metodo que pone la ventana 2 visible
     */
    protected static void abrirVentana2(){
        ventana2.setVisible(true);
    }

    /**
     * metodo que pone la ventana 3 visible
     */
    protected static void abrirVentana3(){
        ventana3.setVisible(true);
    }

    /**
     * metodo que pone la ventana 4 visible
     */
    protected static void abrirVentana4(){
        ventana4.setVisible(true);
    }

    /**
     * metodo que pone la ventana 5 visible
     */
    protected static void abrirVentana5(){
        ventana5.setVisible(true);
    }

    /**
     * metodo que pone la ventana 1 no visible
     */
    protected static void cerrarVentana1(){
        ventana1.setVisible(false);
    }

    /**
     * metodo que pone la ventana 2 no visible
     */
    protected static void cerrarVentana2(){
        ventana2.setVisible(false);
    }

    /**
     * metodo que pone la ventana 3 no visible
     */
    protected static void cerrarVentana3(){
        ventana3.setVisible(false);
    }

    /**
     * metodo que pone la ventana 4 no visible
     */
    protected static void cerrarVentana4(){
        ventana4.setVisible(false);
    }

    /**
     * metodo que pone la ventana 5 no visible
     */
    protected static void cerrarVentana5(){
        ventana5.setVisible(false);
    }

    /**
     * Este metodo ocurre cuando se quiere pasar a la ventana 4, y actualiza los datos del resumen para que siempre esten correctos
     */
    protected static void actualizarVentanaResumen(){
        String largo = mapLargos.get(ventana1.largos.getSelectedIndex());
        String material = mapMateriales.get(ventana1.materiales.getSelectedIndex());
        int cantColores = ventana1.cantColores.getValue();
        int cantDiseñosSimples = ventana2.simples.getValue();
        int cantDiseñosSofisticados = ventana2.sofisticados.getValue();
        int cantCristales = ventana3.cristales.getValue();
        int cantAccesorios3d = ventana3.accesorios3d.getValue();

        cotizacion  = new CotizacionManicura(cantColores,ventana1.largos.getSelectedIndex(),ventana1.materiales.getSelectedIndex(), new int[]{cantDiseñosSimples, cantDiseñosSofisticados}, new int[]{cantCristales, cantAccesorios3d});


        String[] elecciones = {"Largo: "+largo, "Material: "+material, "Cantidad de colores: "+cantColores,
                "Diseños simples: "+cantDiseñosSimples,"Diseños sofisticados: "+cantDiseñosSofisticados,
                "Cristales: "+cantCristales,"Accesorios 3D: "+cantAccesorios3d};
        JList<String> eleccionList = new JList<>(elecciones);
        ventana4.eleccionScrollPane.setViewportView(eleccionList);
        ventana4.tiempo.setText(String.valueOf(cotizacion.getTiempoEstimado())+" mins");
        ventana4.valor.setText(String.valueOf(cotizacion.getValorEstimado())+" pesos (IVA incluido)");


    }

    /**
     * Este metodo se usa al terminar la cotizacion y le da los valores por defecto a todas las entradas.
     */
    protected static void resetVentanas(){
        ventana1.materiales.setSelectedIndex(0);
        ventana1.largos.setSelectedIndex(0);
        ventana1.cantColores.setValue(0);

        ventana2.simples.setValue(0);
        ventana2.sofisticados.setValue(0);

        ventana3.cristales.setValue(0);
        ventana3.accesorios3d.setValue(0);
    }

    private static Map<Integer,String> mapLargos = new HashMap<Integer,String>();
    static {
        mapLargos.put(0,"Natural");
        mapLargos.put(1,"S");
        mapLargos.put(2,"M");
        mapLargos.put(3,"L");
    }

    private static Map<Integer,String> mapMateriales = new HashMap<>();
    static {
        mapMateriales.put(0,"Acrilico");
        mapMateriales.put(1,"PolyGel");
        mapMateriales.put(2,"GelX");
    }
}
