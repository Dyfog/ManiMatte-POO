package org.example;

public class CotizacionManicura {

	private int cantColores;
	private int largo;
	private int material;
	private int[] diseño;
	private int[] decoracion;
	private int valorEstimado;
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

	public int getValorEstimado() {
		return this.valorEstimado;
	}

	public void setValorEstimado(int valorEstimado) {
		this.valorEstimado = valorEstimado;
	}

	public int getTiempoEstimado() {
		return this.tiempoEstimado;
	}

	public void setTiempoEstimado(int tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public int valorTotal() {
		int valorEstimado = Calculo.calcValorColores(this.cantColores)+Calculo.calcValorDecoracion(this.decoracion)+
				Calculo.calcValorDiseño(this.diseño)+Calculo.calcValorMaterial(this.material)+
				Calculo.calcValorLargo(this.largo);
		return valorEstimado;
	}

	public CotizacionManicura() {
		this.cantColores = 1;
		this.largo = 0;
		this.material = 0;
		this.diseño = new int[]{0, 0};
		this.decoracion = new int[]{0, 0};
		this.valorEstimado = 14000;
		this.tiempoEstimado = 70;
	}

	public int tiempoTotal() {
		int tiempoEstimado = Calculo.calcTiempoColores(this.cantColores)+Calculo.calcTiempoDecoracion(this.decoracion)+
							Calculo.calcTiempoDiseño(this.diseño)+Calculo.calcTiempoMaterial(this.material)+
							Calculo.calcTiempoLargo(this.largo);
		return tiempoEstimado;
	}


	public void cambiar (){
		this.valorEstimado = 1000;
	}
}