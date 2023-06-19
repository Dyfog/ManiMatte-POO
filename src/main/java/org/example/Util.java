package org.example;

import java.util.Scanner;

public class Util {
	
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