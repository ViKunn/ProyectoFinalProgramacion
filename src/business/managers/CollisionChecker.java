package business.managers;

import business.entities.Direction;
import business.level.map.Map;
import business.entities.Position;

public class CollisionChecker {

	private final Map map;

	public CollisionChecker(Map map) {
		this.map = map;
	}

	//Verifica si la posición esta atrapada entre bloques sólidos
	public boolean trappedBetweenBlocks(Position position) {
		return frontBlockIsSolid(Direction.UP, position) &&
				frontBlockIsSolid(Direction.DOWN, position) &&
				frontBlockIsSolid(Direction.RIGHT, position) &&
				frontBlockIsSolid(Direction.LEFT, position);
	}

	//Verifica si el bloque en la posición frontal es sólido
	public boolean frontBlockIsSolid(Direction direction, Position position){
		Position frontPosition = position.getFrontPosition(direction);
		return map.getBlock(frontPosition).isSolid();
	}

}