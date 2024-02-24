package Characters;

import business.*;


public class Player extends Entity implements Movable /*, Breakable*/ {

	private int posibleSpeed = 1;

	public Player(Position position ){
		this.position = position;
		this.advance = 1;
	}

	public void move(Direction direction){ //ya esta :)
		this.direction = direction;
		switch (direction){
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
	}

	//TODO: GENIOS CONTINUAN TRABAJANDO

	public Map breakIce(Map map){

		Map mapAux = map;

		//positionFront, refers to the direction in which the player´s view points (view of ice cream)
		//Position positionFront = position;
		//Position position1 = new Position(0, 1);

		switch (direction){
			case direction.UP:
				//verificatedIfCanIBroke(mapAux.getBlock(positionFront.getPositionIn(direction));
				//positionFront = positionFront.getX(), positionFront.getY() - 1
				verificateIfICanBroke(mapAux.getBlock(new Position(position.getX(), position.getY() - 1)));
				break;
			case direction.DOWN:
				//position.getX();
				verificateIfICanBroke(mapAux.getBlock(new Position(position.getX(), position.getY() + 1)));
				break;
			case direction.RIGHT:
				//position.setX(position.getX() + advance);
				verificateIfICanBroke(mapAux.getBlock(new Position(position.getX() + 1, position.getY())));
				break;
			case direction.LEFT:
				verificateIfICanBroke(mapAux.getBlock(new Position(position.getX() - 1, position.getY())));
				break;
				//position.setX(position.getX()- advance);
		}

		return mapAux;
	}

	public boolean verificateIfICanBroke(Block block) {
		// Unanse a la reu de nuevo ;3
		// Ya vamos jeje
		//mañana jsjasjsdjfkasd
		// Mateo grosero, quien es ?
		// así son :(
		// onvrez, mateos

		return false;
	}
}