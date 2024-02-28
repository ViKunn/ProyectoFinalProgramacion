package business;

import business.characters.Player;
import business.managers.CollisionChecker;
import business.managers.LevelManager;

public class GameLogic {

	private Player player;
	private Level level;
	private boolean isRunning;
	private int numLevel;
	private CollisionChecker collisionChecker;

	public GameLogic(int numLevel){

		LevelManager levelManager = new LevelManager();
		this.numLevel = numLevel;

		level = levelManager.getLevel(this.numLevel);
		level = levelManager.getLevel(1);


		player = new Player(level.getPlayerInitialPosition());
		isRunning = true;

		collisionChecker = new CollisionChecker(level.getMap());
	}

	public void movePlayer(Direction direction){

		player.changeDirection(direction);

		if (isCollidingWithABlock(direction)){
			System.out.println("No se puede mover porque hay un bloque");
			return;
		}

		player.move(direction);
		level.sendPositionPlayer(player.getPosition());

		if (isCollidingWithAnEnemy()){
			player.die();
			System.out.println("TE MORISTE!!");
			isRunning = false;
			return;
		}

		if (isCollidingWithAFruit()){
			level.decreaseFruitCounter(player.getPosition());
			System.out.println("Comiste una fruta!!");
		}

		if (level.fruitsEqualZero()){
			System.out.println("Felicidades!! Pasaste de nivel!!");

			// TODO
			level.setUnlocked(true);
			isRunning = false;
		}
	}
	public void playerPowerUps(){
		player.powerUpIce(level.getMap());
		System.out.println("Se ejecuto los poderes");
	}

	private boolean isCollidingWithAnEnemy() {

		if (level.isCollidingWithAnEnemy(player.getPosition())){
			return true;
		}

		return false;
	}
	private boolean isCollidingWithABlock(Direction direction) {
		return collisionChecker.frontBlockIsSolid(direction, player.getPosition());
	}

	private boolean isCollidingWithAFruit() {

		if (level.isCollidingWithAFruit(player.getPosition())){
			return true;
		}

		return false;
	}

	public boolean isRunning(){
		return isRunning;
	}




	// TODO BORRAR AL FINAL
	@Override
	public String toString() {

		Map map = level.getMap();

		for (int row = 0; row < map.getMapSizeY(); row++) {
			for (int col = 0; col < map.getMapSizeY(); col++) {

				Position position = new Position(col , row);

				if (isCollidingWithAnEnemy()){
					System.out.print("X ");

				} else if (player.getPosition().equals(position)) { //PRESENTA PLAYER
					System.out.print("P ");

				} else if (level.isCollidingWithAnEnemy(position)) { // PRESENTA ENEMIGOS
					System.out.print("E ");

				} else if (level.isCollidingWithAFruit(position)) {  // PRESENTA FRUTAS
					System.out.print("F ");


				} else {
					System.out.print(map.getBlock(new Position(col , row)));
				}

			}

			System.out.print("\n");
		}

		System.out.println("Player:  " + player.getPosition());

		return "";
	}


}