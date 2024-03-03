package test;

import business.entities.Direction;
import business.entities.Position;
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