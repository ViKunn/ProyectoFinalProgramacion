import business.BadIceCream;
import business.Direction;
import com.sun.source.tree.WhileLoopTree;
import java.util.Scanner;
public class Main {

	/*--------------------------------------------------*/

	public static void main(String[] args) {
		// SOLO PROGRA 2 (modo fácil)

		/*

	    //Dado: que existe un player y un enemigo:
        Player player;
        Monstruo monstruo;

        //Cuando: Estos dos se encuentran en la misma posición el player muere
        player = new Player(2,2);
        monstruo = new Monstruo(2,2);

        //ENTONCES:
        assertTrue(player.estaMuerto());
w

		//Dado: que existe un player y una fruta:
		Player player;
		Fruta fruta;
		//Cuando: Estos dos se encuentran en la misma posición
		player = new Player(5,5);
        fruta = new Fruta(5, 5);
		//ENTONCES: el player aumenta sus objetosRecolectados
		assert(1, player.getObjetosRecolectados());


		*/
		BadIceCream badIceCream = new BadIceCream();

		Scanner scanner = new Scanner(System.in);
		while (badIceCream.isRunning()){
			System.out.println("Ingrese una tecla (w/a/s/d):");
			String tecla = scanner.nextLine();
			switch (tecla) {
				case "w":
					badIceCream.movePlayer(Direction.UP);
					break;
				case "a":
					badIceCream.movePlayer(Direction.LEFT);
					break;
				case "s":
					badIceCream.movePlayer(Direction.DOWN);
					break;
				case "d":
					badIceCream.movePlayer(Direction.RIGHT);
					break;
			//	case "f":
				//	badIceCream.playerBreakIce();
				//	break;
				default:
					System.out.println("Tecla no válida.");
					break;
			}

			System.out.println(badIceCream.getPlayer().getPosition());

		}

	}
}

/*

TODO

- Constructor en TODAS las clases que no tengan :)

- player.breakIce()
- enemy.breakIce()
- player.incrementCollectionCounter()
- level.getNumCollectableElements() // TODO
- player.getFrontPosition()



TODO BUSINESS

- que el jugador se pueda mover
	badIceCream.movePlayer()

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

- que el jugador muera cuando toca un enemigo
- que el jugador pueda recoger las frutas

- bucle while

	badIceCream.run()
	main{
		while(...)
	}

- badIceCream.passLevel()




 */