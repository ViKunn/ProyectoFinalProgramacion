package Characters;

import business.Direction;
import business.Position;

public abstract class Entity  {

	protected Position position;
	protected Direction direction;
	protected int speed;

	public Position getPosition(){
		return position;
	}
	public int getSpeed(){
		return speed;
	}
	public Direction getDirection(){
		return direction;
	}

}