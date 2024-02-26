

import business.Direction;
import business.characters.*;
import business.interfaces.*;
import business.Position;
/*
public class BlueCow extends Enemy implements Movable, Runnable {

	Player player = new Player( new Position(3,13));

	public BlueCow(Position position, Direction direction, CollisionChecker collisionChecker) {
		super(position, direction, 1, collisionChecker);
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Estoy aqui ");
			followPlayer(player); // Mover el troll en la dirección actual
			System.out.println("" + this.position);

			try {
				Thread.sleep(500); // Esperar un medio segundo entre cada movimiento
			} catch (InterruptedException e) {
				// Manejar interrupciones del hilo si es necesario
				e.printStackTrace();
			}
		}
	}

	private void followPlayer(Player player) {

		Position playerPosition = player.getPosition();

		int distanceX = playerPosition.getX() - this.position.getX();
		int distanceY = playerPosition.getY() - this.position.getY();

		int valorDistanceX = (distanceX >= 0) ? distanceX : -distanceX;
		int valorDistanceY = (distanceY >= 0) ? distanceY : -distanceY;

		if (valorDistanceX > valorDistanceY) {
			if (distanceX > 0) {
				move(Direction.RIGHT);
			} else {
				move(Direction.LEFT);
			}
		} else {
			if (distanceY > 0) {
				move(Direction.DOWN);
			} else {
				move(Direction.UP);
			}
		}
	}

	public void move(Direction direction) {

		if (!(collisionChecker.frontBlockIsSolid(direction, position))) {

			switch (direction) {
				case UP:
					position.setY(position.getY() - advance);
					break;
				case DOWN:
					position.setY(position.getY() + advance);
					break;
				case RIGHT:
					position.setX(position.getX() + advance);
					break;
				case LEFT:
					position.setX(position.getX() - advance);
					break;
			}

		} else {
			switch (direction) {
				case UP:
					this.direction = Direction.RIGHT;
					break;
				case DOWN:
					this.direction = Direction.LEFT;
					break;
				case RIGHT:
					this.direction = Direction.DOWN;
					break;
				case LEFT:
					this.direction = Direction.UP;
					break;
			}

		}


	}
} */