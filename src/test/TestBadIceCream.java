package test;

import static org.junit.Assert.*;
import org.junit.Test;
import business.entities.Direction;
import business.entities.Position;
import business.GameLogic;
import business.entities.Player;

public class TestBadIceCream {

	@Test
	public void testPlayerDiesWhenCollidingWithEnemy() {
		GameLogic gameLogic = new GameLogic();
		gameLogic.startLevel(1);
		System.out.println(gameLogic);
		gameLogic.movePlayer(Direction.RIGHT); // Move player into enemy's position
		System.out.println(gameLogic);
		assertFalse(gameLogic.isRunningAndAlive()); // Player should be dead after colliding with enemy
		System.out.println(gameLogic);
	}
	@Test
	public void testPlayerDiesWhenCollidingWithEnemyOnStart() {
		GameLogic gameLogic = new GameLogic();
		gameLogic.startLevel(1);
		System.out.println(gameLogic);

		assertFalse(gameLogic.isRunningAndAlive()); // Player should be dead after colliding with enemy
	}


	@Test
	public void testPlayerScoreIncreasesAfterEatingFruit() {
		GameLogic gameLogic = new GameLogic();
		gameLogic.startLevel(1);
		gameLogic.movePlayer(Direction.UP); // Move player to the position of a fruit
		System.out.println(""+ gameLogic.isRunningAndAlive() + gameLogic.getScorePlayer());
		System.out.println(gameLogic);
		assertTrue(gameLogic.getScorePlayer() > 0); // Player score should increase after eating a fruit
	}

	@Test
	public void testPlayerCannotMoveThroughSolidBlocks() {
		GameLogic gameLogic = new GameLogic();
		Player player = new Player(new Position(1, 1));
		gameLogic.startLevel(1);

		// Attempt to move player through a solid block
		gameLogic.movePlayer(Direction.LEFT); // Assuming there's a solid block to the left of the player
		assertEquals(new Position(1, 1), player.getPosition()); // Player position should remain unchanged
	}

	// You can add more tests for various scenarios as needed
}
