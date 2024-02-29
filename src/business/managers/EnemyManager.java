package business.managers;

import business.characters.BlueCow;
import business.characters.Enemy;
import business.characters.Troll;

import java.util.HashMap;

public class EnemyManager {

	private static HashMap<Integer, Enemy> enemies;

	public EnemyManager() {

		enemies = new HashMap<>();

		enemies.put(1, new Troll());
		enemies.put(2, new BlueCow());

	}

	// TODO control de errores
	public Enemy getEnemy(int enemyNumber){
		return enemies.get(enemyNumber);
	}

}