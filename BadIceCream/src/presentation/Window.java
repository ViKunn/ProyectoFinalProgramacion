package presentation;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

	private static int screenWidth;  // X
	private static int screenHeight; // Y

	public Window(int screenWidth, int screenHeight) {

		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;

		windowConfiguration();
	}

	private void windowConfiguration() {
		this.setTitle("SNAKE GAME");
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setFocusable(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}