package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

	GamePanel gamePanel;
	Tile[] tile;

	int[][] mapTileNum;

	public TileManager(GamePanel gamePanel){

		this.gamePanel = gamePanel;

		tile = new Tile[10];    // 10 kinds of tiles
		mapTileNum = new int[gamePanel.getMaxScreenCol()][gamePanel.getMaxScreenRow()];

		loadMap("/BadIceCream/maps/map02.txt");
		getTileImage();

	}

	private void getTileImage(){
		try {

			tile[0] = new Tile();
			tile[1] = new Tile();
			tile[2] = new Tile();
			tile[3] = new Tile();
			tile[4] = new Tile();
			tile[5] = new Tile();


			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/tiles/grass.png"));
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/tiles/earth.png"));
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/tiles/sand.png"));


			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/tiles/wall.png"));
			tile[1].colisionable = true;

			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/tiles/water.png"));
			tile[2].colisionable = true;

			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/tiles/tree.png"));
			tile[4].colisionable = true;


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void loadMap(String filePath){

		try {

			InputStream inputStream = getClass().getResourceAsStream(filePath);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			int col = 0;
			int row = 0;

			while ((col < gamePanel.getMaxScreenCol()) &&
					(row < gamePanel.getMaxScreenRow())) {

				String line = bufferedReader.readLine();

				while (col < gamePanel.getMaxScreenCol()) {
					String[] numbers = line.split("\t");

					int num = Integer.parseInt(numbers[col]);

					mapTileNum[col][row] = num;
					col++;
				}

				if (col == gamePanel.getMaxScreenCol()){
					col = 0;
					row ++;
				}

			}

			bufferedReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getMapTileNumber(int col, int row){
		return mapTileNum[col][row];
	}
	public Tile getTile(int number){
		try {
			return tile[number];
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void draw(Graphics2D graphic2D){
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;

		while ((col < gamePanel.getMaxScreenCol()) &&
				(row < gamePanel.getMaxScreenRow())){

			int tileNum = mapTileNum[col][row];
			graphic2D.drawImage(tile[tileNum].image, x,y, gamePanel.getTileSize(), gamePanel.getTileSize(), null);

			col ++;
			x+= gamePanel.getTileSize();

			if (col == gamePanel.getMaxScreenCol()){

				col = 0;
				x = 0;

				row ++;
				y += gamePanel.getTileSize();
			}

		}
	}

}