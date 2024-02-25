package business;

import Characters.Player;

public class GameLogic {

	private Player player;
	// private ArrayList<business.Level> levels;
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

		/*
		if (collisionChecker.frontBlockIsSolid(direction, player.getPosition())){
			System.out.println("No se puede mover porque hay un bloque");
			return;
		}

		 */

		if (isCollidingWithABlock()){
			System.out.println("No se puede mover porque hay un bloque");
			return;
		}

		player.move(direction);


		if (isCollidingWithAnEnemy()){
			System.out.println("TE MORISTE!!");
			return;
		}

		/*
		if (isCollidingWithAFruit()){
			System.out.println("Comiste una fruta!!");
			player.incrementCollectionCounter();
		}
		/*
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
		level.uploadMap(player.breakIce(level.getMap()));
		System.out.println("Se ha roto los hielos");
	}

*/


	/*
	private boolean isThereAnIce() {//Aquí necesito que nivel me diga si hay o no (true or false)un hielo en la posición que le mando  ME PREGUNTAN SI NO ENTIENDEN
		// Y que player me mande la posición frontal siguiente (la posición que está mirando de frente)
		return level.isThereAnIce(player.getFrontPosition());
	}



	private boolean isCollidingWithAFruit() { //Estoy en eso

		if (level.isCollidingWithAFruit(player.getPosition())){
			return true;
		}
		return false;
	}
	*/


	private boolean isCollidingWithAnEnemy() {

		if (level.isCollidingWithAnEnemy(player.getPosition())){
			return true;
		}

		return false;
	}

	 */

	private boolean isCollidingWithABlock() {

		if (level.isCollidingWithABlock(player.getPosition())){
			return true;
		}
		return false;
	}


	public Player getPlayer() {
		return player;
	}

	// TODO
	public void run(){



	}



}