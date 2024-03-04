package business.entities.enemies;

import business.entities.Direction;
import business.entities.Position;
import business.interfaces.Movable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BlueCow extends Enemy implements Movable{

   Position positionToFollow;

   public BlueCow(){
       positionToFollow = new Position();
       getBlueCowImage();
   }

    public void follow() {

        Position positionFollow = this.positionToFollow;

        int distanceX = positionFollow.getX() - this.position.getX(); //Es la distancia en X entre el BlueCow y el player //3
        int distanceY = positionFollow.getY() - this.position.getY(); //Es la distancia en Y entre el BlueCow y el player //3

        int valorAbsolutoDistanceX = (distanceX >= 0) ? distanceX : -distanceX;
        int valorAbsolutoDistanceY = (distanceY >= 0) ? distanceY : -distanceY;

        if (valorAbsolutoDistanceX > valorAbsolutoDistanceY) {
            if (distanceX > 0) {            // El movimiento del BlueCow (izquierda o derecha) depende del signo de la distancia
                move(Direction.RIGHT);
            } else {
                this.direction = Direction.LEFT;
                move(Direction.LEFT);
            }
        } else {
            if (distanceY > 0) {
                this.direction = Direction.DOWN;
                move(Direction.DOWN);
            } else {
                this.direction = Direction.UP;
                move(Direction.UP);
            }
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

        } else if (!(collisionChecker.trappedBetweenBlocks(this.position))){
            switch (direction) {
                case UP:
                    this.direction = Direction.RIGHT;
                    move(Direction.RIGHT);
                    break;
                case DOWN:
                    this.direction = Direction.LEFT;
                    move(Direction.LEFT);
                    break;
                case RIGHT:
                    this.direction = Direction.DOWN;
                    move(Direction.DOWN);
                    break;
                case LEFT:
                    this.direction = Direction.UP;
                    move(Direction.UP);
                    break;
            }

        }

    }

    public void passPositionToFollow(Position position) {
        this.positionToFollow = position;
    }

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


    public void getBlueCowImage() {
        try {
            up1 = ImageIO.read(new File("res/images/blueCow/blueCow_up_1.png"));
            up2 = ImageIO.read(new File("res/images/blueCow/blueCow_up_1.png"));
            down1 = ImageIO.read(new File("res/images/blueCow/blueCow_down_1.png"));
            down2 = ImageIO.read(new File("res/images/blueCow/blueCow_down_1.png"));
            right1 = ImageIO.read(new File("res/images/blueCow/blueCow_right_1.png"));
            right2 = ImageIO.read(new File("res/images/blueCow/blueCow_right_1.png"));
            left1 = ImageIO.read(new File("res/images/blueCow/blueCow_left_1.png"));
            left2 = ImageIO.read(new File("res/images/blueCow/blueCow_left_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}