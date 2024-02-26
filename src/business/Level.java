package business;

import business.characters.*;
import business.managers.CollisionChecker;
import data.DataManager;

import java.util.ArrayList;

public class Level {

	private Map map;

	// private fruit layers;
	// won o passed o finished

	// TODO disminuir las frutas cada que recoge jeje
	private ArrayList<Enemy> enemies;
	private ArrayList<ArrayList<Fruit>> fruits;


	// TODO consider
	private ArrayList<Position> fruitPositions;

	// enemigo quemado;
	private Enemy troll1;

	public Level(String mapPath, String fruitsPath) {

		map = DataManager.loadMap(mapPath);
		// enemies = DataManager.loadEnemies(enemiesPath);

		fruits = DataManager.loadFruits(fruitsPath);
		Thread threadEnemy = null;

		// burned
		enemies = new ArrayList<Enemy>();

		troll1 = new Troll(new Position(3,3), Direction.DOWN, new CollisionChecker(map));
		// troll2 = new Troll(new Position(5,5), Direction.UP, new CollisionChecker(map));
		enemies.add(troll1);
		/*BlueCow blueCow = new BlueCow(new Position(15,15), Direction.UP, new CollisionChecker(map));
		enemies.add(BlueCow); */

		for (Enemy enemy : enemies){
			threadEnemy = new Thread((Runnable) enemy);
		}
		threadEnemy.start();

	}

	// TODO inicializar correctamente la posición de player
	public Position getPlayerInitialPosition(){
		return new Position(2,2);
	}



	public boolean isCollidingWithAnEnemy(Position position) {

		for (Enemy enemy: enemies) {
			if(enemy.getPosition().equals(position)){
				return true;
			}
		}

		return false;

	}
	public boolean isCollidingWithAFruit(Position playerPosition) {

		for (Fruit fruit: fruits) {

			if(fruit.getPosition().equals(playerPosition)){
				return true;
			}
		}

		return false;
	}

	public Map getMap() {
		return map;
	}
	private Fruit getFruit(Position position){

		for (Fruit fruit: fruits) {
			if (fruit.getPosition().equals(position)){
				return fruit;
			}
		}

		return null;
	}


	public void decreaseFruitCounter(Position position) {
		Fruit fruit = getFruit(position);
		fruits.remove(fruit);
	}

	public boolean fruitsEqualZero() {
		return fruits.isEmpty();
	}
}