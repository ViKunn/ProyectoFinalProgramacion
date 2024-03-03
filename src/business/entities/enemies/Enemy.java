package business.entities.enemies;
import business.entities.Direction;
import business.entities.Entity;
import business.entities.Position;
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

	public void changeToOpositeDirection() {
		switch (this.direction){
			case Direction.UP:
				this.direction = Direction.DOWN;
				break;
			case Direction.DOWN:
				this.direction = Direction.UP;
				break;
			case Direction.RIGHT:
				this.direction = Direction.LEFT;
				break;
			case Direction.LEFT:
				this.direction = Direction.RIGHT;
				break;
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}