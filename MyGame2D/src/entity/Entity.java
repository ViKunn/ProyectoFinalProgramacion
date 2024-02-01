package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

	protected int positionX, positionY;
	protected int speed;

	protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	protected String direction;

	protected int spriteCounter = 0;
	protected int spriteNum = 1;

	protected Rectangle solidArea;
	protected boolean collisionOn = false;


	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public int getSpeed() {
		return speed;
	}
	public String getDirection() {
		return direction;
	}
	public Rectangle getSolidArea() {
		return solidArea;
	}


	public void turnOnCollision(){
		collisionOn = true;
	}

}