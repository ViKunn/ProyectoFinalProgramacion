package business;

import Characters.Player;

public class GameLogic {

	private Player player;
	private Level level;
	private boolean isRunning;

	private CollisionChecker collisionChecker;

	public GameLogic(){

		LevelManager levelManager = new LevelManager();
		level = levelManager.getLevel(1);
		player = new Player(level.getPlayerInitialPosition());
		isRunning = true;

		collisionChecker = new CollisionChecker(level.getMap());
	}

	public void movePlayer(Direction direction){

		if (collisionChecker.frontBlockIsSolid(direction, player.getPosition())){
			System.out.println("No se puede mover porque hay un bloque");
			return;
		}

		player.move(direction);


		if (isCollidingWithAnEnemy()){
			player.die();
			System.out.println("TE MORISTE!!");
			isRunning = false;
			return;
		}

		/*
		if (isCollidingWithAFruit()){
			System.out.println("Comiste una fruta!!");
			level.decreaseFruitCounter();
		}

		if(level.fruitsEqualZero()){
			System.out.println("Felicidades!! Ganaste!!");
			isRunning = false;
		}
		 */
	}

	public boolean isRunning(){
		return isRunning;
	}


/*	  TODO: AQUÍ SE VA ACTUALIZAR EL MAPA QUE SE MODIFICO POR EL PLAYER 

	public void playerBreakIce(){
		player.breakIce(level.getMap());
		System.out.println("Se ha roto los hielos");
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
	/*
	private boolean isCollidingWithAFruit() {
		if (level.isCollidingWithAFruit(player.getPosition())){
			return true;
		}
		return false;
	}
	*/

	public boolean isRunning(){
		return isRunning;
	}

	// TODO hilo de juego
	public void run(Direction direction){

	}

	// TODO BORRAR AL FINAL
	@Override
	public String toString() {

		Map map = level.getMap();

		for (int row = 0; row < map.getMapSizeY(); row++) {
			for (int col = 0; col < map.getMapSizeY(); col++) {

				if (player.getPosition().equals(level.getEnemyPosition())) {
					System.out.print("X ");

				} else if (player.getPosition().equals(new Position(col , row))){
					System.out.print("P ");

				} else if (level.getEnemyPosition().equals(new Position(col , row))){
					System.out.print("E ");

				} else {
					System.out.print(map.getBlock(new Position(col , row)));
				}
			}
			System.out.println("");
		}

		System.out.println("Player:  " + player.getPosition());


		return "";
	}

}