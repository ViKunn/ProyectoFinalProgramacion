package HadwareExterno;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    private boolean[] teclas = new boolean[256]; //256 es el número de teclas que pose KeyListener
    public static boolean arriba, abajo, izquierda, derecha;

    public Teclado() {
        arriba = false;
        abajo = false;
        izquierda = false;
        derecha = false;
    }

    public void actualizar() {
        arriba = teclas[KeyEvent.VK_UP];
        izquierda = teclas[KeyEvent.VK_LEFT];
        derecha = teclas[KeyEvent.VK_RIGHT];
        abajo = teclas[KeyEvent.VK_DOWN];
    }



    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}// No lo vamos a usar pero es el contrato quien me obliga a ponerlo aquí
}
