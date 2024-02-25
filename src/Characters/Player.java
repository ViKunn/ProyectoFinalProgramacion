package Characters;

import business.*;


public class Player extends Entity implements Movable /*, Breakable*/ {

	private int posibleSpeed = 1;
	private boolean alive;

	public Player(Position position ){
		this.position = position;
		this.advance = 1;
	}

	public void move(Direction direction){

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
				break;
			case direction.LEFT:
				position.setX(position.getX() - advance);
				break;

		}
	}

	public void die() {
		alive = false;
	}

	/*
	public Map breakIce(Map map){

		Map mapAux = map;
		if(map.(direction, position)){

		}

		//positionFront, refers to the direction in which the player´s view points (view of ice cream)
		//Position positionFront = position;
		//Position position1 = new Position(0, 1);

		switch (direction){
			case direction.UP:
				//verificatedIfCanIBroke(mapAux.getBlock(positionFront.getPositionIn(direction));
				//positionFront = positionFront.getX(), positionFront.getY() - 1
				verificateIfIsIce(mapAux.getBlock(new Position(position.getX(), position.getY() - advance)));
				break;
			case direction.DOWN:
				//position.getX();
				verificateIfIsIce(mapAux.getBlock(new Position(position.getX(), position.getY() + advance)));
				break;
			case direction.RIGHT:
				//position.setX(position.getX() + advance);
				verificateIfIsIce(mapAux.getBlock(new Position(position.getX() + advance, position.getY())));
				break;
			case direction.LEFT:
				verificateIfIsIce(mapAux.getBlock(new Position(position.getX() - advance, position.getY())));
				break;
				//position.setX(position.getX()- advance);
		}

		return mapAux;
	}
	
	public boolean verificateIfIsIce(Block block) {
			// hielo
		return false;
	}

	public void setLife(boolean lifeState){
		this.life = lifeState;
	}

	// Muerte del jugador, estado de vivo o muerto, ya está jeje

	public boolean playerIsAlive(){
		return alive;
	}

	 */

}