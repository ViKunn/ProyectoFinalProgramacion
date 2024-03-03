package presentation;

import presentation.states.MenuState;

import javax.swing.*;
import java.awt.*;

public class BadIceCream extends JFrame {

	private MenuState menuState;

	private int width = 1000;
	private int height = 600;
	private final Dimension dimension = new Dimension(width, height);

	private String backgroundImage = "res/presentation/Background.jpg";
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