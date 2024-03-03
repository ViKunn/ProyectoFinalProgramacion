package business.level.map;

import data.DataManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Block {

	private String name;
	private BufferedImage image;
	private final boolean solid;

	public Block(String name, BufferedImage image, boolean solid) {
		this.name = name;
		this.image = image;
		this.solid = solid;
	}


	public BufferedImage getImage() {
		return image;
	}

	public boolean isSolid() {
		return solid;
	}

	@Override
	public String toString() {
		return name;
	}

}