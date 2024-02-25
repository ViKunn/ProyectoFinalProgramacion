package business;

import Characters.Enemy;
import Characters.Troll;
import data.DataManager;

import java.util.ArrayList;

public class Level{

	private Map map;

	// private fruit layers;
	// won o passed o finished

	// TODO disminuir las frutas cada que recoge jeje
	private ArrayList<Enemy> enemies;
	private ArrayList<Fruit> fruits;


	// TODO consider
	private ArrayList<Position> fruitPositions;

	// enemigo quemado;
	private Enemy troll1;

	public Level(String mapPath) {

		map = DataManager.loadMap(mapPath);
		enemies = new ArrayList<Enemy>();
		fruits = new ArrayList<Fruit>();


		// burned
		troll1 = new Troll(new Position(3,3), Direction.DOWN, new CollisionChecker(map));
		enemies.add(troll1);

	}

	// TODO posición predeterminada de acuerdo con las capas de texto

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


	// TODO erase
	public Position getEnemyPosition() {
		return troll1.getPosition();
	}

}