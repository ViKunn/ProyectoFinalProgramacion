package newTryOfPresentation;

import newTryOfPresentation.states.MenuState;

import javax.swing.*;
import java.awt.*;

public class BadIceCream extends JFrame {

	private final int tileSize = 32;

	private final int maxScreenCol = 30;
	private final int maxScreenRow = 20;

	private final int screenWidth = tileSize * maxScreenCol;
	private final int screenHeight = tileSize * maxScreenRow;

	private MenuState menuState;

	public BadIceCream(){

		setInitialValues();
		addMenu();

	}

	private void setInitialValues(){

		this.setTitle("BAD ICE CREAM");
		this.setSize(screenWidth, screenHeight);

		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.black);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void addMenu(){

		menuState = new MenuState(tileSize * 7, tileSize * 12, tileSize*16, tileSize * 5);
		this.add(menuState);

	}

	public void start(){
		setVisible(true);
	}

}

// todo layeredPanel.addBackground;