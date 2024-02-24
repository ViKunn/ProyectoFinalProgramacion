package business;

import java.util.ArrayList;
import java.util.HashMap;

public class LevelManager {

	private static HashMap<Integer, Level> levels;

	public LevelManager() {
		levels = new HashMap<>();

		levels.put(1, new Level("res/maps/map01.txt"));

	}

	public static Level getLevel(int level) {
		return levels.get(level);
	}
}