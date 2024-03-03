package presentation.states;

import business.GameLogic;

import javax.swing.*;
import java.awt.*;

public class GameState extends State{

	private final Dimension dimension;
	private GameLogic gameLogic;

	private static final int FPS = 60;


	public GameState(Dimension dimension) {

		this.dimension = dimension;
		setPreferredSize(dimension);
		gameLogic = new GameLogic();

	}


	@Override
	public void start() {
		run();
	}

	@Override
	public void run(){

		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		// TODO considerar variable
		while (gameLogic.isRunningAndAlive()) {

			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/drawInterval;
			lastTime = currentTime;

			if (delta >= 1){
				update();
				repaint();
				delta--;
			}
		}

	}

	public void update(){
		gameLogic.update();
	}
	public void paintComponent(Graphics g){

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		gameLogic.draw(g2);

		g2.dispose();
	}

}