import business.Position;

import java.util.Vector;

public class Map {

	private Block[][] blocks;

	private int mapSizeX;
	private int mapSizeY;

	public Map(Vector<Vector<Integer>> numbers, int mapSizeX, int mapSizeY) {

		this.mapSizeX = mapSizeX;
		this.mapSizeY = mapSizeY;

		blocks = loadBlocks(numbers);

		System.out.println(":)");

	}

	//
	public Map(){

		blocks = new Block[][]{ {new Block("", false), new Block("", false), new Block("", true)},
								{new Block("", false), new Block("", false), new Block("", true)},
								{new Block("", true), new Block("", true), new Block("", true)}};

	}

	public Block getBlock(Position position){
		return blocks[position.getX()][position.getY()];
	}

	// TODO para poner hielo se actualiza el mapa
	public void putIce(int direction, int x, int y){
		// TODO
	}

	private Block[][] loadBlocks(Vector<Vector<Integer>> numbers){

		Block[][] blocks = new Block[mapSizeY][mapSizeX];

		BlockManager blockManager = new BlockManager();
		int blockNumber;

		for (int i = 0; i < numbers.size(); i++) {

			for (int j = 0; j < numbers.get(i).size(); j++) {

				blockNumber = numbers.get(i).get(j);

				try {
					blocks[i][j] = blockManager.getBlock(blockNumber);

				} catch (ArrayIndexOutOfBoundsException e){
					System.out.println("Error en los archivos de mapa");
					e.printStackTrace();
				}

			}
		}

		return blocks;

	}

}