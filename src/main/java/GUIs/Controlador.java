package GUIs;

public enum Controlador {
    INSTANCE;

    public static Ventana1 ventana1 = new Ventana1();
    public static Ventana2 ventana2 = new Ventana2();
    public static Ventana3 ventana3 = new Ventana3();
    public static Ventana4 ventana4 = new Ventana4();
    public static Ventana5 ventana5 = new Ventana5();

    public static void abrirVentana1(){
        ventana1.setVisible(true);
    }

    public static void abrirVentana2(){
        ventana2.setVisible(true);
    }

    public static void abrirVentana3(){
        ventana3.setVisible(true);
    }

    public static void abrirVentana4(){
        ventana4.setVisible(true);
    }

    public static void abrirVentana5(){
        ventana5.setVisible(true);
    }

    public static void cerrarVentana1(){
        ventana1.setVisible(false);
    }

    public static void cerrarVentana2(){
        ventana2.setVisible(false);
    }

    public static void cerrarVentana3(){
        ventana3.setVisible(false);
    }

    public static void cerrarVentana4(){
        ventana4.setVisible(false);
    }

    public static void cerrarVentana5(){
        ventana5.setVisible(false);
    }
}
