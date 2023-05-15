package org.example;

import java.util.Scanner;

public class Utils {

	/**
	 * 
	 * @param rutaArchivo
	 */
	public boolean validarExistenciaArchivo(String rutaArchivo) {
		// TODO - implement Utils.validarExistenciaArchivo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param num
	 */
	public boolean validarEntero(int num) {
		// TODO - implement Utils.validarEntero
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param num
	 * @param min
	 * @param max
	 */
	public static boolean validarRango(int num, int min, int max) {

		if (num < min || num > max) {
			return false;
		}
		return true;
	}

	public static int ingresarSoloEntero() {

		Scanner in = new Scanner(System.in);
		while (!in.hasNextInt()) {
			System.out.println("Entrada no válida. Ingrese un número entero:");
			in.next();
		}
		int numero = in.nextInt();
		return numero;
	}
}