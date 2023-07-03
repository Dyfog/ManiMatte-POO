package org.example.datos;

import org.example.modelo.CotizacionManicura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase se encarga del manejo de archivos e ingreso de datos de las cotizaciones
 */
public class ManejoArchivo {

	private static String ruta = "archivoCotizaciones.txt";

	/**
	 * Este metodo crea la linea de texto que da cuenta de los datos de la cotizacion.
	 * @param cotizacion Este es el objeto CotizacionManicura, el cual representa la cotizacion hecha por el usuario.
	 * @return La linea de texto de la cotizacion.
	 */
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

	/**
	 * Este metodo revisa si el archivo que busca existe, de no existir, lo crea.
	 */
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

	/**
	 * Este metodo añade la linea de texto de la cotizacion al archivo donde se guardan.
	 * @param lineaCotizacion es la linea de texto que representa la cotizacion.
	 */
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

	/**
	 * Este metodo hace el proceso completo que corresponde al guardado, desde hacer la linea de texto, verificar existencia del archivo, y finalmente guardar.
	 * @param cotizacion Este es el objeto CotizacionManicura, el cual representa la cotizacion hecha por el usuario
	 */
	public static void guardarCotizacion(CotizacionManicura cotizacion){
		if(!validarExistenciaArchivo()){
			crearArchivo();
		}
		String lineaCotizacion = crearLineaCotizacion(cotizacion);
		añadirCotizacionAlArchivo(lineaCotizacion);
	}

	/**
	 * Metodo encargado de revisar si el archivo buscado existe o no
	 * @return Un boleano que da cuenta si existe o no el archivo.
	 */
	private static boolean validarExistenciaArchivo() {
		File file = new File(ruta);
		return file.exists();
	}

	/**
	 * Metodo usado para obtener la hora actual del dispositivo, usada para la cotizacion
	 * @return La hora actual del dispositivo donde se ejecuta el programa.
	 */
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