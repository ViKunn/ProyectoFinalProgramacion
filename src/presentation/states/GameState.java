package presentation.states;

import business.GameLogic;
import presentation.KeyControl;

import java.awt.*;
import java.awt.event.KeyListener;
import javax.swing.*;

public class GameState extends State {
    private final Dimension dimension;
    private final GameLogic gameLogic;
    private KeyControl keyControl;

    private static final int FPS = 60;
    private final int tileSize;
    private Thread threadGameState;

    public GameState(Dimension dimension, int tileSize) {
        this.dimension = dimension;
        this.tileSize = tileSize;

        gameLogic = new GameLogic();
        setInitialValues();
        threadGameState = new Thread(this);
        // Inicia el juego
        gameLogic.startLevel(1);
        // Instancia y asigna KeyControl como KeyListener
        keyControl = new KeyControl(gameLogic);
        //this.addKeyListener(keyControl);
        //setFocusable(true);
        //requestFocusInWindow();
        //keyControl.startThread();

        System.out.println("" + gameLogic.isRunningAndAlive());




    }

    private void setInitialValues() {
        setPreferredSize(dimension);
        setBounds(tileSize * 5, 7, tileSize * 18, tileSize * 18);
    }

    @Override
    public void start() {
        threadGameState.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // TODO considerar variable
        while (gameLogic.isRunningAndAlive()) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                this.addKeyListener(keyControl);
                setFocusable(true);
                requestFocusInWindow();
                keyControl.keyTyped(evento); // o keyControl.keyPressed(evento);
                keyControl.delayForKeyboardInput(200); // 200 milisegundos de retraso
                delta--;

            }
        }
    }

    public void update() {
        gameLogic.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        gameLogic.draw(g2, tileSize);
        g2.dispose();
    }
}
