package business.characters;

import business.*;
import business.interfaces.Movable;
import business.interfaces.PowerUps;


public class Player extends Entity implements Movable, PowerUps {

	private final int posibleSpeed = 1;
	private boolean alive;

	public Player(Position position){
		this.position = position;
		this.advance = 1;
	}

	public void changeDirection(Direction directionExpect){
		this.direction = directionExpect;

	}
	public void move(Direction direction){

		this.direction = direction;

		switch (direction){

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
	}

	public void die() {
		alive = false;
	}

	@Override
	public void powerUpIce(Map map) {

		if (map.frontBlockIsIce(direction, position)){
			breakIce(map);
		} else {
			putIce(map);
		}

	}

	@Override
	public void breakIce(Map map) {

		Position auxPosition = new Position(position.getX(), position.getY());

		while (map.getBlock(auxPosition.getFrontPosition(direction)) instanceof Ice){
			auxPosition = auxPosition.getFrontPosition(direction);
			map.setBlock(auxPosition, 0);
		}


	}

	@Override
	public void putIce(Map map) {
		Position auxPosition1 = new Position(this.position.getX(), this.position.getY());

		while (!(map.isBlockSolid(auxPosition1.getFrontPosition(direction)))){
			auxPosition1 = auxPosition1.getFrontPosition(direction);
			map.setIce(auxPosition1);

		}

	}

}