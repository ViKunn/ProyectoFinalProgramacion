package Characters;
import business.*;

public abstract class Enemy extends Entity implements Movable {

	protected CollisionChecker collisionChecker;

	public Enemy(Position position, Direction direction, int advance, CollisionChecker collisionChecker){

		this.position = position;
		this.direction = direction;
		this.advance = advance;
		this.collisionChecker = collisionChecker;

	}

	// Ya se creó la clase Troll (va a ser el primer monstruo).
	//Posición monstruos
}