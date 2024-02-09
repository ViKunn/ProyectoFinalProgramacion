import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {

	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;

	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;


	static final int GAME_UNITS_X = SCREEN_WIDTH/UNIT_SIZE;
	static final int GAME_UNITS_Y = SCREEN_HEIGHT/UNIT_SIZE;


	static final int DELAY = 100;

	final int[] x = new int[GAME_UNITS];
	final int[] y = new int[GAME_UNITS];

	int bodyParts = 6;
	int applesEaten;
	int appleX;
	int appleY;

	char direction = 'R';

	boolean running = false;
	Timer timer;
	Random random;

	GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);

		this.addKeyListener(new MyKeyAdapter());

		startGame();
	}

	public void startGame(){
		newApple();
		running = true;

		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void move(){

		switch (direction){

			case 'U':
				y[0] = y[0] - UNIT_SIZE;
				break;

			case 'D':
				y[0] = y[0] + UNIT_SIZE;
				break;

			case 'L':
				x[0] = x[0] - UNIT_SIZE;
				break;

			case 'R':
				x[0] = x[0] + UNIT_SIZE;
				break;

			default:
				break;
		}
	}
	public void checkCollisions(){

		/*
		// check if the HEAD touches/collides with BODY
		for (int i = bodyParts; i > 0; i--){
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
				break;
			}
		}
		*/

		// FUNCIONA
		// check if HEAD touches LEFT border
		if (x[0] < 0){
			x[0] = 0;
		}
		// check if HEAD touches RIGHT border
		if (x[0] > SCREEN_WIDTH - UNIT_SIZE){
			x[0] = SCREEN_WIDTH - UNIT_SIZE;
		}
		// FUNCIONA
		// check if HEAD touches TOP border
		if (y[0] < 0){
			y[0] = 0;
		}
		// check if HEAD touches BOTTOM border
		if (y[0] > SCREEN_HEIGHT - UNIT_SIZE){
			y[0] = SCREEN_HEIGHT - UNIT_SIZE;
		}

		if (!running){
			timer.stop();
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g){

		if (!running){
			gameOver(g);
			return;
		}

		for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++){

			// Draw lines in Y
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
			// Draw lines in X
			g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
		}

		g.setColor(Color.red);
		g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

		for (int i = 0; i < bodyParts; i++){
			// head of the snake
			if (i == 0){
				g.setColor(Color.green);
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			else {

				/*
				// BODY PARTS
				int R = random.nextInt(255);
				int G = random.nextInt(255);
				int B = random.nextInt(255);

				g.setColor(new Color(R,G,B));
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				 */

			}
		}

		drawMessage(g, Color.white, 25, "Score: " + applesEaten, "CENTER", "TOP" );

	}
	public void drawMessage(Graphics g, Color color, int size, String msg, String xPosition, String yPosition){
		g.setColor(color);
		g.setFont(new Font("Ink Free", Font.BOLD, size));

		FontMetrics metrics = getFontMetrics(g.getFont());

		int x = 0;
		int y = 0;

		if (xPosition.equals("CENTER")){
			x = (SCREEN_WIDTH - metrics.stringWidth(msg))/2;
		}
		if (yPosition.equals("TOP")){
			y = g.getFont().getSize();
		}

		g.drawString(msg, x, y);
	}

	public void newApple(){
		appleX = random.nextInt(GAME_UNITS_X)* UNIT_SIZE;
		appleY = random.nextInt(GAME_UNITS_Y)* UNIT_SIZE;
	}
	public void checkApple(){
		if ((x[0] == appleX) && (y[0] == appleY)){
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}

	public void gameOver(Graphics g){
		// Game Over text
		g.setColor(Color.white);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());

		g.drawString("GAME OVER", (SCREEN_WIDTH - metrics.stringWidth("GAME OVER"))/2, SCREEN_HEIGHT/2);
		drawMessage(g, Color.white, 50, "Score: " + applesEaten, "CENTER", "TOP" );
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (!running){
			return;
		}

		move();
		checkApple();
		checkCollisions();

		direction = ' ';
		repaint();

	}

	// CLASES ANIDADAS
	public class MyKeyAdapter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e){
			switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					direction = 'L';
					break;

				case KeyEvent.VK_RIGHT:
					direction = 'R';
					break;

				case KeyEvent.VK_UP:
					direction = 'U';
					break;

				case KeyEvent.VK_DOWN:
					direction = 'D';
					break;

			}
		}
	}

}