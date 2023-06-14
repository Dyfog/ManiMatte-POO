package org.example;

public class Calculo {

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

	public static int calcValorDiseño(int [] diseños) {

		int valor = ((diseños[0] * 500) + (diseños[1] * 1200));
		return valor;
	}

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

	public static int calcValorDecoracion(int [] decoraciones) {

		int valor = (decoraciones[0]*600)+(decoraciones[1]*1500);
		return valor;
	}

	public static int calcValorColores(int cantColores) {
		int valorColores = 0;
		if (Utils.validarRango(cantColores,0,2)) {
			valorColores = 8000;
		}else  {
			valorColores = 9000;
		}
		return valorColores;
	}

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

	public static int calcTiempoDiseño(int [] diseños) {

		int minutos = ((diseños[0] * 3) + (diseños[1] * 7));
		return minutos;
	}

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

	public static int calcTiempoDecoracion(int [] decoraciones) {

		int minutos = (decoraciones[0]*4)+(decoraciones[1]*6);
		return minutos;
	}

	public static int calcTiempoColores(int cantColores) {

		if (Utils.validarRango(cantColores,0,2)) {
			return 20;
		}else  {
			return 30;
		}
	}

}