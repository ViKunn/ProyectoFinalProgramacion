package business;

import business.entities.Direction;
import business.entities.Position;
import business.entities.enemies.BlueCow;
import business.entities.enemies.CarlosA;
import business.entities.enemies.Enemy;
import business.entities.Player;
import business.level.Level;
import business.level.map.Map;
import business.managers.CollisionChecker;
import business.managers.LevelManager;
import presentation.states.FinishGameWindow;
import presentation.states.PlayerDieWindow;

import java.awt.*;

public class GameLogic  implements Runnable {

	private final Player player;
	private Level level;
	private final LevelManager levelManager;
	private boolean running;
	private CollisionChecker collisionChecker;
	private Thread levelThread;
	private int levelNum;

	public GameLogic(){

		player = new Player(2);
		levelManager = new LevelManager();

	}

	public void startThread() {
		starThread();
	}

	public void startLevel(int levelNum){
		this.levelNum = levelNum;
		level = levelManager.getLevel(this.levelNum);
		collisionChecker = new CollisionChecker(level.getMap());

		player.setPosition(level.getPlayerInitialPosition(1));
		level.sendPositionPlayer(player.getPosition());
		running = true;
	}

	public void movePlayer(Direction direction){

		player.changeDirection(direction);

		if (isCollidingWithABlock(direction)){
			System.out.println("No se puede mover porque hay un bloque");
			return;
		}

		player.move(direction);

		if(isCollidingPlayerWithAnEnemy()){
			player.die();
			return;
		}

		level.sendPositionPlayer(player.getPosition());

		if (isCollidingWithAFruit()){
			player.increaseScore(level.getFruitScore(player.getPosition()));
			level.decreaseFruitCounter(player.getPosition());
			System.out.println("Comiste una fruta!!");
		}

		if (level.fruitsEqualZero()){
			System.out.println("Felicidades!! Pasaste de nivel!!");
			this.levelNum++;
			if (levelNum <= levelManager.getNumLevel()) {
				nextLevel(levelNum);
			}else {
				running = false;
				FinishGameWindow finishGameWindow = new FinishGameWindow();
				finishGameWindow.setVisible(true);
			}
		}

	}

	private void nextLevel(int levelNum) {
		startLevel(levelNum);
		running = true;

	}

	public void playerActivatePowerUp(){
		player.powerUpIce(level.getMap());
		System.out.println("Se ejecuto los poderes");
	}

	private boolean isCollidingPlayerWithAnEnemy() {
		return level.isCollidingWithAnEnemy(player.getPosition());
	}
	private boolean isCollidingWithABlock(Direction direction) {
		return collisionChecker.frontBlockIsSolid(direction, player.getPosition());
	}
	private boolean isCollidingWithAFruit() {
		return level.isCollidingWithAFruit(player.getPosition());
	}
	public boolean isRunningAndAlive(){
		return player.isAlive() && running;
	}

	@Override
	public String toString() {

		Map map = level.getMap();

		for (int row = 0; row < map.getMapSizeY(); row++) {
			for (int col = 0; col < map.getMapSizeX(); col++) {

				Position position = new Position(col , row);

				if (isCollidingPlayerWithAnEnemy()){
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

	public Score getScorePlayerWhenFinish() {
		return player.getScore();
	}

	public void restartPlayerScore() {
		player.restartScore();
	}

	@Override
	public void run() {

		do {

			synchronized (this) {
				while (!isRunningAndAlive()) {
					try {
						wait(); // Esperar hasta que running sea verdadero
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			do{

				for(Enemy enemy: level.getEnemies()){

					if(enemy instanceof BlueCow){
						((BlueCow) enemy).follow();

					}else if (enemy instanceof CarlosA){
						((CarlosA) enemy).follow();
					}
					else{
						enemy.move(enemy.getDirection());
					}
				}

				if(level.isCollidingWithAnEnemy(player.getPosition())){
					player.die();
					//running = false;
					PlayerDieWindow playerDieWindow = new PlayerDieWindow();
					playerDieWindow.setVisible(true);

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
				while(!(running)){
					// Se va a pusar el hilo un momento para poner pausa
				}
			} while (isRunningAndAlive());

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (isRunningAndAlive());
	}

	public void restartGame() {
		synchronized (this) {
			running = true;
			notify();
		}
	}

	public void pauseGame() {
		running = false;
	}
	public void starThread(){
		levelThread = new Thread(this);
		levelThread.start();
	}

	// TODO
	public void update() {

		//player.update(); // --> actualizar posiciones de player
		level.update(); // --> actualizar posiciones de enemigos y frutas

	}

	public void draw(Graphics2D g2, int tileSize){

		level.draw(g2, tileSize);
		player.draw(g2, tileSize);
		//level.getFru

	}


}