import java.util.HashMap;

public class BlockManager {

	private HashMap<Integer, Block> blocks;

	public BlockManager() {

		blocks = new HashMap<Integer, Block>();

		blocks.put(0, new Block("Nieve",  false));
		blocks.put(1, new Block("Hielo",  true));
		blocks.put(2, new Block("Madera", true));

	}

	public Block getBlock(int blockNumber) {
		return blocks.get(blockNumber);
	}
}