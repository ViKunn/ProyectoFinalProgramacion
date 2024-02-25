package data;

import business.Map;

import java.io.*;
import java.util.Vector;

public class DataManager {

	private static Vector<String> readLines = new Vector<>();

	public static Map loadMap(String path) {

		readTxtFile(path);

		Vector<Vector<Integer>> numbers = strVectorToIntVector(DataManager.readLines);

		// TODO tamaño de la matriz
		Map map = new Map(numbers, 18, 18);

		return map;
	}

	// El resto de funciones que necesitan data

	/**
	 * Reads a .txt file
	 * @param path
	 * @return ArrayList of the read lines
	 */
	private static void readTxtFile(String path){

		readLines.clear();

		try {

			String line;
			FileReader fileReader = new FileReader(path);
			BufferedReader reader = new BufferedReader(fileReader);

			do {

				line = reader.readLine();
				readLines.add(line);

			} while (line != null);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Vector<Vector<Integer>> strVectorToIntVector(Vector<String> readLines){

		Vector<Vector<Integer>> rows = new Vector<>();

		for (int row = 0; row < readLines.size(); row++) {

			Vector<Integer> lineIntegers = new Vector<>();

			if (readLines.get(row) == null){
				break;
			}

			String[] lineNumbers = DataManager.readLines.get(row).split("\t");

			for (int col = 0; col < lineNumbers.length; col++) {

				int num = Integer.parseInt(lineNumbers[col]);
				lineIntegers.add(num);

			}

			rows.add(lineIntegers);

		}

		return rows;
	}

	public static void writeFile(File archivo, Object object){

		try {

			FileOutputStream flujoDeSalida = new FileOutputStream(archivo);
			ObjectOutputStream manejadorDeEscritura = new ObjectOutputStream(flujoDeSalida);

			manejadorDeEscritura.writeObject(object);
			manejadorDeEscritura.close();

		} catch (IOException e) {

			throw new RuntimeException(e);

		}
	}
	public static Object readFile(File archivo){

		Object object = new Object();

		try {

			FileInputStream flujoDeEntrada = new FileInputStream(archivo);
			ObjectInputStream manejadorDeLectura = new ObjectInputStream(flujoDeEntrada);

			object = (Object) manejadorDeLectura.readObject();

			manejadorDeLectura.close();

		} catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return object;
	}

}