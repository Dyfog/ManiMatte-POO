package org.example;

import java.util.Scanner;

public class Cotizacion {

	private int cantColores;
	private int largo;
	private int material;
	private int[] diseño;
	private int[] decoracion;
	private int valor;
	private int tiempoEstimado;

	public int getCantColores() {
		return this.cantColores;
	}

	public void setCantColores(int cantColores) {
		this.cantColores = cantColores;
	}

	public int getLargo() {
		return this.largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getMaterial() {
		return this.material;
	}

	public void setMaterial(int material) {
		this.material = material;
	}

	public int[] getDiseño() {
		return this.diseño;
	}

	public void setDiseño(int[] diseño) {
		this.diseño = diseño;
	}

	public int[] getDecoracion() {
		return this.decoracion;
	}

	public void setDecoracion(int[] decoracion) {
		this.decoracion = decoracion;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getTiempoEstimado() {
		return this.tiempoEstimado;
	}

	public void setTiempoEstimado(int tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public int eleccionMaterial() {

		System.out.println("Ingrese el número que corresponda a su elección: ");
		System.out.println("[0] Acrílico");
		System.out.println("[1] PolyGel");
		System.out.println("[2] GelX");
		int eleccion=Utils.ingresarSoloEntero();
		while (!Utils.validarRango(eleccion,0,2)) {
			System.out.println("valor ingresado no valido, ingrese nuevamente");
			eleccion = Utils.ingresarSoloEntero();
		}
		return eleccion;
	}

	public int[] eleccionDiseño() {

		int[] elecciones =new int[2];
		System.out.println("Eliga los diseños, son 1 por cada uña, maximo 10");
		System.out.println("En caso de no querer diseños, ingrese 0 cuando se le pida la cantidad");

		System.out.println("Ingrese la cantidad de diseños simples: ");
		int cantSimples =Utils.ingresarSoloEntero();
		while (!Utils.validarRango(cantSimples,0,10)) {
			System.out.println("Ingrese un número menor a 11");
			cantSimples = Utils.ingresarSoloEntero();
		}

		System.out.println("Ingrese la cantidad de diseños sofisticados: ");
		int cantSofisticados = Utils.ingresarSoloEntero();
		while (!Utils.validarRango(cantSofisticados,0,10-cantSimples)){
			System.out.println("El numero ingresado no es valido");
			cantSofisticados = Utils.ingresarSoloEntero();
		}

		elecciones[0]= cantSimples;
		elecciones[1]= cantSofisticados;
		return elecciones;
	}

	public int eleccionLargo() {

		System.out.println("ingrese el largo de uña que desea");
		System.out.println("0.- Natural");
		System.out.println("1.- S");
		System.out.println("2.- M");
		System.out.println("3.- L");
		int eleccion = Utils.ingresarSoloEntero();
		while (!Utils.validarRango(eleccion,0,3)) {
			System.out.println("valor ingresado no valido, ingrese nuevamente");
			eleccion = Utils.ingresarSoloEntero();
		}
		return eleccion;
	}

	public int[] eleccionDecoracion() {

		int[] elecciones =new int[2];
		System.out.println("Eliga las decoraciones, puede optar por cristales y/o accesorios 3D, son 1 por cada uña, maximo 10");
		System.out.println("En caso de no querer accesorios, ingrese 0 cuando se le pida la cantidad");

		System.out.println("Ingrese la cantidad de cristales: ");
		int cantCristales = Utils.ingresarSoloEntero();
		while (!Utils.validarRango(cantCristales,0,10)) {
			System.out.println("Ingrese un número menor a 11");
			cantCristales = Utils.ingresarSoloEntero();
		}

		System.out.println("Ingrese la cantidad de accesorios 3D: ");
		int cantAccesorios3D = Utils.ingresarSoloEntero();
		while (!Utils.validarRango(cantAccesorios3D,0,10-cantCristales)){
			System.out.println("El numero ingresado no es valido");
			cantAccesorios3D = Utils.ingresarSoloEntero();
		}

		elecciones[0]= cantCristales;
		elecciones[1]= cantAccesorios3D;
		return elecciones;
	}

	public int eleccionColores() {

		Scanner teclado = new Scanner(System.in);
		System.out.println("ingrese la cantidad de colores que desea: ");
		int cantColores = Utils.ingresarSoloEntero();
		while (!Utils.validarRango(cantColores,0,5)){
			System.out.println("valor ingresado no valido, ingrese nuevamente");
			cantColores = Utils.ingresarSoloEntero();
		}
		return cantColores;
	}

	public void valorTotal() {
		// TODO - implement Cotizacion.valorTotal
		throw new UnsupportedOperationException();
	}

	public void tiempoTotal() {
		// TODO - implement Cotizacion.tiempoTotal
		throw new UnsupportedOperationException();
	}
}