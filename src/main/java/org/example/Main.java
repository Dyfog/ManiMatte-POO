package org.example;

public class Main {
	public static void main(String[] args) {
		CotizacionManicura c1 = new CotizacionManicura();
		c1.setCantColores(2);
		c1.setDecoracion(new int[]{5, 3});
		c1.setDiseño(new int[]{5,5});
		c1.setLargo(0);
		c1.setMaterial(1);
		c1.setValorEstimado(c1.valorTotal());
		c1.setTiempoEstimado(c1.tiempoTotal());
		System.out.println(ManejoArchivo.crearLineaCotizacion(c1));
		ManejoArchivo.guardarCotizacion(c1);
	}

	public void lanzar() {
		// TODO - implement Main.lanzar
		throw new UnsupportedOperationException();
	}

}