package ObjetosDelJuego;

import FisicaYMates.Vector2D;
import HadwareExterno.Teclado;
import jdk.jshell.execution.StreamingExecutionControl;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends ObjetoDelJuego{
    public Player(BufferedImage imagen, Vector2D posiciónDelObjeto) {
        super(imagen, posiciónDelObjeto);
    }

    @Override
    public void actualizar() {
        if (Teclado.derecha){
            posiciónDelObjeto.setPosiciónX(posiciónDelObjeto.getPosiciónX()+3);
        }
        if (Teclado.arriba){
            posiciónDelObjeto.setPosiciónY(posiciónDelObjeto.getPosiciónY()-3);
        }
        if (Teclado.abajo){
            posiciónDelObjeto.setPosiciónY(posiciónDelObjeto.getPosiciónY()+3);
        }
        if (Teclado.izquierda){
            posiciónDelObjeto.setPosiciónX(posiciónDelObjeto.getPosiciónX()-3);
        }
    }

    @Override
    public void dibujar(Graphics grafico) {
        grafico.drawImage(imagen,(int)posiciónDelObjeto.getPosiciónX(), (int)posiciónDelObjeto.getPosiciónY(), null);
    }
}
