package data;

import business.entities.Direction;
import business.entities.Position;

import business.entities.fruits.Fruit;
import business.entities.enemies.Enemy;

import business.level.map.Map;

import business.Score;

import business.managers.EnemyManager;
import business.managers.FruitManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class DataManager {

	private static final Vector<String> readLines = new Vector<>();


	public static Map loadMap(String path) {

		readTxtFile(path);
		Vector<Vector<Integer>> numbers = strVectorToIntVector();

		return new Map(numbers, 18, 18);
	}
	private static ArrayList<Fruit> loadFruitLayer(String path) {

		readTxtFile(path);
		Vector<Vector<Integer>> numbers = strVectorToIntVector();

		FruitManager fruitManager = new FruitManager();
		ArrayList<Fruit> fruits = new ArrayList<>();

		int fruitNumber;
		int row = numbers.size();

		for (int i = 0; i < row; i++) {

			int col = numbers.get(i).size();

			for (int j = 0; j < col; j++) {

				fruitNumber = numbers.get(i).get(j);

				if (fruitNumber != 0){

					Fruit fruit = fruitManager.getFruit(fruitNumber);
					fruit.setPosition(new Position(j, i));

					fruits.add(new Fruit(fruit.getName(), fruit.getPosition(), new Score(fruit.getScore())));
				}
			}

		}

		return fruits;
	}
	public static ArrayList<ArrayList<Fruit>> loadFruits(String[] fruitsPaths){

		ArrayList<ArrayList<Fruit>> fruits = new ArrayList<>();

		for (String path : fruitsPaths) {
			fruits.add(loadFruitLayer(path));
		}

		return fruits;

	}
	public static ArrayList<Enemy> loadEnemies(String path) {

		readTxtFile(path);
		Vector<Vector<Integer>> numbers = strVectorToIntVector();

		EnemyManager enemyManager = new EnemyManager();
		ArrayList<Enemy> enemies = new ArrayList<>();

		int enemyNumber;
		int row = numbers.size();

		for (int i = 0; i < row; i++) {

			int col = numbers.get(i).size();

			for (int j = 0; j < col; j++) {

				enemyNumber = numbers.get(i).get(j);

				if (enemyNumber != 0){

					try {

						Enemy enemy = (Enemy) enemyManager.getEnemy(enemyNumber).clone();
						enemy.setPosition(new Position(j, i));

						enemy.setDirection(Direction.DOWN);

						enemies.add(enemy);

					} catch (CloneNotSupportedException e) {
						throw new RuntimeException(e);
					}

				}
			}

		}

		return enemies;

	}

	public static ArrayList<Position> loadPositions(String path){

		ArrayList<Position> positions = new ArrayList<>();

		readTxtFile(path);
		Vector<Vector<Integer>> numbers = strVectorToIntVector();

		for (Vector<Integer> line : numbers) {

			int x = line.get(0);
			int y = line.get(1);

			positions.add(new Position(x, y));

		}

		if (positions.isEmpty()){
			return null;
		}

		return positions;
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
	private static Vector<Vector<Integer>> strVectorToIntVector(){

		Vector<Vector<Integer>> rows = new Vector<>();

		for (int row = 0; row < DataManager.readLines.size(); row++) {

			Vector<Integer> lineIntegers = new Vector<>();

			if (DataManager.readLines.get(row) == null){
				break;
			}

			String[] lineNumbers = DataManager.readLines.get(row).split("\t");

			for (String lineNumber : lineNumbers) {

				int num = Integer.parseInt(lineNumber);
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