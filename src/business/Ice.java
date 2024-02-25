package business;

public class Ice extends Block{

	private boolean breakable;

	public Ice(String name, boolean solid, boolean breakable) {

		super(name, solid);
		this.breakable = breakable;
	}

}