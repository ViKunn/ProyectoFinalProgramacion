import business.Direction;

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


		//Dado: que existe un player y una fruta:
		Player player;
		Fruta fruta;
		//Cuando: Estos dos se encuentran en la misma posición
		player = new Player(5,5);
        fruta = new Fruta(5, 5);
		//ENTONCES: el player aumenta sus objetosRecolectados
		assertTrue(player.getObjetosRecolectados());

		*/

		BadIceCream badIceCream = new BadIceCream();

		badIceCream.movePlayer(Direction.UP);
		badIceCream.movePlayer(Direction.LEFT);


	}
}

/*

TODO

- Constructor en TODAS las clases que no tengan :)

- player.breakIce()
- enemy.breakIce()
- player.incrementCollectionCounter()
- level.getNumCollectionableElements()
- player.getFrontPosition()



TODO BUSINESS

- que el jugador se pueda mover
	badIceCream.movePlayer()

- que los enemigos se puedan mover

	level.update(){
		enemy.move(Map)
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