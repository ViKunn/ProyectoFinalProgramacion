package business.characters;
import business.*;
import business.interfaces.Movable;
import business.managers.CollisionChecker;

public abstract class Enemy extends Entity implements Movable, Cloneable {

	protected CollisionChecker collisionChecker;

	public Enemy(){
	}

	public void setPosition(Position positionExpect){
		this.position = new Position(positionExpect.getX(), (positionExpect.getY()));
	}
	public void setDirection(Direction direction){
		this.direction = direction;
	}
	public void setCollisionChecker(CollisionChecker collisionChecker){
		this.collisionChecker = collisionChecker;
	}


	// Ya se creó la clase Troll (va a ser el primer monstruo).
	//Posición monstruos
	//Movimiento segundo monstruo, monstruo vaca?, o monstruo pato?
}