package business.managers;

import business.level.map.Block;
import business.level.map.Ice;

import java.util.HashMap;

public class BlockManager {

	private HashMap<Integer, Block> blocks;

	public BlockManager() {

		blocks = new HashMap<Integer, Block>();

		blocks.put(0, new Block(               "- ",               false));                  // snow
		blocks.put(1, new Ice  ("\u001B[34m" + "* " + "\u001B[0m", true , true));   // ice
		blocks.put(2, new Block("\u001B[31m" + "# " + "\u001B[0m", true ));                   // block

	}

	public Block getBlock(int blockNumber) {
		return blocks.get(blockNumber);
	}

}