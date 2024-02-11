package presentation;

public class MenuState implements Runnable{

	private int option = -1;

	public int start(){
		run();
		return option;
	}



	@Override
	public void run() {
		int counter = 0;
		while (counter < 5){

			System.out.println("Corriendo menu");
			counter++;
		}
	}
}