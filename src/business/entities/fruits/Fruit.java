package business.entities.fruits;

import business.entities.Position;
import business.Score;
import business.entities.Entity;

import java.awt.*;

public class Fruit extends Entity {

	private final String name;
	private final Score fruitScore;


	public Fruit(String name, BufferedImage bufferedImageFruit, Score score) { // Se usa dentro de fruit manager
		this.name = name;
		fruitScore = score;
	}

	public Fruit(String name, Position position, Score score, BufferedImage bufferedImageFruit) { // para posiciones data manager
		this.name = name;
		this.position = position;
		fruitScore = score;
	}

	public String getName() {
		return name;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getScore() {
		return fruitScore.getTotalScore();
	}


	@Override
	public void draw(Graphics2D g2, int tileSize) {
		BufferedImage image = bufferedImageFruit;
		g2.drawImage(image, this.position.getX() * tileSize, this.position.getY() * tileSize, tileSize, tileSize, null);
	}

	public BufferedImage getBufferedImage() {
		return this.bufferedImageFruit;
	}
}