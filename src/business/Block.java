package business;

public class Block {

	private String name;
	private final boolean solid;

	public Block(String name, boolean collisionable) {
		this.name = name;
		this.solid = collisionable;
	}

	public boolean isSolid() {
		return solid;
	}

	@Override
	public String toString() {
		return name;
	}
}