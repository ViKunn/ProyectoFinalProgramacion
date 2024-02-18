package Characters;

import Characters.Entity;
import business.Direction;
import business.Movable;
import business.Position;


public class Player extends Entity implements Movable {

	private int posibleSpeed = 1;

	public Player(Position position ){
		this.position = position;
		this.speed = posibleSpeed;
	}

	public void move(Direction direction){ //ya esta :)

		switch (direction){
			case direction.UP:
				position.setY(position.getY() + speed );
				break;
			case direction.DOWN:
				position.setY(position.getY() - speed);
				break;
			case direction.RIGHT:
				position.setX(position.getX() + speed);
			case direction.LEFT:
				position.setX(position.getX()- speed);
		}
	}
}