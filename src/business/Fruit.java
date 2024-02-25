package business;

import Characters.Entity;

public class Fruit extends Entity {
	private Level level ;
	private boolean collectedFruit;


	public Fruit(Level level) {
		this.level = level;
		collectedFruit = false;
	}

	public void setInitialValues(){
		//position = ;

	}

}