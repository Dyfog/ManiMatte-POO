package org.example.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CotizacionTest {
    CotizacionManicura cotizacionTest1 = new CotizacionManicura(1,2,2,new int[]{6,3},new int[]{4,1});
    CotizacionManicura cotizacionTest2 = new CotizacionManicura(4,1,0,new int[]{3,2},new int[]{5,2});
    CotizacionManicura cotizacionTest3 = new CotizacionManicura(5,2,1,new int[]{1,5},new int[]{2,6});
    CotizacionManicura cotizacionTest4 = new CotizacionManicura(2,0,2,new int[]{3,7},new int[]{1,9});


    @Test
    void valorTotal() {
        //Revision de los valores monetarios, se considera que incluye el iva
        assertEquals(35105,cotizacionTest1.getValorEstimado());
        assertEquals(35581,cotizacionTest2.getValorEstimado());
        assertEquals(44863,cotizacionTest3.getValorEstimado());
        assertEquals(42840,cotizacionTest4.getValorEstimado());
    }

    @Test
    void tiempoTotal() {
        //Revision de los tiempos estimados
        assertEquals(121,cotizacionTest1.getTiempoEstimado());
        assertEquals(155,cotizacionTest2.getTiempoEstimado());
        assertEquals(167,cotizacionTest3.getTiempoEstimado());
        assertEquals(151,cotizacionTest4.getTiempoEstimado());

    }
}