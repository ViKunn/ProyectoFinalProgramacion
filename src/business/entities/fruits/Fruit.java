package business.entities.fruits;

import business.entities.Position;
import business.Score;
import business.entities.Entity;

public class Fruit extends Entity {

	private String name;
	private Score fruitScore; //TODO el Score está manejado como una clase


	public Fruit(String name, Score score) { //TODO Implementar el score como un entero a recibir o un objeto
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

}