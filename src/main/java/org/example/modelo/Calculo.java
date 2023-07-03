package org.example.modelo;

import org.example.util.Util;

public class Calculo {

	/**
	 * Este metodo hace el calculo del valor de el material dependiendo de la eleccion hecha.
	 *
	 * @param eleccionMaterial Valor asignado para el material, este se ingresa como eleccion numerica, siendo 0=Acrilico, 1=PolyGel, 2=GelX.
	 * @return El valor calculado de el material elegido.
	 */
	public static int calcValorMaterial(int eleccionMaterial) {
		int valorMaterial;
		switch (eleccionMaterial){
			case 0:
				valorMaterial = 6000;
				break;
			case 1:
				valorMaterial = 5000;
				break;
			case 2:
				valorMaterial = 4000;
				break;
			default:
				valorMaterial = 0;
		}
		return valorMaterial;
	}

	/**
	 * Este metodo hace el calculo del valor del los diseños elegidos dependiendo eleccion hecha.
	 *
	 * @param diseños Arreglo de 2 elementos con la cantidad de diseños simples y sofisticados, la suma de ellos no puede superar el valor 10.
	 * @return El valor calculado de el conjunto de los diseños elegidos.
	 */
	public static int calcValorDiseño(int [] diseños) {

		int valor = ((diseños[0] * 500) + (diseños[1] * 1200));
		return valor;
	}

	/**
	 * Este metodo hace el calculo del valor del largo dependiendo de la eleccion hecha.
	 *
	 * @param eleccionLargo Valor asigando para el largo elegido, va de 0 a 3, siendo 0=Natural, 1=S, 2=M, 3=L.
	 * @return El valor calculado del largo elegido.
	 */
	public static int calcValorLargo(int eleccionLargo) {
		int valorLargo;
		switch (eleccionLargo){
			case 0:
				valorLargo = 0;
				break;
			case 1:
				valorLargo = 5000;
				break;
			case 2:
				valorLargo = 7000;
				break;
			case 3:
				valorLargo = 9000;
				break;
			default:
				valorLargo = 0;
		}
		return valorLargo;
	}

	/**
	 * Este metodo hace el calculo del valor de las decoraciones dependiendo de la eleccion hecha.
	 *
	 * @param decoraciones Arreglo de 2 posiciones con la cantidad de decoraciones, cirstales y decoraciones 3d respectivamente, la suma de ellos no puede superar el valor 10.
	 * @return El valor calculado de el conjunto de los decoraciones elegidas.
	 */
	public static int calcValorDecoracion(int [] decoraciones) {

		int valor = (decoraciones[0]*600)+(decoraciones[1]*1500);
		return valor;
	}

	/**
	 * Este metodo hace el calculo del valor de la cantidad de colores dependiendo de la eleccion hecha.
	 *
	 * @param cantColores Valor asignado para la cantidad de colores, pueden ir de 0 a 5
	 * @return El valor calculado de la cantidad de colores elegida.
	 */
	public static int calcValorColores(int cantColores) {
		int valorColores = 0;
		if (Util.validarRango(cantColores,0,2)) {
			valorColores = 8000;
		}else  {
			valorColores = 9000;
		}
		return valorColores;
	}

	/**
	 * Este metodo hace el calculo del tiempo de el material dependiendo de la eleccion hecha.
	 *
	 * @param eleccionMaterial Valor asignado para el material, este se ingresa como eleccion numerica, siendo 0=Acrilico, 1=PolyGel, 2=GelX.
	 * @return El tiempo calculado de el material elegido.
	 */
	public static int calcTiempoMaterial(int eleccionMaterial) {
		int minutos;
		switch (eleccionMaterial){
			case 0:
				minutos = 50;
				break;
			case 1:
				minutos = 30;
				break;
			case 2:
				minutos = 15;
				break;
			default:
				minutos = 0;
		}
		return minutos;
	}

	/**
	 * Este metodo hace el calculo del tiempo del los diseños elegidos dependiendo eleccion hecha.
	 *
	 * @param diseños Arreglo de 2 elementos con la cantidad de diseños simples y sofisticados, la suma de ellos no puede superar el valor 10.
	 * @return El tiempo calculado de el conjunto de los diseños elegidos.
	 */
	public static int calcTiempoDiseño(int [] diseños) {

		int minutos = ((diseños[0] * 3) + (diseños[1] * 7));
		return minutos;
	}

	/**
	 * Este metodo hace el calculo del tiempo del largo dependiendo de la eleccion hecha.
	 *
	 * @param eleccionLargo Valor asigando para el largo elegido, va de 0 a 3, siendo 0=Natural, 1=S, 2=M, 3=L.
	 * @return El tiempo calculado del largo elegido.
	 */
	public static int calcTiempoLargo(int eleccionLargo) {
		int minutos;
		switch (eleccionLargo){
			case 0:
				minutos = 0;
				break;
			case 1:
				minutos = 20;
				break;
			case 2:
				minutos = 25;
				break;
			case 3:
				minutos = 30;
				break;
			default:
				minutos = 0;
		}
		return minutos;
	}

	/**
	 * Este metodo hace el calculo del tiempo de las decoraciones dependiendo de la eleccion hecha.
	 *
	 * @param decoraciones Arreglo de 2 posiciones con la cantidad de decoraciones, cirstales y decoraciones 3d respectivamente, la suma de ellos no puede superar el valor 10.
	 * @return El tiempo calculado de el conjunto de los decoraciones elegidas.
	 */
	public static int calcTiempoDecoracion(int [] decoraciones) {

		int minutos = (decoraciones[0]*4)+(decoraciones[1]*6);
		return minutos;
	}

	/**
	 * Este metodo hace el calculo del tiempo de la cantidad de colores dependiendo de la eleccion hecha.
	 *
	 * @param cantColores Valor asignado para la cantidad de colores, pueden ir de 0 a 5
	 * @return El tiempo calculado de la cantidad de colores elegida.
	 */
	public static int calcTiempoColores(int cantColores) {

		if (Util.validarRango(cantColores,0,2)) {
			return 20;
		}else  {
			return 30;
		}
	}

}