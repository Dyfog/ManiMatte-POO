package org.example.util;

import java.util.Scanner;

public class Util {
	
	public static boolean validarRango(int num, int min, int max) {

		if (num < min || num > max) {
			return false;
		}
		return true;
	}



}