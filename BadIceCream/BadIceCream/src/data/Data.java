package data;

import business.BadIceCream;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Data {

	public int[][] loadMap(String filePath, int[][] map, int maxCol, int maxRow){

		int col = 0;
		int row = 0;

		try {

			InputStream inputStream = getClass().getResourceAsStream(filePath);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			while ((col < maxCol ) &&
				   (row < maxRow)){

				String line = bufferedReader.readLine();

				while (col < maxCol ) {
					String[] numbers = line.split("\t");

					int num = Integer.parseInt(numbers[col]);

					map[col][row] = num;
					col++;
				}

				if (col == maxCol){
					col = 0;
					row ++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public void loadMap(String filePath, int[][] map){

		int col = 0;
		int row = 0;

		int unitsX = BadIceCream.getGameUnitsX();
		int unitsY = BadIceCream.getGameUnitsY();

		try {

			InputStream inputStream = getClass().getResourceAsStream(filePath);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			while ((col < unitsX ) &&
					(row < unitsY)){

				String line = bufferedReader.readLine();

				while (col < unitsX ) {
					String[] numbers = line.split("\t");

					int num = Integer.parseInt(numbers[col]);


					map[col][row] = num;
					col++;
				}

				if (col == unitsX){
					col = 0;
					row ++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}