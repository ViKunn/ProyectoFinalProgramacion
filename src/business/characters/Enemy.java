package business.characters;
import business.*;
import business.interfaces.Movable;
import business.managers.CollisionChecker;

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
	//Movimiento segundo monstruo, monstruo vaca?, o monstruo pato?
}