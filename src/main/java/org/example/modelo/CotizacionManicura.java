package org.example.modelo;

import org.example.datos.ManejoArchivo;

/**
 * Esta clase se encarga de todos los metodos relacionados al funcionamiento de una cotizacion.
 */
public class CotizacionManicura {

	private int cantColores;
	private int largo;
	private int material;
	private int[] diseño;
	private int[] decoracion;
	private float valorEstimado;
	private int tiempoEstimado;

	/**
	 * Metodo getter de cantColores.
	 *
	 * @return El valor del la cantidad de colores asociado a la cotizacion.
	 */
	public int getCantColores() {
		return this.cantColores;
	}


	/**
	 * Metodo getter de largo.
	 *
	 * @return El indice del largo, siendo 0=Natural, 1=S, 2=M, 3=L.
	 */
	public int getLargo() {
		return this.largo;
	}

	/**
	 * Metodo getter de material.
	 *
	 * @return El indice asociado del material, siendo 0=Acrilico, 1=PolyGel, 2=GelX.
	 */
	public int getMaterial() {
		return this.material;
	}

	/**
	 * Metodo getter de los diseños.
	 *
	 * @return El arreglo asociado a los diseños, teniendo en la posicion 1 los diseños simples, y en la posicios 2 los sofisticados.
	 */
	public int[] getDiseño() {
		return this.diseño;
	}

	/**
	 * Metodo getter de las decoraciones.
	 *
	 * @return El arreglo asociado a las decoraciones, teniendo en la posicion 1 los decoraciones de cristales, y en la posicios 2 las decoraciones 3d.
	 */
	public int[] getDecoracion() {
		return this.decoracion;
	}

	/**
	 * Metodo getter de el valorEstimado.
	 *
	 * @return El valor en pesos de la cotizacion elegida.
	 */
	public float getValorEstimado() {
		return this.valorEstimado;
	}

	/**
	 * Metodo getter del tiempoEstimado.
	 *
	 * @return El tiempo estimado en realizar el servicio elegido.
	 */
	public int getTiempoEstimado() {
		return this.tiempoEstimado;
	}


	/**
	 * Este metodo hace el calculo del valor total requerido para hacer esta configuracion de manicura, usando metodos de la clase Calculo.
	 *
	 * @return El valor monetario calculado de la cotizacion.
	 */
	public float valorTotal() {
		float valorEstimado = Calculo.calcValorColores(this.cantColores)+Calculo.calcValorDecoracion(this.decoracion)+
				Calculo.calcValorDiseño(this.diseño)+Calculo.calcValorMaterial(this.material)+
				Calculo.calcValorLargo(this.largo);
		return valorEstimado;
	}

	/**
	 * Metodo para calcular el valor mas iva
	 *
	 * @param neto Valor monetario al que se le calculara el iva
	 * @return Valor ingresado mas su correspondiente iva
	 */
	public float iva(float neto){
		return (float) (neto*1.19);
	}

	/**
	 * Constructor de la clase el cual debe recibir los parametros necesarios para sus atributos, siendo el valor y el tiempo calculador por la misma clase posteriormente.
	 *
	 * @param cantColores Cantidad de colores a poner en la cotizacion.
	 * @param largo Indice del largo a poner en la cotizacion.
	 * @param material Indice del material a poner en la cotizacion.
	 * @param diseño Cantidad y disposicion de los diseños a poner en la cotizacion.
	 * @param decoracion Cantidad y disposicion de las decoraciones a poner en la cotizacion.
	 */
	public CotizacionManicura(int cantColores, int largo, int material,int diseño[], int[] decoracion) {
		this.cantColores = cantColores;
		this.largo = largo;
		this.material = material;
		this.diseño = diseño;
		this.decoracion = decoracion;
		this.valorEstimado = iva(valorTotal());
		this.tiempoEstimado = tiempoTotal();

	}

	/**
	 * Este metodo hace el calculo del tiempo total requerido para hacer esta configuracion de manicura, usando metodos de la clase Calculo.
	 *
	 * @return El valor del tiempo calculado de la cotizacion.
	 */
	public int tiempoTotal() {
		int tiempoEstimado = Calculo.calcTiempoColores(this.cantColores)+Calculo.calcTiempoDecoracion(this.decoracion)+
							Calculo.calcTiempoDiseño(this.diseño)+Calculo.calcTiempoMaterial(this.material)+
							Calculo.calcTiempoLargo(this.largo);
		return tiempoEstimado;
	}

	/**
	 * Este metodo le pide hace que la cotizacion se guarde, pidiendole un metodo a ManejoArchivo.
	 *
	 */
	public void guardarse(){
		ManejoArchivo.guardarCotizacion(this);
	}

}