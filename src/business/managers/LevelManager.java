package business.managers;

import business.Level;

import java.util.ArrayList;
import java.util.HashMap;

public class LevelManager {

	private static HashMap<Integer, Level> levels;

	public LevelManager() {

		levels = new HashMap<>();



		addLevel1();

	}



	public void addLevel1() {

		String mapPath         = "res/levels/level1/map.txt";
		String playersPosition = "res/levels/level1/players.txt";
		String enemiesPath     = "res/levels/level1/enemies.txt";
		String fruits01        = "res/levels/level1/fruits01.txt" ;
		String fruits02        = "res/levels/level1/fruits02.txt";

		Level level = new Level(mapPath, playersPosition, enemiesPath, fruits01, fruits02);
		levels.put(1, level);

	}

	public void addLevel2() {

		String mapPath         = "res/levels/level2/map.txt";
		String playersPosition = "res/levels/level2/players.txt";
		String enemiesPath     = "res/levels/level2/enemies.txt";
		String fruits01        = "res/levels/level2/fruits01.txt" ;
		String fruits02        = "res/levels/level2/fruits02.txt";

		Level level = new Level(mapPath, playersPosition, enemiesPath, fruits01, fruits02);
		levels.put(1, level);

	}

	public static Level getLevel(int level) {
		return levels.get(level);
	}

}