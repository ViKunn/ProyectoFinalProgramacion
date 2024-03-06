package newTryOfPresentation.states;

import javax.swing.*;
import java.awt.*;

public class MenuState extends JLayeredPane {

	public MenuState(int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);

		addComponents();
	}

	public void addComponents(){

		JLabel label1 = new JLabel();
		label1.setOpaque(true);
		label1.setBackground(Color.PINK);
		label1.setBounds(0,0, 50,50);

		this.add(label1);

	}

}