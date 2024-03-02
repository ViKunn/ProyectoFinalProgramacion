package business;

import business.characters.Entity;

public class Fruit extends Entity {

	private String name;
	private Score scoreFruit; //TODO el Score está manejado como una clase


	public Fruit(String name) { //TODO Implementar el score como un entero a recibir o un objeto
		this.name = name;
	}
	public Fruit(String name, Position position) { //TODO Implementar el score como un entero a recibir o un objeto
		this.name = name;
		this.position = position;

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

	public Score getScore() {
		return this.scoreFruit;
	}
}