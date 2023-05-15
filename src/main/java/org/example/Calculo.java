package org.example;

public class Calculo {

	public int calcValorMaterial(int eleccion) {

		switch (eleccion){
			case 0:
				return 6000;
			case 1:
				return 5000;
			case 2:
				return 4000;
		}
		return 0;
	}

	public int calcValorDiseño(int [] eleccion) {

		int costo = ((eleccion[0] * 500) + (eleccion[1] * 1200));
		return costo;
	}

	public int calcValorLargo(int eleccionLargo) {

		switch (eleccionLargo){
			case 0:
				return 0;
			case 1:
				return 5000;
			case 2:
				return 7000;
			case 3:
				return 9000;
		}
		return 0;
	}

	public int calcValorDecoracion(int [] cantsDeco) {

		int costo = (cantsDeco[0]*600)+(cantsDeco[1]*1500);
		return costo;
	}

	public int calcValorColores(int cantColores) {

		if (Utils.validarRango(cantColores,0,2)) {
			return 8000;
		}else  {
			return 9000;
		}
	}

	public int calcTiempoMaterial(int eleccion) {

		switch (eleccion){
			case 0:
				return 50;
			case 1:
				return 30;
			case 2:
				return 15;
		}
		return 0;
	}

	public int calcTiempoDiseño(int [] eleccion) {

		int minutos = ((eleccion[0] * 3) + (eleccion[1] * 7));
		return minutos;
	}

	public int calcTiempoLargo(int eleccionLargo) {

		switch (eleccionLargo){
			case 0:
				return 0;
			case 1:
				return 20;
			case 2:
				return 25;
			case 3:
				return 30;
		}
		return 0;
	}

	public int calcTiempoDecoracion(int [] cantsDeco) {

		int minutos = (cantsDeco[0]*4)+(cantsDeco[1]*6);
		return minutos;
	}

	public int calcTiempoColores(int cantColores) {

		if (Utils.validarRango(cantColores,0,2)) {
			return 20;
		}else  {
			return 30;
		}
	}
}