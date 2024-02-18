import Characters.Player;
import business.Direction;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BadIceCream {

	private Player player;

	// private ArrayList<Level> levels;

	private Level level;


	public BadIceCream(){
		level = new Level("");
		player = new Player(level.getPlayerInitialPosition());
	}

	//
	public void movePlayer(Direction direction){

		if (isCollidingWithABlock()){
			System.out.println("No se puede mover porque hay un bloque");
			return;
		}

		player.move(direction);

		/*
		if (isCollidingWithAnEnemy()){
			System.out.println("TE MORISTE!!");
			return;
		}
		if (isCollidingWithAFruit()){
			System.out.println("Comiste una fruta!!");
			player.incrementCollectionCounter();
		}
		if(player.getCollectionCounter() == level.getNumOfCollectibleElements()){
			System.out.println("Felicidades!! Ganaste!!");
		}

		 */
	}



/*	  TODO: AQUI HAY QUE CAMBIAR Y ENVIAR EL NIVEL AL PLAYER Y QUE ÉL SE ENCARGE DE ROMPER JEJE

		public void breakIcePlayer(){
		if(isThereAnIce()){ //Aquí necesito que nivel me diga si hay un hielo en la posición que le mando  ME PREGUNTAN SI NO ENTIENDEN
								// Y que player me mande la posición frontal siguiente (la posición que está mirando de frente)
		level.breakIce(player.getDirection(), player.getFrontPosition()); // Nivel, necesito que quites los hielos y pongas nieve :)

		}


		player.breakIce(level);
		enemy.breakIce();

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

	// TODO
	public void run(){



	}



}