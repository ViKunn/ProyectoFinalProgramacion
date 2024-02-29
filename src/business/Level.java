package business;

import business.characters.*;
import business.managers.CollisionChecker;
import data.DataManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Level {

	private Map map;
	private ArrayList<Enemy> enemies;
	private ArrayList<ArrayList<Fruit>> fruits;
	private boolean unlocked;

	private int runningFruitLayer;



	// enemigo quemado;
	private Enemy troll1;
	private BlueCow blueCow;

	// TODO
	public Level(String mapPath, String playerInitialPositionPath, String enemiesPath, String ... fruitsPath){

		unlocked = false;

		map     = DataManager.loadMap(mapPath);
		enemies = DataManager.loadEnemies(enemiesPath);
		fruits  = DataManager.loadFruits(fruitsPath);

		// DOUBT: check
		runningFruitLayer = 0;

		// TODO ???
		Thread threadEnemy = null;
		enemies = new ArrayList<Enemy>();

		troll1 = new Troll();
		troll1.setPosition(new Position(3,3));
		troll1.setDirection(Direction.DOWN);
		troll1.setCollisionChecker(new CollisionChecker(map));
		// troll2 = new Troll(new Position(5,5), Direction.UP, new CollisionChecker(map));
		enemies.add(troll1);
		blueCow = new BlueCow();
		blueCow.setPosition(new Position(12,6));
		blueCow.setDirection(Direction.UP);
		blueCow.setCollisionChecker(new CollisionChecker(map));
		enemies.add(blueCow);

		for (Enemy enemy : enemies){
			threadEnemy = new Thread((Runnable) enemy);
			threadEnemy.start();
		}

	}

	public Level(String mapPath, boolean unlocked, String ... fruitsPath) {

		unlocked = false;

		map = DataManager.loadMap(mapPath);

		// enemies = DataManager.loadEnemies(enemiesPath);
		fruits = DataManager.loadFruits(fruitsPath);
		runningFruitLayer = 0;


		// TODO ????
		// ENEMIES
		Thread threadEnemy = null;

		// burned
		enemies = new ArrayList<Enemy>();

		troll1 = new Troll();
		troll1.setPosition(new Position(3,3));
		troll1.setDirection(Direction.DOWN);
		troll1.setCollisionChecker(new CollisionChecker(map));
		// troll2 = new Troll(new Position(5,5), Direction.UP, new CollisionChecker(map));
		enemies.add(troll1);
		blueCow = new BlueCow();
		blueCow.setPosition(new Position(12,6));
		blueCow.setDirection(Direction.UP);
		blueCow.setCollisionChecker(new CollisionChecker(map));
		enemies.add(blueCow);

		for (Enemy enemy : enemies){
			threadEnemy = new Thread((Runnable) enemy);
			threadEnemy.start();
		}

	}

	// FIXME inicializar correctamente la posición de player
	public Position getPlayerInitialPosition(){
		return new Position(2,2);
	}


	public Map getMap() {
		return map;
	}
	private Fruit getFruit(Position position, int runningFruitLayer){

		for (Fruit fruit: getFruitLayer(runningFruitLayer)) {

			if (fruit.getPosition().equals(position)){
				return fruit;
			}
		}

		return null;
	}
	private ArrayList<Fruit> getFruitLayer(int runningFruitLayer) {

		try {
			return fruits.get(runningFruitLayer);
		} catch (Exception e){
			return new ArrayList<>();
		}

	}



	public void decreaseFruitCounter(Position position) {

		Fruit fruit = getFruit(position, runningFruitLayer);
		getFruitLayer(runningFruitLayer).remove(fruit);

	}
	private boolean fruitLayerIsEmpty(int runningFruitLayer) {
		return getFruitLayer(runningFruitLayer).isEmpty();
	}
	public boolean fruitsEqualZero() {

		if (fruitLayerIsEmpty(runningFruitLayer)){
			fruits.remove(runningFruitLayer);
		}

		return fruits.isEmpty();
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

		for (Fruit fruit: getFruitLayer(runningFruitLayer)) {

			if(fruit.getPosition().equals(playerPosition)){
				return true;
			}
		}

		return false;
	}

	// TODO check
	public void setUnlocked(boolean unlocked){
		this.unlocked = unlocked;
	}

	public void sendPositionPlayer(Position position) {
		blueCow.passPositionToFollow(position);
	}

}