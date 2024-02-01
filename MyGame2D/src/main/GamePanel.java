package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

// Works as a GameScreen
public class GamePanel extends JPanel implements Runnable{

	// WORLD SETTINGS
	private final int originalTileSize = 18;    // 16 * 16 original size of a character
	private final int scale = 2;

	private final int tileSize = originalTileSize * scale;  // 64 * 64 tile
	private final int maxScreenCol = 18;
	private final int maxScreenRow = 18;
	private final int screenWidth  = tileSize * maxScreenCol;   // ancho
	private final int screenHeight = tileSize * maxScreenRow;   // alto

	// FPS
	private final int FPS = 60;


	private final KeyHandler keyHandler = new KeyHandler();
	private Thread gameThread;  // keeps the program running
	private Player player = new Player(this, keyHandler);
	private TileManager tileManager = new TileManager(this);
	private CollisionChecker collisionChecker = new CollisionChecker(this);



	public GamePanel(){
		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // set the size of JPanel
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);   // better rendering of performance "Double Buffered"
		this.addKeyListener(keyHandler);
		this.setFocusable(true);    // this GamePanel can be focused to receive key input
	}


	public int getTileSize() {
		return tileSize;
	}
	public int getMaxScreenCol() {
		return maxScreenCol;
	}
	public int getMaxScreenRow() {
		return maxScreenRow;
	}
	public CollisionChecker getCollisionChecker() {
		return collisionChecker;
	}
	public TileManager getTileManager() {
		return tileManager;
	}

	public void startGameThread(){
		gameThread = new Thread(this);
		gameThread.start(); //automatically call run method
	}


	@Override
	public void run(){

		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while (gameThread != null) {

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
		player.update();
	}
	public void paintComponent(Graphics g){

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		tileManager.draw(g2);
		player.draw(g2);

		g2.dispose(); // To save memory
	}

}