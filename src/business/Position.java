package business;

public class Position implements Cloneable{

	private int x;
	private int y;

	public Position() {
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x){
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public Position getFrontPosition(Direction direction){

		Position frontPosition = new Position(x, y);

		switch (direction){
			case UP:     frontPosition.y --;   break;
			case DOWN:   frontPosition.y ++;   break;
			case LEFT:   frontPosition.x --;   break;
			case RIGHT:  frontPosition.x ++;   break;
		}

		return frontPosition;

	}

	public boolean equals(Position p2) {
		return (x == p2.x && y == p2.y);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "x: " + x + ", y: " + y;
	}

}