package business.level.map;

import java.awt.image.BufferedImage;

public class Ice extends Block{

	private boolean breakable;

	public Ice(String name, BufferedImage imagePath, boolean solid, boolean breakable) {

		super(name, imagePath, solid);
		this.breakable = breakable;

	}

}