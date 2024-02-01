package main.RecursosExternos;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RecursosExternos {

    public static BufferedImage player;
    public static BufferedImage monstruo;
    public static BufferedImage fondoDelJuego;
    public static BufferedImage obstáculoHielo;

    public static void agregarRecursos() {
        RecursosExternos.player = CargaRecursos.cargarImagen("C:\\Users\\Fernando_Huilca\\Documents\\" +
                "Git-Fernando_Huilca\\Cositas_Secretas\\Proyecto Final\\Proyecto Final version 0.1\\RecursosExtenosCarpeta" +
                "\\player2.png");
        RecursosExternos.monstruo = CargaRecursos.cargarImagen("C:\\Users\\Fernando_Huilca\\Documents\\" +
                "Git-Fernando_Huilca\\Cositas_Secretas\\Proyecto Final\\Proyecto Final version 0.1\\RecursosExtenosCarpeta" +
                "\\monstruo.png");
        RecursosExternos.fondoDelJuego = CargaRecursos.cargarImagen("C:\\Users\\Fernando_Huilca\\Documents\\" +
                "Git-Fernando_Huilca\\Cositas_Secretas\\Proyecto Final\\Proyecto Final version 0.1\\RecursosExtenosCarpeta\\" +
                "FondoIglu.png");
        RecursosExternos.obstáculoHielo = CargaRecursos.cargarImagen("C:\\Users\\Fernando_Huilca\\Documents\\" +
                "Git-Fernando_Huilca\\Cositas_Secretas\\Proyecto Final\\Proyecto Final version 0.1\\RecursosExtenosCarpeta\\" +
                "obstaculoHielo.png");

    }

}
