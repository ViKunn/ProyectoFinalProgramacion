package business.characters;

import business.Direction;
import business.Position;
import business.interfaces.Movable;
import business.managers.CollisionChecker;

public class BlueCow extends Enemy implements Movable, Runnable {

   Position positionToFollow;

   public BlueCow(){
       positionToFollow = new Position();
   }


    @Override
    public void run() {
        while (true) {
            follow(positionToFollow); // Mover el troll en la dirección actual

            try {
                Thread.sleep(500); // Esperar un medio segundo entre cada movimiento
            } catch (InterruptedException e) {
                // Manejar interrupciones del hilo si es necesario
                e.printStackTrace();
            }
        }
    }

    private void follow(Position position) {

        Position positionFollow = position;

        int distanceX = positionFollow.getX() - this.position.getX(); //Es la distancia en X entre el BlueCow y el player //3
        int distanceY = positionFollow.getY() - this.position.getY(); //Es la distancia en Y entre el BlueCow y el player //3

        int valorAbsolutoDistanceX = (distanceX >= 0) ? distanceX : -distanceX;
        int valorAbsolutoDistanceY = (distanceY >= 0) ? distanceY : -distanceY;

        if (valorAbsolutoDistanceX > valorAbsolutoDistanceY) {
            if (distanceX > 0) {            // El movimiento del BlueCow (izquierda o derecha) depende del signo de la distancia
                move(Direction.RIGHT);
            } else {
                move(Direction.LEFT);
            }
        } else {
            if (distanceY > 0) {
                move(Direction.DOWN);
            } else {
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
                    move(Direction.RIGHT); //TODO: EXPONER SAMIRA hermoso, una belleza, como yo jeje
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
                    move(Direction.UP);;
                    break;
            }

        } else return;

    }


    public void passPositionToFollow(Position position) {
        this.positionToFollow = position;
    }
}