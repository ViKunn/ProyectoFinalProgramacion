package test;

import business.Direction;
import business.Position;
import junit.framework.TestCase;

public class TestBadIceCream extends TestCase{

	public void testPlayerMuereAlTocarUnEnemigo(){
		assertTrue(true);
	}

	public void testGetFrontPosition(){

		Position position = new Position(1,1);
		position = position.getFrontPosition(Direction.DOWN);
		assertTrue(position.equals(new Position(1,2)));

	}

}

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
	assert(1, player.getObjetosRecolectados());



*/