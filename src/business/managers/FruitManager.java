package business.managers;

import business.Fruit;

import java.util.HashMap;

public class FruitManager {
	private HashMap<Integer, Fruit> fruits;

	public FruitManager() {

		fruits = new HashMap<>();

		fruits.put(1, new Fruit("S"));  // sandía
		fruits.put(2, new Fruit("U"));  // uvas
	}

	// TODO control de errores
	public Fruit getFruit(int fruitNumber) {
		return fruits.get(fruitNumber);
	}

}