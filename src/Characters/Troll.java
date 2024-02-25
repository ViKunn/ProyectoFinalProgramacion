package Characters;

import business.CollisionChecker;
import business.Direction;
import business.Movable;
import business.Position;
import business.Map;

public class Troll extends Enemy implements Movable{

	public Troll(Position position, Direction direction, CollisionChecker collisionChecker) {
		super(position, direction, 1, collisionChecker);
	}

	//Movimiento primer monstruo

	public void move(Direction direction) {

		if (collisionChecker.frontBlockIsSolid(direction, position)) {
			switch (direction) {
				case direction.UP:
					position.setY(position.getY() - advance);
					break;
				case direction.DOWN:
					position.setY(position.getY() + advance);
					break;
				case direction.RIGHT:
					position.setX(position.getX() + advance);
				case direction.LEFT:
					position.setX(position.getX() - advance);
			}
		} else {
			switch (direction) {
				case direction.UP:
					this.direction = direction.RIGHT;
					break;
				case direction.DOWN:
					this.direction = direction.LEFT;
					break;
				case direction.RIGHT:
					this.direction = direction.DOWN;

				case direction.LEFT:
					this.direction = direction.UP;

			}
		}
	}
}