package business.characters;

import business.Direction;
import business.Position;

public abstract class Entity  {

	protected Position position;
	protected Direction direction;
	protected static int advance =1;

	public Position getPosition(){
		return position;
	}

	public Direction getDirection(){
		return direction;
	}

}