package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManejoArchivo {

	private static String ruta = "archivoCotizaciones.txt";


	public static String crearLineaCotizacion(CotizacionManicura cotizacion) {
		String largo;
		String material;
		if (cotizacion.getLargo()==0){
			largo = "Natural";
		} else if (cotizacion.getLargo()==1) {
			largo = "S";
		} else if (cotizacion.getLargo()==2) {
			largo = "M";
		} else {
			largo = "L";
		}

		if (cotizacion.getMaterial()==0){
			material = "Acrilico";
		} else if (cotizacion.getMaterial()==1) {
			material = "PolyGel";
		}else {
			material = "GelX";
		}
		//falta el tiempo y valor de la cotizacion
		String linea = "Cantidad de colores: "+String.valueOf(cotizacion.getCantColores())+", Largo de la uña: "+largo
				+", Material: "+material+", Decoraciones simples: "+cotizacion.getDecoracion()[0]
				+", Decoraciones sofisticadas: "+cotizacion.getDecoracion()[1]+", Diseños en cristales: "
				+cotizacion.getDiseño()[0]+", Diseños 3D: "+cotizacion.getDiseño()[1]+", Tiempo estimado: "
				+cotizacion.getTiempoEstimado()+" mins"+", Valor total: "+cotizacion.getValorEstimado()+" pesos"+" || ";
		return linea;
	}


	public static void crearArchivo() {
		File archivo = new File(ruta);
		try {
			boolean creado = archivo.createNewFile();
			if (creado) {
				System.out.println("El archivo se ha creado correctamente.");
			} else {
				System.out.println("El archivo ya existe en la ruta especificada.");
			}
		} catch (IOException e) {
			System.out.println("Se produjo un error al crear el archivo: " + e.getMessage());
		}
	}


	public static void añadirCotizacionAlArchivo(String lineaCotizacion) {
		try {
			FileWriter fileWriter = new FileWriter(ruta, true); // El segundo parámetro "true" indica que se añadirá al final del archivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(lineaCotizacion);
			bufferedWriter.newLine();

			bufferedWriter.close();

			System.out.println("Se agregó la línea al archivo correctamente.");
		} catch (IOException e) {
			System.out.println("Se produjo un error al agregar la línea al archivo: " + e.getMessage());
		}
	}

	public static void guardarCotizacion(CotizacionManicura cotizacion){
		if(!validarExistenciaArchivo()){
			crearArchivo();
		}
		String lineaCotizacion = crearLineaCotizacion(cotizacion);
		añadirCotizacionAlArchivo(lineaCotizacion);
	}


	public static boolean validarExistenciaArchivo() {
		File file = new File(ruta);
		return file.exists();
	}
}