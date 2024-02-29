package business;

import business.characters.Entity;

public class Fruit extends Entity {

	private String name;
	private static int scoreFruit = 50;

	public Fruit() {
		position = new Position();
	}

	public Fruit(String name) {
		this.name = name;
	}

	public Fruit(String name, Position position) {
		this.name = name;
		this.position = position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public static int getScoreFruit() {
		return scoreFruit;
	}

}