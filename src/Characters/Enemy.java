package Characters;
import Characters.Entity;
import business.Direction;
import business.Movable;
import business.Position;

public class Enemy extends Entity {

	public Enemy(Position position, Direction direction,int speed){

		this.position = position;
		this.direction = direction;
		this.speed = speed;
	}
	
}