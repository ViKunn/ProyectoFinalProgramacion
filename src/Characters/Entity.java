package Characters;

import business.Direction;
import business.Position;

public abstract class Entity  {

	protected Position position;
	protected Direction direction;
	protected int advance;

	public Position getPosition(){
		return position;
	}
	public int getSpeed(){
		return advance;
	}
	public Direction getDirection(){
		return direction;
	}
	//public abstract Map breakIce();
}