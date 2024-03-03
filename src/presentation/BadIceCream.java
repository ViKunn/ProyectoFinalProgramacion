package presentation;

import presentation.states.MenuState;

import javax.swing.*;
import java.awt.*;

public class BadIceCream extends JFrame {

	private MenuState menuState;

	private final int tileSize = 32;

	private final int maxScreenCol = 30;
	private final int maxScreenRow = 20;

	private final int screenWidth = tileSize * maxScreenCol;   // ancho // 960
	private final int screenHeight = tileSize * maxScreenRow;   // alto // 640

	



	private final Dimension dimension = new Dimension(screenWidth, screenHeight);

	private String backgroundImage = "res/presentation/img.png";
	private Panel layeredPanel;

	public BadIceCream() {

		setInitialValues();

		addBackground();
		setVisible(true);
		sleep(2000);
		addMenu();

		setVisible(true);
	}

	public void setInitialValues(){

		setTitle("BAD ICE CREAM");
		setSize(dimension);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void addBackground(){

		layeredPanel = new Panel(backgroundImage);
		getContentPane().add(layeredPanel);

	}
	public void addMenu(){
		menuState = new MenuState(dimension);
		layeredPanel.add(menuState);
	}
	public void sleep(int milliseconds){
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

}