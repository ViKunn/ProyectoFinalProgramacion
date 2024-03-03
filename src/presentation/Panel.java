package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Panel extends JPanel {

	private final Image image;

	public Panel(String imagePath) {
		image = new ImageIcon(imagePath).getImage();
	}

	// Método actionPerformed para manejar las acciones de los botones del menú
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		JOptionPane.showMessageDialog(this, "Seleccionaste: " + actionCommand);
		// Agregar acciones según la opción seleccionada
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}

}