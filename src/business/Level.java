package business;

import business.characters.*;
import business.managers.CollisionChecker;
import data.DataManager;

import java.util.ArrayList;

public class Level {

	private Map map;
	private ArrayList<Enemy> enemies;
	private ArrayList<ArrayList<Fruit>> fruits;
	private boolean locked;
	private int runningFruitLayer;

	// enemigo quemado;
	private Enemy troll1;
	private Enemy troll2;
	private BlueCow blueCow;

	public Level(String mapPath, String playerInitialPositionPath, String enemiesPath, String ... fruitsPath){

		locked = false;

		map     = DataManager.loadMap(mapPath);
		// enemies = DataManager.loadEnemies(enemiesPath);

		// TODO control de errores en caso de que no reciba ninguna fruta
		fruits  = DataManager.loadFruits(fruitsPath);

		// DOUBT: check
		runningFruitLayer = 0;

		// TODO ????

		/***************************************************/
		// burned
		enemies = new ArrayList<Enemy>();

		troll1 = new Troll();
		troll1.setPosition(new Position(3,3));
		troll1.setDirection(Direction.DOWN);
		troll1.setCollisionChecker(new CollisionChecker(map));
		// troll2 = new Troll(new Position(5,5), Direction.UP, new CollisionChecker(map));

		troll2 = new Troll();
		troll2.setPosition(new Position(3,10));
		troll2.setDirection(Direction.UP);
		troll2.setCollisionChecker(new CollisionChecker(map));

		enemies.add(troll1);
		enemies.add(troll2);

		blueCow = new BlueCow();
		blueCow.setPosition(new Position(12,6));
		blueCow.setDirection(Direction.UP);
		blueCow.setCollisionChecker(new CollisionChecker(map));
		enemies.add(blueCow);
		/************************************/


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
	public boolean isCollidingWithAFruit(Position playerPosition) {

		for (Fruit fruit: getFruitLayer(runningFruitLayer)) {

			if(fruit.getPosition().equals(playerPosition)){
				return true;
			}
		}

		return false;
	}

	public boolean isCollidingWithAnEnemy(Position position) {

		for (Enemy enemy: enemies) {
			if(enemy.getPosition().equals(position)){
				return true;
			}
		}

		return false;

	}
	public void isCollidingBetweenEnemies() {
		for(int i =0; i < enemies.size(); i++){
			for(int j =0; j< enemies.size(); j++){
				if(enemies.get(i).getPosition().equals(enemies.get(j).getPosition())){
					enemies.get(i).changeContraryDirection();
					enemies.get(j).changeContraryDirection();
				}
			}
		}
	}


	public void setLocked(boolean locked){
		this.locked = locked;
	}

	public void sendPositionPlayer(Position position) {
		blueCow.passPositionToFollow(position);
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public int getFruitScore(Position position) {

		ArrayList<Fruit> fruitLayer;
		fruitLayer = getFruitLayer(runningFruitLayer);
		//fruitLayer = new ArrayList<>(getFruitLayer(runningFruitLayer)); //TODO SE PODRÍA CAMBIAR A PUNTEROS

		for (Fruit fruit: fruitLayer) {
			if (fruit.getPosition().equals(position)) {
				return fruit.getScore();
			}
		}

		return 0;

	}

}