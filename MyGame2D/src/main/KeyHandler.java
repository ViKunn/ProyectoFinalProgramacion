package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyHandler implements KeyListener {

	private final int UP    = KeyEvent.VK_UP;
	private final int DOWN  = KeyEvent.VK_DOWN;
	private final int LEFT  = KeyEvent.VK_LEFT;
	private final int RIGHT = KeyEvent.VK_RIGHT;

	private boolean upPressed;
	private boolean downPressed;
	private boolean leftPressed;
	private boolean rightPressed;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();  // Returns the integer KeyCode associated with the key in this event

		if (code == UP){
			upPressed = true;
		}
		if (code == DOWN){
			downPressed = true;
		}
		if (code == LEFT){
			leftPressed = true;
		}
		if (code == RIGHT){
			rightPressed = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();

		if (code == UP){
			upPressed = false;
		}
		if (code == DOWN){
			downPressed = false;
		}
		if (code == LEFT){
			leftPressed = false;
		}
		if (code == RIGHT){
			rightPressed = false;
		}
	}


	public boolean isUpPressed() {
		return upPressed;
	}
	public boolean isDownPressed() {
		return downPressed;
	}
	public boolean isLeftPressed() {
		return leftPressed;
	}
	public boolean isRightPressed() {
		return rightPressed;
	}
}