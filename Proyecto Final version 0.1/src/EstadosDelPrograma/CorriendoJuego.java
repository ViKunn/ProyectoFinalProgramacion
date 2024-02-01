package EstadosDelPrograma;

import FisicaYMates.Vector2D;
import ObjetosDelJuego.Player;
import main.RecursosExternos.RecursosExternos;

import java.awt.*;

public class CorriendoJuego {
    private Player player;

    public CorriendoJuego() {

        player = new Player(RecursosExternos.player, new Vector2D(10, 300));
    }

    public void actualizar() {

        player.actualizar();
    }

    public void dibujar(Graphics grafico) {

        player.dibujar(grafico);
    }


}
