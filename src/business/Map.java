package business;

import java.util.ArrayList;
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

	public Block getBlock(Position position){
		return blocks[position.getX()][position.getY()];
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
			return false;
		}
		return true;
	}

	public void setIce(Position position){
		blocks[position.getY()][position.getX()] = (Ice)blockManager.getBlock(1);
	}
	public void setBlock(Position position, int block){
		blocks[position.getY()][position.getX()] = blockManager.getBlock(block);
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

	public int getMapSizeX() {
		return mapSizeX;
	}
	public int getMapSizeY() {
		return mapSizeY;
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

}