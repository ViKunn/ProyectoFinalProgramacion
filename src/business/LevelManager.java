package business;

import java.util.ArrayList;
import java.util.HashMap;

public class LevelManager {

	private static HashMap<Integer, Level> levels;

	public LevelManager() {
		levels = new HashMap<>();

		levels.put(1, new Level("res/levels/level1/map01.txt") /*mandar array enemigos y frutas*/);

	}

	public static Level getLevel(int level) {
		return levels.get(level);
	}


}