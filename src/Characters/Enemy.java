package Characters;
import business.Direction;
import business.Position;

public abstract class Enemy extends Entity {

	protected CollisionChecker collisionChecker;

	public Enemy(Position position, Direction direction, int advance, CollisionChecker collisionChecker){

		this.position = position;
		this.direction = direction;
		this.advance = advance;

	}


	// Ya se creó la clase Troll (va a ser el primer monstruo).
	//Movimiento
	//Posición monstruos
}