package business.level.map;

import business.entities.Direction;
import business.entities.Position;
import business.managers.BlockManager;

import java.awt.*;
import java.util.Vector;

public class Map {

	private final int mapSizeX;
	private final int mapSizeY;

	private Block[][] blocks;
	BlockManager blockManager;

	public Map(Vector<Vector<Integer>> numbers, int mapSizeX, int mapSizeY) {

		this.mapSizeX = mapSizeX;
		this.mapSizeY = mapSizeY;

		blockManager = new BlockManager();

		blocks = loadBlocks(numbers);
	}

	public int getMapSizeX() {
		return mapSizeX;
	}
	public int getMapSizeY() {
		return mapSizeY;
	}
	public Block getBlock(Position position){
		return blocks[position.getY()][position.getX()];
	}

	public void setIce(Position position){
		blocks[position.getY()][position.getX()] = (Ice)blockManager.getBlock(1);
	}
	public void setBlock(Position position, int block){
		blocks[position.getY()][position.getX()] = blockManager.getBlock(block);
	}

	public boolean frontBlockIsIce(Direction direction, Position position) {

		Position frontPosition = new Position();
		switch (direction) {
			case UP:

				frontPosition = new Position(position.getX(), (position.getY() - 1));
				break;

			case DOWN:
				frontPosition = new Position(position.getX(), (position.getY()) + 1);
				break;

			case LEFT:
				frontPosition = new Position((position.getX() - 1), position.getY());
				break;

			case RIGHT:
				frontPosition = new Position((position.getX() + 1), position.getY());
				break;
		}
		if ((getBlock(frontPosition) instanceof Ice)){
			return true;
		}
		return false;
	}
	public boolean isBlockSolid(Position frontPosition) {
		return blocks[frontPosition.getY()][frontPosition.getX()].isSolid();
	}

	private Block[][] loadBlocks(Vector<Vector<Integer>> numbers) {

		Block[][] loadedBlocks = new Block[mapSizeY][mapSizeX];

		int blockNumber;

		for (int i = 0; i < numbers.size(); i++) {

			for (int j = 0; j < numbers.get(i).size(); j++) {

				blockNumber = numbers.get(i).get(j);

				try {

					loadedBlocks[i][j] = blockManager.getBlock(blockNumber);

				} catch (ArrayIndexOutOfBoundsException e){

					System.out.println("Error en el tamaño de la matriz en los archivos de mapa");
					break;
				}

			}
		}

		return loadedBlocks;

	}

	@Override
	public String toString() {

		for (int row = 0; row < mapSizeY; row++) {
			for (int col = 0; col < mapSizeX; col++) {
				System.out.print(blocks[row][col] + " ");
			}
			System.out.print("\n");
		}

		return "";
	}


	public void draw(Graphics2D g2) {

		int col = 0;
		int row = 0;

		int x = 0;
		int y = 0;

		int tileSize = 10;

		while (col < mapSizeX && row < mapSizeY){

			g2.drawImage(blocks[row][col].getImage(), x, y, tileSize, tileSize, null);

			col++;
			x += tileSize;

			if (col == mapSizeX){
				col = 0 ;
				x = 0;
				row++;
				y += tileSize;
			}

		}

	}

	/*
	    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < gp.maxScreenCol && row < gp.maxScreenRow){
            int tileNum = mapTileNum[col][row];
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;
            if (col == gp.maxScreenCol){
                col = 0 ;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }

	 */


}