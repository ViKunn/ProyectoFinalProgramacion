package business.entities;


import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

	protected Position position;

	protected Direction direction;
	protected static int advance = 1;
	protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

	public Position getPosition(){
		return position;
	}
	public Direction getDirection(){
		return direction;
	}

	public abstract void draw(Graphics2D graphic2D, int tileSize) ;

}

/*

			case UP:

				if (spriteNum == 1){
					image = up1;
				}
				if (spriteNum == 2){
					image = up2;
				}
				break;

			case DOWN:

				if (spriteNum == 1){
					image = down1;
				}
				if (spriteNum == 2){
					image = down2;
				}
				break;

			case LEFT:

				if (spriteNum == 1){
					image = left1;
				}
				if (spriteNum == 2){
					image = left2;
				}
				break;

			case RIGHT:

				if (spriteNum == 1){
					image = right1;
				}
				if (spriteNum == 2){
					image = right2;
				}
				break;

		}


 */