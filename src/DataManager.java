import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class DataManager {

	private static Vector<String> readLines = new Vector<>();

	public static Map loadMap(String path) {

		readTxtFile(path);

		Vector<Vector<Integer>> numbers = strVectorToIntVector(DataManager.readLines);
		Map map = new Map(numbers, 18, 18);

		return map;
	}
	private static Vector<Vector<Integer>> strVectorToIntVector(Vector<String> readLines){

		Vector<Vector<Integer>> rows = new Vector<>();
		Vector<Integer> lineIntegers = new Vector<>();

		int row = 0;

		for (String line : readLines) {

			if (line == null){
				break;
			}

			lineIntegers.clear();

			String[] lineNumbers = DataManager.readLines.get(row).split("\t");
			row++;

			int col = 0;

			for (String number : lineNumbers) {

				//TODO
				int num = Integer.parseInt(lineNumbers[col]);
				lineIntegers.add(num);

				col++;
			}

			col = 0;

			rows.add(lineIntegers);

		}

		return rows;
	}





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

}