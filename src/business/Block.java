package business;

public class Block {

	private String name;
	private final boolean solid;

	public Block(String name, boolean solid) {
		this.name = name;
		this.solid = solid;
	}

	public boolean isSolid() {
		return solid;
	}

	@Override
	public String toString() {
		return name;
	}

}