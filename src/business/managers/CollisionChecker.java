package business.managers;

import business.entities.Direction;
import business.level.map.Map;
import business.entities.Position;

public class CollisionChecker {

	private Map map;

	public CollisionChecker(Map map) {
		this.map = map;
	}

	public boolean trappedBetweenBlocks(Position position) {
		return frontBlockIsSolid(Direction.UP, position) &&
				frontBlockIsSolid(Direction.DOWN, position) &&
				frontBlockIsSolid(Direction.RIGHT, position) &&
				frontBlockIsSolid(Direction.LEFT, position);
	}


    // TODO corregir para ocupar método Position.getFrontPosition
	// TODO verificar lineas de código duplicadas (en Map - front block is solid creo)

	public boolean frontBlockIsSolid(Direction direction, Position position){

		Position frontPosition = new Position();

		switch (direction){
			case UP:
				frontPosition = new Position (position.getX(), (position.getY() - 1));
				break;

			case DOWN:
				frontPosition = new Position(position.getX(), (position.getY()) + 1);
				break;

			case LEFT:
				frontPosition = new Position((position.getX() - 1), position.getY());
				break;

			case RIGHT:
				frontPosition = new Position((position.getX() + 1), position.getY());
				break;
		}

		return map.getBlock(frontPosition).isSolid();
	}

}