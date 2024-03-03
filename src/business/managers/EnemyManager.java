package business.managers;

import business.entities.enemies.BlueCow;
import business.entities.enemies.Enemy;
import business.entities.enemies.Troll;

import java.util.HashMap;

public class EnemyManager {

	private static HashMap<Integer, Enemy> enemies;

	public EnemyManager() {

		enemies = new HashMap<>();

		enemies.put(1, new Troll());
		enemies.put(2, new BlueCow());

	}

	public Enemy getEnemy(int enemyNumber){
		return enemies.get(enemyNumber);
	}

}