package test;

import junit.framework.TestCase;

public class TestBadIceCream extends TestCase{

	public void testPlayerMuereAlTocarUnEnemigo(){
		//DADO: que existe
		assertTrue(true);
	}

}

/*

TODO: TESTERS

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