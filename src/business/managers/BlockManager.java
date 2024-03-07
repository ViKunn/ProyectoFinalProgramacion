package business.managers;

import business.level.map.Block;
import business.level.map.Ice;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class BlockManager {

	private final HashMap<Integer, Block> blocks;

	public BlockManager() {

		blocks = new HashMap<>();

		blocks.put(0, new Block("- ",                    loadImage("res/images/blocks/snow.png"), false));  // snow
		blocks.put(1, new Ice  ("\u001B[34m* \u001B[0m", loadImage("res/images/blocks/ice.png") , true ));  // ice
		blocks.put(2, new Block("\u001B[31m# \u001B[0m", loadImage("res/images/blocks/iron.png"), true ));  // iron

	}


	public BufferedImage loadImage(String imagePath) {
		try {
			File file = new File(imagePath);
			return ImageIO.read(file);
		} catch (IOException e) {
			throw new RuntimeException("Error al cargar la imagen: " + e.getMessage());
		}
	}

	public Block getBlock(int blockNumber) {
		return blocks.get(blockNumber);
	}
	public Block getIce(){
		return blocks.get(1);
	}


}