package Characters;

import business.*;


public class Player extends Entity implements Movable, PowerUps {

	private final int posibleSpeed = 1;
	private boolean alive;

	public Player(Position position){
		this.position = position;
		this.advance = 1;
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

	// FIXME
	@Override
	public void breakIce(Map map) {

		Position auxPosition = new Position(position.getX(), position.getY());


		// FIXME
		while (map.getBlock(auxPosition.getFrontPosition(direction)) instanceof Ice){
			map.setBlock(auxPosition, 0);auxPosition = auxPosition.getFrontPosition(direction);
		}

		System.out.println(map);
		System.out.println(":)");
	}

	// FIXME
	@Override
	public void putIce(Map map) {

		Position positionAux = position;
		switch (direction) {

			case UP:
				map.setBlock(positionAux, 0);
				while (!map.frontBlockIsIce(direction, positionAux)) {
					positionAux.setY(positionAux.getY() - 1);
					map.setIce(positionAux);
				}
				break;

			case DOWN:
				while (!map.frontBlockIsIce(direction, positionAux)) {
					positionAux.setY(positionAux.getY() + 1);
					map.setIce(positionAux);
				}
				break;

			case RIGHT:
				while (!map.frontBlockIsIce(direction, positionAux)) {
					positionAux.setX(positionAux.getX() + 1);
					map.setIce(positionAux);
				}
				break;


			case LEFT:
				while (!map.frontBlockIsIce(direction, positionAux)) {
					positionAux.setX(positionAux.getX() - 1);
					map.setIce(positionAux);
				}
				break;

		}

		System.out.println(map);
		System.out.println(":)");
	}
}