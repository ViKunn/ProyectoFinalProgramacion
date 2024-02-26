package business.managers;

import business.Level;

import java.util.HashMap;

public class LevelManager {

	private static HashMap<Integer, Level> levels;

	public LevelManager() {
		levels = new HashMap<>();
		levels.put(1, new Level("res/levels/level1/map01.txt", "res/levels/level1/fruitPositions.txt"));

	}

	public static Level getLevel(int level) {
		return levels.get(level);
	}


}