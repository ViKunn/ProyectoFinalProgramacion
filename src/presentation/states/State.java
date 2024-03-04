package presentation.states;

import javax.swing.*;
import java.awt.*;

public abstract class State extends JPanel implements Runnable {

	public void setSize(Dimension dimension){
		setPreferredSize(dimension);
	}
	abstract public void start();

	@Override
	public void run() {

	}
}