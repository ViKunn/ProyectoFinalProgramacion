package business;

import business.characters.BlueCow;
import business.characters.Enemy;
import business.characters.Player;
import business.managers.CollisionChecker;
import business.managers.LevelManager;

public class GameLogic  implements Runnable {

	private Player player;
	private Level level;
	private LevelManager levelManager;
	private boolean running;
	private CollisionChecker collisionChecker;
	private Thread levelThread;

	public GameLogic(){

		player = new Player();
		levelManager = new LevelManager();

	}

	public void startLevel(int levelNum){

		level = levelManager.getLevel(levelNum);
		collisionChecker = new CollisionChecker(level.getMap());

		player.setPosition(level.getPlayerInitialPosition(1));
		level.sendPositionPlayer(player.getPosition());

		running = true;
		levelThread = new Thread(this);
		levelThread.start();

	}

	public void movePlayer(Direction direction){

		player.changeDirection(direction);

		if (isCollidingWithABlock(direction)){
			System.out.println("No se puede mover porque hay un bloque");
			return;
		}

		player.move(direction);
		level.sendPositionPlayer(player.getPosition());
		if (isCollidingWithAFruit()){
			level.decreaseFruitCounter(player.getPosition());
			player.increaseScore(level.getFruitScore(player.getPosition()));
			System.out.println("Comiste una fruta!!");
		}

		if (level.fruitsEqualZero()){
			System.out.println("Felicidades!! Pasaste de nivel!!");
			level.setLocked(false);
			running = false;
		}

	}
	public void playerActivatePowerUp(){
		player.powerUpIce(level.getMap());
		System.out.println("Se ejecuto los poderes");
	}

	private boolean isCollidingWithAnEnemy() {
		return level.isCollidingWithAnEnemy(player.getPosition());
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
	public boolean isRunningAndAlive(){
		return player.isAlive() && running;
	}

	@Override
	public void run() {
		do {
			for(Enemy enemy: level.getEnemies()){

				// Todo: corregir para que sea unicamente enemy.move()

				if(enemy instanceof BlueCow){
					((BlueCow) enemy).follow();

				} else{
					enemy.move(enemy.getDirection());
				}
			}

			if(level.isCollidingWithAnEnemy(player.getPosition())){

				player.die();
				running = false;

				System.out.println("TE MORISTE!!");
				System.out.println("wuruwrur, me muero por thread");

				break;
			}

			level.isCollidingBetweenEnemies();

			try {

				// Esperar un medio segundo entre cada movimiento
				levelThread.sleep(500);

			} catch (InterruptedException e){

				// Manejar interrupciones del hilo si es necesario
				e.printStackTrace();

			}
		}while(isRunningAndAlive());

	}

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