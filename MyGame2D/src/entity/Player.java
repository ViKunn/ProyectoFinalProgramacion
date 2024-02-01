package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;


	public Player(GamePanel gamePanel, KeyHandler keyHandler){

		this.gp = gamePanel;
		this.keyH = keyHandler;

		solidArea = new Rectangle(8, 16, 32,32);


		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues(){

		positionX = 100;
		positionY = 100;

		speed = 4;

		//initial direction
		direction = "down";
	}
	public void getPlayerImage(){
		try {

			up1    = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/player/boy_up_1.png"));
			up2    = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/player/boy_up_2.png"));
			down1  = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/player/boy_down_1.png"));
			down2  = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/player/boy_down_2.png"));
			left1  = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/player/boy_left_1.png"));
			left2  = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/BlueBoyAdventure/player/boy_right_2.png"));

		} catch (IOException e){
			e.printStackTrace();
		}
	}

	private void getDirectionFromPressedKey(){
		if (keyH.isUpPressed()){
			direction = "up";

		} else if (keyH.isDownPressed()){
			direction = "down";

		} else if (keyH.isLeftPressed()) {
			direction = "left";

		} else if (keyH.isRightPressed()) {
			direction = "right";
		}
	}
	private boolean movementKeyIsBeingPressed(){
		return (keyH.isUpPressed()   || keyH.isDownPressed() ||
				keyH.isLeftPressed() || keyH.isRightPressed());
	}

	public void update() {

		// Check that any movement key is being pressed
		if (!movementKeyIsBeingPressed()){
			return;
		}

		getDirectionFromPressedKey();

		// Check tile collision
		collisionOn = false;
		gp.getCollisionChecker().checkTile(this);

		// If Collision is false player can move
		if (collisionOn == true){
			return;
		}

		// movimiento
		switch (direction) {
			case "up":
				positionY -= speed;
				break;
			case "down":
				positionY += speed;
				break;
			case "left":
				positionX -= speed;
				break;
			case "right":
				positionX += speed;
				break;
		}

		// Animación
		spriteCounter++;
		if (spriteCounter > 12){

			if (spriteNum == 1){
				spriteNum = 2;

			} else if (spriteNum == 2) {
				spriteNum = 1;
			}

			spriteCounter = 0;
		}   //player's image changes every 10 frames = 6 times per second

	}
	public void draw(Graphics2D graphic2D){

		BufferedImage image = null;

		switch (direction) {
			case "up":

				if (spriteNum == 1){
					image = up1;
				}
				if (spriteNum == 2){
					image = up2;
				}
				break;

			case "down":

				if (spriteNum == 1){
					image = down1;
				}
				if (spriteNum == 2){
					image = down2;
				}
				break;

			case "left":

				if (spriteNum == 1){
					image = left1;
				}
				if (spriteNum == 2){
					image = left2;
				}
				break;

			case "right":

				if (spriteNum == 1){
					image = right1;
				}
				if (spriteNum == 2){
					image = right2;
				}
				break;

		}

		graphic2D.drawImage(image, positionX, positionY, gp.getTileSize(), gp.getTileSize(), null);

	}

}