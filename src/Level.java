import Characters.Enemy;
import business.Direction;
import business.Position;

import java.util.ArrayList;
import java.util.Random;

public class Level{

	private Map map;

	private ArrayList<Enemy> enemies;
	private ArrayList<Fruit> fruits;

	public Level(String mapPath) {

		map = DataManager.loadMap("res/maps/map01.txt");

		enemies = new ArrayList<Enemy>();
		fruits = new ArrayList<Fruit>();

	}

	// TODO posición predeterminada o posición random?
	public Position getPlayerInitialPosition(){

		ArrayList<Position> enemyPositions = new ArrayList<>();
		for (Enemy enemy : enemies) {
			enemyPositions.add(enemy.getPosition());
		}

		ArrayList<Position> freeMapPositions = map.getFreePositions();

		ArrayList<Position> freePositions = new ArrayList<>();
		for (Position enemyPosition: enemyPositions){
			freeMapPositions.remove(enemyPosition);
		}
		freePositions = freeMapPositions;


		Position position = freePositions.get(1);
		return position;

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

		Block block = map.getBlock(position);

		return block.isSolid();
	}

	public boolean isThereAnIce(Direction direction) {
		return false;
	}


	private boolean comparePositions(Position p1, Position p2){
		return p1 == p2;
	}

}