package org.example;


import org.example.modelo.Calculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculoTest {

    int material1;
    int material2;
    int material3;
    int simples1;
    int simples2;
    int simples3;
    int sofisticados1;
    int sofisticados2;
    int sofisticados3;
    int[] arregloTesting1 = new int[2];
    int[] arregloTesting2 = new int[2];
    int[] arregloTesting3 = new int[2];
    int largo1;
    int largo2;
    int largo3;
    int color1;
    int color2;
    int color3;


    @BeforeEach
    void setUp() {

        material1 = 0;
        material2 = 1;
        material3 = 2;

        simples1 = 5;
        simples2 = 10;
        simples3 = 0;

        sofisticados1 = 5;
        sofisticados2 = 0;
        sofisticados3 = 0;

        arregloTesting1[0] = simples1;
        arregloTesting2[0] = simples2;
        arregloTesting3[0] = simples3;

        arregloTesting1[1] = sofisticados1;
        arregloTesting2[1] = sofisticados2;
        arregloTesting3[1] = sofisticados3;

        largo1 = 0;
        largo2 = 1;
        largo3 = 2;

        color1 = 0;
        color2 = 2;
        color3 = 5;
    }

    @Test
    void calculoMaterialTest(){
        assertEquals(6000, Calculo.calcValorMaterial(material1));
        assertEquals(5000,Calculo.calcValorMaterial(material2));
        assertEquals(4000,Calculo.calcValorMaterial(material3));
    }
    @Test
    void calculoDiseñoTest(){
        assertEquals(8500,Calculo.calcValorDiseño(arregloTesting1));
        assertEquals(5000,Calculo.calcValorDiseño(arregloTesting2));
        assertEquals(0,Calculo.calcValorDiseño(arregloTesting3));
    }
    @Test
    void calculoDecoracionTest(){
        assertEquals(10500,Calculo.calcValorDecoracion(arregloTesting1));
        assertEquals(6000,Calculo.calcValorDecoracion(arregloTesting2));
        assertEquals(0,Calculo.calcValorDecoracion(arregloTesting3));
    }
    @Test
    void calculoLargoTest(){
        assertEquals(0,Calculo.calcValorLargo(largo1));
        assertEquals(5000,Calculo.calcValorLargo(largo2));
        assertEquals(7000,Calculo.calcValorLargo(largo3));
    }
    @Test
    void calculoColorTest(){
        assertEquals(8000,Calculo.calcValorColores(color1));
        assertEquals(8000,Calculo.calcValorColores(color2));
        assertEquals(9000,Calculo.calcValorColores(color3));
    }

    @Test
    void calcTiempoMaterial(){
        assertEquals(50,Calculo.calcTiempoMaterial(material1));
        assertEquals(30,Calculo.calcTiempoMaterial(material2));
        assertEquals(15,Calculo.calcTiempoMaterial(material3));
    }

    @Test
    void calcTiempoDiseño(){
        assertEquals(50,Calculo.calcTiempoDiseño(arregloTesting1));
        assertEquals(30,Calculo.calcTiempoDiseño(arregloTesting2));
        assertEquals(0,Calculo.calcTiempoDiseño(arregloTesting3));
    }

    @Test
    void calcTiempoLargo(){
        assertEquals(0,Calculo.calcTiempoLargo(largo1));
        assertEquals(20,Calculo.calcTiempoLargo(largo2));
        assertEquals(25,Calculo.calcTiempoLargo(largo3));
    }

    @Test
    void calcTiempoDecoraciones(){
        assertEquals(50,Calculo.calcTiempoDecoracion(arregloTesting1));
        assertEquals(40,Calculo.calcTiempoDecoracion(arregloTesting2));
        assertEquals(0,Calculo.calcTiempoDecoracion(arregloTesting3));
    }

    @Test
    void calcTiempoColores(){
        assertEquals(20,Calculo.calcTiempoColores(color1));
        assertEquals(20,Calculo.calcTiempoColores(color2));
        assertEquals(30,Calculo.calcTiempoColores(color3));
    }
}