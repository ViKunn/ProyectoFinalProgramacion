package business.level;

import business.entities.Position;
import business.entities.enemies.BlueCow;
import business.entities.enemies.CarlosA;
import business.entities.enemies.Enemy;
import business.entities.fruits.Fruit;
import business.level.map.Map;
import business.managers.CollisionChecker;
import data.DataManager;

import java.awt.*;
import java.util.ArrayList;

public class Level {

	private final Map map;
	private final ArrayList<Enemy> enemies;
	private final ArrayList<ArrayList<Fruit>> fruits;
	private final ArrayList<Position> playersPositions;
	private final int runningFruitLayer;

	public Level(String mapPath, String playerInitialPositionPath, String enemiesPath, String ... fruitsPath){

		map     = DataManager.loadMap(mapPath);
		enemies = DataManager.loadEnemies(enemiesPath);
		setEnemiesCollisionChecker(new CollisionChecker(map));

		playersPositions = DataManager.loadPositions(playerInitialPositionPath);

		fruits  = DataManager.loadFruits(fruitsPath);

		runningFruitLayer = 0;
	}

	//Configura el verificador de colisiones para los enemigos
	private void setEnemiesCollisionChecker(CollisionChecker collisionChecker){
		for (Enemy enemy : enemies) {
			enemy.setCollisionChecker(collisionChecker);
		}
	}

	//Devuelve el mapa de cada nivel
	public Map getMap() {
		return map;
	}

	//Devuelve la fruta en la posición especificada y capa de frutas
	private Fruit getFruit(Position position, int runningFruitLayer){

		for (Fruit fruit: getFruitLayer(runningFruitLayer)) {

			if (fruit.getPosition().equals(position)){
				return fruit;
			}
		}
		return null;
	}

	//Devuelve la capa de frutas actual
	private ArrayList<Fruit> getFruitLayer(int runningFruitLayer) {

		try {
			return fruits.get(runningFruitLayer);
		} catch (Exception e){
			return new ArrayList<>();
		}
	}

	//Devuelve la posición inicial del jugador especificado
	public Position getPlayerInitialPosition(int player){
		return playersPositions.get(player - 1);
	}

	//Decrementa el contador de frutas en la posición específicada
	public void decreaseFruitCounter(Position position) {

		Fruit fruit = getFruit(position, runningFruitLayer);
		getFruitLayer(runningFruitLayer).remove(fruit);

	}

	//Comprueba si la capa de frutas está vacía
	private boolean fruitLayerIsEmpty(int runningFruitLayer) {
		return getFruitLayer(runningFruitLayer).isEmpty();
	}

	//Comprueba si no hay frutas restantes en el nivel
	public boolean fruitsEqualZero() {

		if (fruitLayerIsEmpty(runningFruitLayer)){
			fruits.remove(runningFruitLayer);
		}

		return fruits.isEmpty();
	}

	//Comprueba si el jugador está colisionando con una fruta en su posición
	public boolean isCollidingWithAFruit(Position playerPosition) {

		for (Fruit fruit: getFruitLayer(runningFruitLayer)) {

			if(fruit.getPosition().equals(playerPosition)){
				return true;
			}
		}

		return false;
	}

	//Comprueba si hay una colisión entre el jugador y un enemigo en la posición específicada
	public boolean isCollidingWithAnEnemy(Position position) {

		for (Enemy enemy: enemies) {
			if(enemy.getPosition().equals(position)){
				return true;
			}
		}
		return false;

	}

	//Comprueba si hay una colisión entre el jugador y un enemigo en la posición especificada
	public void isCollidingBetweenEnemies() {
		for(int i =0; i < enemies.size(); i++){
			for (Enemy enemy : enemies) {
				if (enemies.get(i).getPosition().equals(enemy.getPosition())) {
					enemies.get(i).changeToOpositeDirection();
					enemy.changeToOpositeDirection();
				}
			}
		}
	}

	//Envía la posición del jugador a los enemigos que necesitan seguir al player
	public void sendPositionPlayer(Position position) {

		for (Enemy enemy : enemies) {
			if (enemy instanceof BlueCow){
				((BlueCow) enemy).passPositionToFollow(position);
			} else if (enemy instanceof CarlosA){
				((CarlosA) enemy).passPositionToFollow(position);
			}
		}
	}
	//Devuelve la lista de enemigos
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	//Devuelve la puntuación de la fruta en la posición especificada
	public int getFruitScore(Position position) {

		ArrayList<Fruit> fruitLayer;
		fruitLayer = getFruitLayer(runningFruitLayer);

		for (Fruit fruit: fruitLayer) {
			if (fruit.getPosition().equals(position)) {
				System.out.println(fruit.getScore());
				return fruit.getScore();
			}
		}
		return 0;
	}

	//Dibuja los enemigos en el nivel
	private void drawEnemies(Graphics2D g2, int tileSize){

		for (Enemy enemy : enemies) {
			enemy.draw(g2, tileSize);
		}
	}

	//Dibuja las frutas en el nivel
	private void drawFruits(Graphics2D g2, int tileSize){


			for (Fruit fruit : getFruitLayer(runningFruitLayer)) {
				fruit.draw(g2, tileSize);
			}
	}
	//Dibuja el mapa en el nivel
	public void draw(Graphics2D g2, int tileSize) {

		map.draw(g2, tileSize);
		drawFruits(g2, tileSize);
		drawEnemies(g2, tileSize);

	}
	public void update() {

	}
}