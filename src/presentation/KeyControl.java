package presentation;

import business.GameLogic;
import business.entities.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl implements KeyListener {
    private GameLogic gameLogic;

    public KeyControl(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Este método se llama cuando se presiona y luego se libera una tecla
        char keyChar = e.getKeyChar();

        // Aquí puedes implementar las acciones que desees realizar con la tecla presionada
        // Por ejemplo:
        switch (keyChar) {
            case 'a':
                gameLogic.movePlayer(Direction.LEFT);
                break;
            case 'w':
                gameLogic.movePlayer(Direction.UP);
                break;
            case 's':
                gameLogic.movePlayer(Direction.DOWN);
                break;
            case 'd':
                gameLogic.movePlayer(Direction.RIGHT);
                break;
            case 'f':
                gameLogic.playerActivatePowerUp();
                break;
            case 'p':
                gameLogic.pauseGame();
                break;
        }

        char keyChar1 = e.getKeyChar();

        // Aquí puedes implementar las acciones que desees realizar con la tecla presionada
        // Por ejemplo:
        switch (keyChar1) {
            case 'j':
                gameLogic.movePlayer2(Direction.LEFT);
                break;
            case 'i':
                gameLogic.movePlayer2(Direction.UP);
                break;
            case 'k':
                gameLogic.movePlayer2(Direction.DOWN);
                break;
            case 'l':
                gameLogic.movePlayer2(Direction.RIGHT);
                break;
            case 'm':
                gameLogic.playerActivatePowerUp2();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Este método se llama cuando se presiona una tecla
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Este método se llama cuando se libera una tecla que estaba presionada
    }

    public void delayForKeyboardInput(int delay) {
        try {
            Thread.sleep(delay); // Introduce un pequeño retraso entre acciones de teclado
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}