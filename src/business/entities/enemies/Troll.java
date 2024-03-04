package business.entities.enemies;

import business.managers.CollisionChecker;
import business.entities.Direction;
import business.interfaces.Movable;
import business.entities.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Troll extends Enemy implements Movable{

	public Troll() {
		setDirection(Direction.DOWN);
		getTrollImage();
	}
	public void setCollisionChecker(CollisionChecker collisionChecker) {
		super.setCollisionChecker(collisionChecker);
	}

	public void setPosition(Position positionExpect) {
		super.setPosition(positionExpect);
	}

	public void getTrollImage() {
		try {
			up1 = ImageIO.read(new File("res/images/enemies/troll/troll_up_1.png"));
			up2 = ImageIO.read(new File("res/images/enemies/troll/troll_up_2.png"));
			down1 = ImageIO.read(new File("res/images/enemies/troll/troll_down_1.png"));
			down2 = ImageIO.read(new File("res/images/enemies/troll/troll_down_2.png"));
			right1 = ImageIO.read(new File("res/images/enemies/troll/troll_right_1.png"));
			right2 = ImageIO.read(new File("res/images/enemies/troll/troll_right_2.png"));
			left1 = ImageIO.read(new File("res/images/enemies/troll/troll_left_1.png"));
			left2 = ImageIO.read(new File("res/images/enemies/troll/troll_left_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public void move(Direction direction) {

		if (!(collisionChecker.frontBlockIsSolid(direction, position))) {

			switch (direction) {
				case UP:
					position.setY(position.getY() - advance);
					break;
				case DOWN:
					position.setY(position.getY() + advance);
					break;
				case RIGHT:
					position.setX(position.getX() + advance);
					break;
				case LEFT:
					position.setX(position.getX() - advance);
					break;
			}

		} else {
			switch (direction) {
				case UP:
					this.direction = Direction.RIGHT;
					break;
				case DOWN:
					this.direction = Direction.LEFT;
					break;
				case RIGHT:
					this.direction = Direction.DOWN;
					break;
				case LEFT:
					this.direction = Direction.UP;
					break;
			}
		}
	}

	@Override
	public void draw(Graphics2D g2, int tileSize) {
		BufferedImage image = null;
		switch (direction) {
			case UP:
				image = up1;
				break;
			case DOWN:
				image = down1;
				break;
			case LEFT:
				image = left1;
				break;
			case RIGHT:
				image = right1;
				break;
		}
		g2.drawImage(image, this.position.getX() * tileSize, this.position.getY() * tileSize, tileSize, tileSize, null);
	}

}