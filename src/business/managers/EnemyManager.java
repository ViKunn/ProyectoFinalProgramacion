package business.managers;

import business.entities.enemies.*;

import java.util.HashMap;

public class EnemyManager {

	private final HashMap<Integer, Enemy> enemies;

	public EnemyManager() {

		enemies = new HashMap<>();

		enemies.put(1, new Troll());
		enemies.put(2, new BlueCow());
		enemies.put(3, new CarlosA());
		enemies.put(4, new PatricioZ());

	}

	public Enemy getEnemy(int enemyNumber){
		return enemies.get(enemyNumber);
	}

}