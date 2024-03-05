package test;

import static org.junit.Assert.*;
import org.junit.Test;
import business.entities.Direction;
import business.entities.Position;
import business.GameLogic;
import business.entities.Player;

import javax.sound.midi.Soundbank;

public class TestBadIceCream {

	@Test
	public void testPlayerDiesWhenCollidingWithEnemy() {
		GameLogic gameLogic = new GameLogic();
		gameLogic.startLevel(1);
		gameLogic.movePlayer(Direction.RIGHT); // Move player into enemy's position
		System.out.println(gameLogic);
		assertFalse(gameLogic.isRunningAndAlive()); // Player should be dead after colliding with enemy
	}

	@Test
	public void testPlayerDiesWhenCollidingWithEnemyOnStart() {
		// Arrange
		GameLogic gameLogic = new GameLogic();
		gameLogic.startLevel(2);
		System.out.println(gameLogic);

		// Assert
		assertFalse(gameLogic.isRunningAndAlive()); // Player should be dead after colliding with enemy
		System.out.println(gameLogic);
	}

	@Test
	public void testPlayerScoreIncreasesAfterEatingFruit() {
		// Arrange
		GameLogic gameLogic = new GameLogic();
		gameLogic.startLevel(1);

		// Act
		gameLogic.movePlayer(Direction.UP); // Move player to the position of a fruit

		// Assert
		assertTrue(gameLogic.getScorePlayer() > 0); // Player score should increase after eating a fruit
	}


	@Test
	public void testPlayerCannotMoveThroughSolidBlocks() {
		// Arrange
		GameLogic gameLogic = new GameLogic();
		gameLogic.startLevel(1);
		Position initialPosition = gameLogic.getPlayer().getPosition();

		// Act
		gameLogic.movePlayer(Direction.LEFT); // Attempt to move player through a solid block
		Position finalPosition = gameLogic.getPlayer().getPosition();

		// Assert
		assertEquals(initialPosition, finalPosition); // Player position should remain unchanged
	}

	@Test
	public void testPlayerMovesSuccessfullyThroughOpenPath() {
		// Arrange
		GameLogic gameLogic = new GameLogic();
		gameLogic.startLevel(1);
		int initialPosition = gameLogic.getPositionPlayer().getY();

		// Act
		gameLogic.movePlayer(Direction.UP); // Move player through an open path
		int finalPosition = gameLogic.getPositionPlayer().getY();

		// Assert
		assertNotEquals(initialPosition, finalPosition); // Player position should change after moving through an open path
	}

	@Test
	public void testPlayerDestroyIceWithHisPowers() {
		// Arrange
		GameLogic gameLogic = new GameLogic();
		gameLogic.startLevel(1);
		boolean before = gameLogic.isIceHere(new Position(5,12));
		gameLogic.movePlayer(Direction.LEFT);
		gameLogic.movePlayer(Direction.LEFT);
		gameLogic.playerActivatePowerUp();
		boolean aux = gameLogic.isIceHere(new Position(5,12));

		// Assert
		assertFalse(aux); // Player position should change after moving through an open path
	}

}
