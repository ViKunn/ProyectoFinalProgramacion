package business.level.map;

import business.entities.Direction;
import business.entities.Position;
import business.managers.BlockManager;

import java.awt.*;
import java.util.Vector;

public class Map {

	private final int mapSizeX;
	private final int mapSizeY;

	private final Block[][] blocks;
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
	//Devuelve bloque en posición específica
	public Block getBlock(Position position){
		return blocks[position.getY()][position.getX()];
	}

	//Estable un bloque de hielo en dicha posición x, y
	public void setIce(Position position){
		blocks[position.getY()][position.getX()] = blockManager.getIce();
	}
	//Estable un bloque en dicha posición x, y
	public void setBlock(Position position, int block){
		blocks[position.getY()][position.getX()] = blockManager.getBlock(block);
	}

	//Devuelve true si el bloque en la posición x, y es un bloque de hielo
	public boolean frontBlockIsIce(Direction direction, Position position) {

		Position frontPosition = position.getFrontPosition(direction);
		return getBlock(frontPosition) instanceof Ice;
	}

	//Devuelve true si el bloque en la posición x, y es un bloque solido
	public boolean isBlockSolid(Position frontPosition) {
		return blocks[frontPosition.getY()][frontPosition.getX()].isSolid();
	}

    //Carga bloquees del mapa dependiendo los números proporcionados por el vector
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

	//Representación del mapa mostrando bloque en cada posición, no se imprima unido
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

	public void draw(Graphics2D g2, int tileSize) {

		int col = 0;
		int row = 0;

		int x = 0;
		int y = 0;

		while (col < mapSizeX && row < mapSizeY) {

			Block currentBlock = blocks[row][col];
			g2.drawImage(currentBlock.getImage(), x, y, tileSize, tileSize, null);

			col++;
			x += tileSize;

			if (col == mapSizeX) {
				col = 0;
				x = 0;
				row++;
				y += tileSize;
			}
		}
	}

}