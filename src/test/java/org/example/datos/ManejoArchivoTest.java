package org.example.datos;

import org.example.modelo.CotizacionManicura;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalTime;


import static org.junit.jupiter.api.Assertions.*;

class ManejoArchivoTest {

    CotizacionManicura cotizacionTest1 = new CotizacionManicura(2,1,2,new int[]{2,4},new int[]{5,4});

    @Test
    void crearLineaCotizacion() {
        LocalTime time = LocalTime.now();
        String lineaEsperada = "Hora: "+time.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"))+
                ", Cantidad de colores: 2, Largo de la uña: S, Material: GelX, Decoraciones simples: 5" +
                ", Decoraciones sofisticadas: 4, Diseños en cristales: 2, Diseños 3D: 4" +
                ", Tiempo estimado: 133 mins, Valor total: 37842.0 pesos || ";
        String lineaGenerada = ManejoArchivo.crearLineaCotizacion(cotizacionTest1);
        assertEquals(lineaEsperada,lineaGenerada);
    }

    @Test
    void crearArchivo() {
        /* Este test revisa si el archivo que intenta crear el metodo existe
        , recordar que si el metodo encuentra que el archivo txt existe, no lo creara, por lo que se puede probar con
         el archivo creado, o borrando el archivo para efectivamente testear su correcto funcionamiento */
        ManejoArchivo.crearArchivo();
        File archivo = new File("archivoCotizaciones.txt");
        assertTrue(archivo.exists());
    }

    @Test
    void validarExistenciaArchivo() {
        //Este metodo revisa si el archivo txt de las cotizaciones existe, mientras se diseña esta prueba el archivo existe.
        assertTrue(ManejoArchivo.validarExistenciaArchivo());
    }

    @Test
    void obtenerHora() {
        //Este metodo obtiene la hora sel sistema y la retorna como String en formato HH:mm:ss.
        LocalTime hora = LocalTime.now();
        String horaEsperada = hora.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        String horaObtenida = ManejoArchivo.obtenerHora();
        assertEquals(horaEsperada,horaObtenida);
    }
}