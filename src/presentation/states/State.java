package presentation.states;

import javax.swing.*;

public abstract class State extends JPanel implements Runnable {

	abstract public void start();

	@Override
	public void run() {

	}
}