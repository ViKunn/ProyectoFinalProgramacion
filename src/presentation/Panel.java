package presentation;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

	private final Image image;

	public Panel(String imagePath) {
		image = new ImageIcon(imagePath).getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}