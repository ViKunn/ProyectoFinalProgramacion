package business;

import business.characters.BlueCow;
import business.characters.Enemy;
import business.characters.Player;
import business.managers.CollisionChecker;
import business.managers.LevelManager;

public class GameLogic  implements Runnable {

	private Player player;
	private Level level;
	private boolean running;
	private int numLevel;
	private CollisionChecker collisionChecker;
	private Thread threadLevel;

	public GameLogic(int numLevel){

		LevelManager levelManager = new LevelManager();
		this.numLevel = numLevel;
		level = levelManager.getLevel(this.numLevel);
		level = levelManager.getLevel(1);


		player = new Player(level.getPlayerInitialPosition());
		running = true;

		collisionChecker = new CollisionChecker(level.getMap());

		level.sendPositionPlayer(player.getPosition());

		threadLevel = new Thread(this);

		startThread();

	}

	private void startThread() {
		threadLevel.start();
	}
	public void movePlayer(Direction direction){


		player.changeDirection(direction);

		if (isCollidingWithABlock(direction)){
			System.out.println("No se puede mover porque hay un bloque");
			return;
		}

		player.move(direction);
		level.sendPositionPlayer(player.getPosition());

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
		return running;
	}

	@Override
	public void run() {
		while(this.running){
			for(Enemy allEnemies: level.getEnemies()){
				if(allEnemies instanceof BlueCow){
					((BlueCow) allEnemies).follow();
				}else{
					allEnemies.move(allEnemies.getDirection());
				}
			}
			try {
				Thread.sleep(500); // Esperar un medio segundo entre cada movimiento
			}catch (InterruptedException e){
				// Manejar interrupciones del hilo si es necesario
				e.printStackTrace();
			}
			if(level.isCollidingWithAnEnemy(player.getPosition())){
				player.die();
				running = false;

				System.out.println("TE MORISTE!!");
				System.out.println("wuruwrur, me muero por thread");

				break;
			}
			if (isCollidingWithAFruit()){
				level.decreaseFruitCounter(player.getPosition());
				System.out.println("Comiste una fruta!!");

				break;
			}

			if (level.fruitsEqualZero()){
				System.out.println("Felicidades!! Pasaste de nivel!!");
				level.setUnlocked(true);
				running = false;
				break;
			}
			level.isCollidingBetweenEnemies();
		}
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