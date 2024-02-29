package business;

import business.characters.Entity;

public class Fruit extends Entity {

	private String name;
	private static int scoreFruit = 50;


	public Fruit(String name) {
		this.name = name;
	}
	public Fruit(String name, Position position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}
	public static int getScoreFruit() {
		return scoreFruit;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return name;
	}

}