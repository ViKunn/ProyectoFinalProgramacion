package business.managers;

import business.level.Level;

import java.util.HashMap;

public class LevelManager {

	private final HashMap<Integer, Level> levels;

	public LevelManager() {

		levels = new HashMap<>();

		addLevel1();
		// addLevel2();
		addLevelEPN();
		addLevelPolitecnico();

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
		levels.put(2, level);

	}

	public void addLevelEPN() {

		String mapPath         = "res/levels/levelEPN/enemies.txt";
		String playersPosition = "res/levels/levelEPN/players.txt";
		String enemiesPath     = "res/levels/levelEPN/enemies.txt";
		String fruits01        = "res/levels/levelEPN/fruits01.txt" ;

		Level level = new Level(mapPath, playersPosition, enemiesPath, fruits01);
		levels.put(3, level);

	}

	public void addLevelPolitecnico() {

		String mapPath         = "res/levels/levelPolitecnico/map.txt";
		String playersPosition = "res/levels/levelPolitecnico/players.txt";
		String enemiesPath     = "res/levels/levelPolitecnico/enemies.txt";
		String fruits01        = "res/levels/levelPolitecnico/fruits01.txt" ;
		String fruits02        = "res/levels/levelPolitecnico/fruits02.txt";

		Level level = new Level(mapPath, playersPosition, enemiesPath, fruits01, fruits02);
		levels.put(3, level);

	}

	public Level getLevel(int level) {
		return levels.get(level);
	}

	public int getNumLevel() {
	return levels.size();
	}
}