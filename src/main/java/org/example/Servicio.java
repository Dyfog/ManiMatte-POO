package org.example;
import java.util.Scanner;

public class Servicio {

	public static int eleccionMaterial() {

		System.out.println("Ingrese el número que corresponda a su elección: ");
		System.out.println("[0] Acrílico");
		System.out.println("[1] PolyGel");
		System.out.println("[2] GelX");
		int eleccion=Utils.ingresarSoloEntero();
		while (!Utils.validarRango(eleccion,0,2)) {
			System.out.println("valor ingresado no valido, ingrese una opción nuevamente");
			eleccion = Utils.ingresarSoloEntero();
		}
		System.out.println("Elección ingresada");
		return eleccion;
	}

	public static int[] eleccionDiseño() {

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
			System.out.println("El numero ingresado no es valido, respete la cantidad máxima");
			cantSofisticados = Utils.ingresarSoloEntero();
		}

		elecciones[0]= cantSimples;
		elecciones[1]= cantSofisticados;
		System.out.println("Cantidades ingresadas");
		return elecciones;
	}

	public static int eleccionLargo() {

		System.out.println("ingrese el largo de uña que desea");
		System.out.println("0.- Natural");
		System.out.println("1.- S");
		System.out.println("2.- M");
		System.out.println("3.- L");
		int eleccion = Utils.ingresarSoloEntero();
		while (!Utils.validarRango(eleccion,0,3)) {
			System.out.println("Valor ingresado no valido, ingrese una opción nuevamente");
			eleccion = Utils.ingresarSoloEntero();
		}
		System.out.println("Elección ingresada");
		return eleccion;
	}

	public static int[] eleccionDecoracion() {

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
			System.out.println("El numero ingresado no es valido, respete la cantidad máxima");
			cantAccesorios3D = Utils.ingresarSoloEntero();
		}

		elecciones[0]= cantCristales;
		elecciones[1]= cantAccesorios3D;
		System.out.println("Cantidades ingresadas");
		return elecciones;
	}

	public static int eleccionColores() {

		System.out.println("ingrese la cantidad de colores que desea: ");
		int cantColores = Utils.ingresarSoloEntero();
		while (!Utils.validarRango(cantColores,0,5)){
			System.out.println("valor ingresado no valido, el máximo es 5, ingrese nuevamente");
			cantColores = Utils.ingresarSoloEntero();
		}
		System.out.println("Cantidad ingresada");
		return cantColores;
	}

	public static void guardarCotizacion (CotizacionManicura cotizacion){
		ManejoArchivo.guardarCotizacion(cotizacion);
	}

	public static void lanzarManicura() {
		boolean manternerProgrmaActivo = true;
		CotizacionManicura cotizacion = new CotizacionManicura();
		while (manternerProgrmaActivo) {
			opcionesMenu();
			int eleccion = Utils.ingresarSoloEntero();
			while (!Utils.validarRango(eleccion,1,9)){
				System.out.println("Ingrese una acción válida");
				eleccion = Utils.ingresarSoloEntero();
			}
			switch (eleccion){
				case 1:
					cotizacion.setCantColores(eleccionColores());
					break;
				case 2:
					cotizacion.setLargo(eleccionLargo());
					break;
				case 3:
					cotizacion.setMaterial(eleccionMaterial());
					break;
				case 4:
					cotizacion.setDiseño(eleccionDiseño());
					break;
				case 5:
					cotizacion.setDecoracion(eleccionDecoracion());
					break;
				case 6:
					cotizacion.setValorEstimado(cotizacion.valorTotal()+Math.round(cotizacion.iva()));
					System.out.println("El valor total es: $"+cotizacion.getValorEstimado()+" pesos");
					break;
				case 7:
					cotizacion.setTiempoEstimado(cotizacion.tiempoTotal());
					System.out.println("El tiempo estimado del servico completo es de: "+cotizacion.getTiempoEstimado()+" mins");
					break;
				case 8:
					ManejoArchivo.guardarCotizacion(cotizacion);
					cotizacion = null;
					cotizacion = new CotizacionManicura();
					System.out.println("Se ha guardado la cotización, iniciando una nueva");
					break;
				case 9:
					manternerProgrmaActivo = false;
					break;
			}
		}
	}

	public static void opcionesMenu() {
		System.out.println("Selecciones la opcion que desea realizar");
		System.out.println("1.-Elegir Colores");
		System.out.println("2.-Elegir Largo");
		System.out.println("3.-Elegir Material");
		System.out.println("4.-Elegir Diseños");
		System.out.println("5.-Elegir Decoraciones");
		System.out.println("6.-Calcular Valor");
		System.out.println("7.-Calcular Tiempo Estimado");
		System.out.println("8.Finalizar y guardar cotizacion");
		System.out.println("9.-Salir del programa\n");
	}
}