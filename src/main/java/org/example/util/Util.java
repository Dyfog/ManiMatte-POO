package org.example.util;

/**
 * Esta clase contiene utilitarios usados en el proyecto.
 */
public class Util {

	/**
	 * Este metodo valida si el numero ingresado esta dentro de los rangos especificados.
	 *
	 * @param num Valor asignado verificarse
	 * @param min Valor asignado para el rango maximo inclusive
	 * @param max Valor asignado para el rango minimo inclusive
	 * @return Un boleano que especifica si el numero esta dentro de los rangos especificados
	 */
	public static boolean validarRango(int num, int min, int max) {

		if (num < min || num > max) {
			return false;
		}
		return true;
	}



}