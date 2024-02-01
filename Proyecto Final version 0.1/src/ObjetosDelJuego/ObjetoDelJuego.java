package ObjetosDelJuego;

import FisicaYMates.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class ObjetoDelJuego {

    protected BufferedImage imagen;
    protected Vector2D posiciónDelObjeto;

    public ObjetoDelJuego(BufferedImage imagen,Vector2D posiciónDelObjeto) {
        this.imagen = imagen;
        this.posiciónDelObjeto = posiciónDelObjeto;
    }

    public abstract void actualizar();
    public abstract void dibujar(Graphics grafico);

    public Vector2D getPosiciónDelObjeto() {
        return posiciónDelObjeto;
    }

    public void setPosiciónDelObjeto(Vector2D posiciónDelObjeto) {
        this.posiciónDelObjeto = posiciónDelObjeto;
    }
}
