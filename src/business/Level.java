package business;

import Characters.Enemy;
import data.DataManager;

import java.util.ArrayList;

public class Level{

	private Map map;

	private ArrayList<Enemy> enemies;
	private ArrayList<Fruit> fruits;

	public Level(String mapPath) {

		map = DataManager.loadMap("res/maps/map01.txt");

		enemies = new ArrayList<Enemy>();
		fruits = new ArrayList<Fruit>();

	}

	/*
	// TODO posición predeterminada de acuerdo con las capas de texto
	public Position getPlayerInitialPosition(){



	}
	 */


	public Position getPlayerInitialPosition(){



		return new Position(2,2);
	}


	public boolean isCollidingWithAnEnemy(Position position) {

		for (Enemy enemy: enemies) {
			if(comparePositions(enemy.getPosition(), position)){
				return true;
			}
		}

		return false;
	}
	public boolean isCollidingWithAFruit(Position position) {

		for (Fruit fruit: fruits) {
			if(comparePositions(fruit.getPosition(), position)){
				return true;
			}
		}

		return false;
	}
	public boolean isCollidingWithABlock(Position position) {
		return map.getBlock(position).isSolid();
	}

	public boolean isThereAnIce(Direction direction) {
		return false;
	}

	private boolean comparePositions(Position p1, Position p2){
		return p1 == p2;
	}

	public void presentarMapa(){
		System.out.println(map);
	}

}