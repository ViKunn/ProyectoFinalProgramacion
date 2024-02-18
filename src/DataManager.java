import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class DataManager {

	private static ArrayList<String> lines = new ArrayList<>();

	// map
	public static Map loadMap(String path) {

		Vector<Vector<Integer>> numbers = strVectorToIntVector();
		readFile(path);

		Map map = new Map(numbers, 18, 18);
		return map;
	}

	private static Vector<Vector<Integer>> strVectorToIntVector(){

		Vector<Vector<Integer>> lines = new Vector<>();

		for (String line : DataManager.lines) {

			Vector<Integer> lineIntegers = new Vector<>();
			String[] lineNumbers = DataManager.lines.get(1).split("\t");

			int counter = 0;

			for (int num :	lineIntegers) {
				num = Integer.parseInt(lineNumbers[counter]);
				lineIntegers.add(num);

				counter++;
			}

			counter = 0;

			lines.add(lineIntegers);

		}

		/*
		for (int i = 0; i < lines.size() - 1; i++) {

		}

		 */

		return lines;
	}


	// read File
	private static void readFile(String path){

		lines.clear();

		String line;

		try {

			FileReader fileReader = new FileReader(path);
			BufferedReader reader = new BufferedReader(fileReader);

			do {

				line = reader.readLine();
				lines.add(line);

			} while (line != null);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}