import Characters.Enemy;
import business.Direction;
import business.Position;

import java.util.ArrayList;

public class Level{

	private Map map;

	private Position playerInitialPosition;

	private ArrayList<Enemy> enemies;
	private ArrayList<Fruit> fruits;

	public Level(String mapPath) {

		// map = DataManager.loadMap("res/maps/map01.txt");

		map = new Map();
		playerInitialPosition = new Position(1,1);

		enemies = new ArrayList<Enemy>();
		fruits = new ArrayList<Fruit>();

	}

	// TODO
	public Position getPlayerInitialPosition(){
		return playerInitialPosition;
	}

	/*
	//TODO
	private Position loadInitialPosition(){
		Position position = new Position(3,3);

		return position;
	}

	 */

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

	private boolean comparePositions(Position p1, Position p2){
		return p1 == p2;
	}

	public boolean isThereAnIce(Direction direction) {
		return false;
	}


}