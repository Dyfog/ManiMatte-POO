package org.example.datos;

import org.example.modelo.CotizacionManicura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ManejoArchivo {

	private static String ruta = "archivoCotizaciones.txt";


	private static String crearLineaCotizacion(CotizacionManicura cotizacion) {
		String largo= mapLargos.get(cotizacion.getLargo());
		String material= mapMateriales.get(cotizacion.getMaterial());
		String hora = obtenerHora();

		//falta el tiempo y valor de la cotizacion
		String linea = "Hora: "+hora+", Cantidad de colores: "+String.valueOf(cotizacion.getCantColores())+", Largo de la uña: "+largo
				+", Material: "+material+", Decoraciones simples: "+cotizacion.getDecoracion()[0]
				+", Decoraciones sofisticadas: "+cotizacion.getDecoracion()[1]+", Diseños en cristales: "
				+cotizacion.getDiseño()[0]+", Diseños 3D: "+cotizacion.getDiseño()[1]+", Tiempo estimado: "
				+cotizacion.getTiempoEstimado()+" mins"+", Valor total: "+cotizacion.getValorEstimado()+" pesos"+" || ";
		return linea;
	}


	private static void crearArchivo() {
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


	private static void añadirCotizacionAlArchivo(String lineaCotizacion) {
		try {
			FileWriter fileWriter = new FileWriter(ruta, true); // El segundo parámetro "true" indica que se añadirá al final del archivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(lineaCotizacion);
			bufferedWriter.newLine();

			bufferedWriter.close();

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


	private static boolean validarExistenciaArchivo() {
		File file = new File(ruta);
		return file.exists();
	}

	private static String obtenerHora(){
		LocalTime horaActual = LocalTime.now();
		String horaFormateada = horaActual.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
		return horaFormateada;
	}

	private static Map<Integer,String> mapLargos = new HashMap<Integer,String>();
	static {
		mapLargos.put(0,"Natural");
		mapLargos.put(1,"S");
		mapLargos.put(2,"M");
		mapLargos.put(3,"L");
	}

	private static Map<Integer,String> mapMateriales = new HashMap<>();
	static {
		mapMateriales.put(0,"Acrilico");
		mapMateriales.put(1,"PolyGel");
		mapMateriales.put(2,"GelX");
	}
}