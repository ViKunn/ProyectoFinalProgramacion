package business.managers;

import business.entities.fruits.Fruit;
import business.Score;

import java.util.HashMap;

public class FruitManager {
	private HashMap<Integer, Fruit> fruits;

	public FruitManager() {

		fruits = new HashMap<>();

		fruits.put(1, new Fruit("S", new Score(30)));  // sandía
		fruits.put(2, new Fruit("U", new Score(40)));  // uvas

	}

	// TODO control de errores
	public Fruit getFruit(int fruitNumber) {
		return fruits.get(fruitNumber);
	}

}