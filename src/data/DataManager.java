package data;

import business.Fruit;
import business.Map;
import business.Position;
import business.characters.Enemy;
import business.managers.EnemyManager;
import business.managers.FruitManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class DataManager {

	private static Vector<String> readLines = new Vector<>();

	public static Map loadMap(String path) {

		readTxtFile(path);
		Vector<Vector<Integer>> numbers = strVectorToIntVector(DataManager.readLines);

		// TODO tamaño de la matriz
		return new Map(numbers, 18, 18);
	}

	// TODO control de errores en caso de que no exista la fruta
	private static ArrayList<Fruit> loadFruitLayer(String path) {

		readTxtFile(path);
		Vector<Vector<Integer>> numbers = strVectorToIntVector(readLines);

		FruitManager fruitManager = new FruitManager();
		ArrayList<Fruit> fruits = new ArrayList<>();

		int fruitNumber;
		int row = numbers.size();

		// TODO control de errores
		int col = numbers.get(1).size();

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				fruitNumber = numbers.get(i).get(j);

				if (fruitNumber != 0){

					// TODO control de errores
					Fruit fruit = fruitManager.getFruit(fruitNumber);
					fruit.setPosition(new Position(j, i));

					fruits.add(new Fruit(fruit.getName(), fruit.getPosition()));
				}
			}

		}

		return fruits;
	}
	public static ArrayList<ArrayList<Fruit>> loadFruits(String[] fruitPaths){

		ArrayList<ArrayList<Fruit>> fruits = new ArrayList<>();

		for (String path : fruitPaths) {
			fruits.add(loadFruitLayer(path));
		}

		return fruits;

	}

	// TODO
	public static ArrayList<Enemy> loadEnemies(String enemiesPath) {

		readTxtFile(enemiesPath);
		Vector<Vector<Integer>> numbers = strVectorToIntVector(readLines);

		EnemyManager enemyManager = new EnemyManager();
		ArrayList<Enemy> enemies = new ArrayList<>();

		int enemyNumber;
		int row = numbers.size();

		// TODO control de errores para el tamaño de la matriz
		int col = numbers.get(1).size();

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				enemyNumber = numbers.get(i).get(j);

				if (enemyNumber != 0){

					// TODO control de errores para el hashmap de EnemyManager

					Enemy enemy = enemyManager.getEnemy(enemyNumber);

					// Aqui la logica de copiado del objeto sin hacer referencia a la misma dirección de memoria que estoy obteniendo

					// luego se añade al array de enemies

				}
			}

		}

		return new ArrayList<>();
	}







	/**
	 * Reads a .txt file
	 * @param path file to read
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
			System.out.println("Error en la lectura de archivo de texto");
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

			object = manejadorDeLectura.readObject();

			manejadorDeLectura.close();

		} catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return object;
	}

}