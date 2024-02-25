import business.GameLogic;
import business.Direction;

import java.util.Scanner;
public class Main {

	/*--------------------------------------------------*/

	public static void main(String[] args) {

		GameLogic gameLogic = new GameLogic();

		Scanner scanner = new Scanner(System.in);

		while (gameLogic.isRunning()){

			System.out.println("Ingrese una tecla (w/a/s/d):");
			String tecla = scanner.nextLine();

			switch (tecla) {
				case "w":
					gameLogic.movePlayer(Direction.UP);
					break;
				case "a":
					gameLogic.movePlayer(Direction.LEFT);
					break;
				case "s":
					gameLogic.movePlayer(Direction.DOWN);
					break;
				case "d":
					gameLogic.movePlayer(Direction.RIGHT);
					break;
			//	case "f":
				//	badIceCream.playerBreakIce();
				//	break;
				default:
					System.out.println("Tecla no válida.");
					break;
			}

			System.out.println(gameLogic.getPlayer().getPosition());
		}

		System.out.println("EL NIVEL SE PASÓ!! AQUÍ SE PRESENTARÍA EL MENU PRINCIPAL");

	}
}

/*

// EN LA MAÑANA

TODO presentación en consola
TODO posición frutas
TODO recolección frutas
TODO jugador gana el nivel

TODO Test nivel 1 con frutas

TODO posición monstruos

 */

/*

TODO

- Constructor en TODAS las clases que no tengan :)

- player.breakIce()
- enemy.breakIce()
- player.incrementCollectionCounter()
- level.getNumCollectableElements() // TODO
- player.getFrontPosition()



TODO BUSINESS


- que los enemigos se puedan mover

	level.update(){
		enemy.move(business.Map)
	}

	move(map){

		patron de movimiento

		position.getX()
		position.getY()

		if(map.getBlock(x, y).isSolid()){
			// tomar tal decision
		}

	}

- como se inicializan las posiciones en nivel

- que el jugador pueda recoger las frutas

- badIceCream.passLevel()

*/