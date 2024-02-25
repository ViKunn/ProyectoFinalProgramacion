package business;

public class CollisionChecker {

	private Map map;

	public CollisionChecker(Map map) {
		this.map = map;
	}

	// TODO corregir para ocupar método Position.getFrontPosition
	// TODO verificar lineas de código duplicadas

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