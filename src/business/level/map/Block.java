package business.level.map;


import java.awt.image.BufferedImage;

public class Block {

	private final String name;
	private final BufferedImage image;
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