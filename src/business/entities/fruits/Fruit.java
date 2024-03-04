package business.entities.fruits;

import business.entities.Position;
import business.Score;
import business.entities.Entity;

import java.awt.*;

public class Fruit extends Entity {

	private final String name;
	private final Score fruitScore;


	public Fruit(String name, Score score) {
		this.name = name;
		fruitScore = score;
	}

	public Fruit(String name, Position position, Score score) {
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

	public void draw(Graphics2D g2, int tileSize) {
		// TODO
	}

}