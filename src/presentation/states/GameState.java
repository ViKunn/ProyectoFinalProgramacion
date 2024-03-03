package presentation.states;

import business.GameLogic;

import java.awt.*;

public class GameState extends State{

	private final Dimension dimension;
	private final GameLogic gameLogic;

	private static final int FPS = 60;
	private final int tileSize;

	public GameState(Dimension dimension, int tileSize) {

		this.dimension = dimension;
		this.tileSize = tileSize;

		gameLogic = new GameLogic();
		setInitialValues();

		// TODO
		gameLogic.startLevel(1);
		gameLogic.pauseGame();

	}

	private void setInitialValues(){

		setPreferredSize(dimension);
		setBounds(tileSize * 5, 7, tileSize * 18, tileSize * 18);

	}


	@Override
	public void start() {
		run();
	}

	@Override
	public void run(){

		double drawInterval = (double) 1000000000 /FPS;
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
		gameLogic.draw(g2, tileSize);
		g2.dispose();

	}

}