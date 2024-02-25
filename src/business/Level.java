package business;

import Characters.Enemy;
import Characters.Troll;
import data.DataManager;

import java.util.ArrayList;

public class Level{

	private Map map;

	// private fruit layers;

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
	/*
	public Position getPlayerInitialPosition(){

	}
	 */

	// FIXME
	/*
	public Fruit[][] loadFruits(){
		return;
	}
	 */

	public Position getPlayerInitialPosition(){
		return new Position(2,2);
	}

	public boolean isCollidingWithAnEnemy(Position position) {

		return troll1.getPosition().equals(position);

		// FIXME
		/*
		for (Enemy enemy: enemies) {
			if(equalPositions(enemy.getPosition(), position)){
				return true;
			}
		}

		return false;

		 */
	}

	/*
	public boolean isCollidingWithAFruit(Position playerPosition) {

		for (Fruit fruit: fruits) {
			if(comparePositions(fruit.getPosition(), playerPosition)){
				return true;
			}
		}

		return false;
	}
	 */
	public boolean isCollidingWithABlock(Position position) {
		return map.getBlock(position).isSolid();
	}

	private boolean equalPositions(Position p1, Position p2){
		// fixme
		return p1.equals(p2);
	}


	public Map getMap() {
		return map;
	}

	public void presentarMapa(/*recibir entidades para permitir impresión de mapa con entidades*/){
		System.out.println(map);
	}


	// TODO erase
	public Position getEnemyPosition() {
		return troll1.getPosition();
	}
}