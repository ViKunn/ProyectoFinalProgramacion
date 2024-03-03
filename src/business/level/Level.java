package business.level;

import business.entities.Position;
import business.entities.enemies.BlueCow;
import business.entities.enemies.Enemy;
import business.entities.fruits.Fruit;
import business.level.map.Map;
import business.managers.CollisionChecker;
import data.DataManager;

import java.util.ArrayList;

public class Level {

	private Map map;
	private ArrayList<Enemy> enemies;
	private ArrayList<ArrayList<Fruit>> fruits;
	private ArrayList<Position> playersPositions;
	private boolean locked;
	private int runningFruitLayer;

	public Level(String mapPath, String playerInitialPositionPath, String enemiesPath, String ... fruitsPath){

		locked = true;

		map     = DataManager.loadMap(mapPath);
		enemies = DataManager.loadEnemies(enemiesPath);
		setEnemiesCollisionChecker(new CollisionChecker(map));

		playersPositions = DataManager.loadPositions(playerInitialPositionPath);

		fruits  = DataManager.loadFruits(fruitsPath);

		runningFruitLayer = 0;
	}

	private void setEnemiesCollisionChecker(CollisionChecker collisionChecker){
		for (Enemy enemy : enemies) {
			enemy.setCollisionChecker(collisionChecker);
		}
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

	public Position getPlayerInitialPosition(int player){

		if (playersPositions.isEmpty()){

			// TODO posiciones por defecto o que no permita en caso de ser null
		}

		return playersPositions.get(player - 1);
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
					enemies.get(i).changeToOpositeDirection();
					enemies.get(j).changeToOpositeDirection();
				}
			}
		}
	}


	public void setLocked(boolean locked){
		this.locked = locked;
	}

	// TODO tienen que corregir esto sin quemar blueCow
	public void sendPositionPlayer(Position position) {

		for (Enemy enemy : enemies) {
			if (enemy instanceof BlueCow){
				((BlueCow) enemy).passPositionToFollow(position);
			}
		}


		// blueCow.passPositionToFollow(position);
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public int getFruitScore(Position position) {

		ArrayList<Fruit> fruitLayer;
		fruitLayer = getFruitLayer(runningFruitLayer);

		for (Fruit fruit: fruitLayer) {
			System.out.println(fruit.getScore());
			if (fruit.getPosition().equals(position)) {
				return fruit.getScore();
			}
		}
		return 0;
	}
}