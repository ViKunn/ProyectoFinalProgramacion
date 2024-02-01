package main;

import EstadosDelPrograma.CorriendoJuego;
import HadwareExterno.Teclado;
import main.RecursosExternos.RecursosExternos;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class HiloLógicaDelJuego extends Thread {
    /**
     * ¿Qué es un "hilo" en JAVA?
     * <p>
     * Los threads (hilos) o también llamados subprocesos es una característica de Java que permite
     * la ejecución simultánea de dos o más partes de un programa para la máxima utilización de la CPU.
     * Cada parte de dicho programa se denomina thread (hilo). Entonces, los hilos son procesos livianos
     * dentro de un proceso.
     * <p>  En resumen:   La implementación de hilos nos sirve para poder ejecutar varios procesos al mismo tiempo,
     * es como borrar el horizonte de limites que nos impone la programación secuencial</p>
     * <p> Aplicación en este programa: Vamos a usar el thread del JFrame este se encargará de los procesos que daremos
     * a la ventana, sin embargo crearemos otro thread para la lógica del juego, dividiendo dichos procesos en dos.</p>
     */
    private final Canvas lienzoDelJuego;
    private static final int ANCHO_LIENZO = 1200;// Inicialmente, tenemos que hacer coincidir estos valores con los de la ventana del JFrame
    private static final int LARGO_LIENZO = 750;
    private boolean enProceso;

    /**
     * ¿Qué es "Canvas" en JAVA?
     * <p>
     * El Canvas es una clase en Java que pertenece al paquete java.awt y se utiliza para proporcionar
     * un área gráfica en la cual se pueden realizar dibujos. Es un componente que se puede agregar a
     * contenedores como Frame, JFrame, Panel, etc., y permite realizar operaciones de dibujo directamente sobre él.
     * Un Canvas proporciona un lienzo en el que puedes dibujar gráficos personalizados, como líneas, rectángulos,
     * texto, imágenes, etc. Puedes manejar eventos de ratón y teclado en un Canvas si es necesario para tu aplicación.
     * <p>  En resumen: A la ventana o panel, le estoy poniendo un área donde voy a ubicar los gráficos del juego
     */
    public BufferStrategy buffer;
    /**
     * ¿Qué es un "buffer" en JAVA?
     * <p>
     * En informática, un búfer (del inglés, buffer) es un espacio de memoria, en el que se almacenan
     * datos de manera temporal, normalmente para un único uso (generalmente ocupan un sistema de cola FIFO);
     * su principal función es evitar que el programa o recurso que los requiere, ya sea hardware o software,
     * se quede sin datos durante una transferencia (entrada/salida) de datos irregular o por la velocidad del proceso.
     * <p>  En resumen: Yo supongo que es usado para manejar datos que solo necesitamos en un momento dado, pero una
     * vez que este momento acaba ya no importan mas, en este caso la entrada de las teclas para el juego
     */
    public Graphics grafico;
    CorriendoJuego corriendoJuego;
    public Teclado teclado;


    public HiloLógicaDelJuego() {
        enProceso = true;
        lienzoDelJuego = new Canvas();
        configuracónDelFondoDePantalla();
        teclado = new Teclado();
        lienzoDelJuego.addKeyListener(teclado);
    }


    /**
     * ______________________________________________________________________________________________________________
     */
    @Override
    public void run() { //Este es el hilo principal del programa donde corre el juego y sus gráficos.

        init();
        while (enProceso) {
            actualizarDatos();
            dibujar();

        }

        finalizarHiloJuego();
    }

    /**
     * _______________________________________________________________________________________________________________
     */


    public void finalizarHiloJuego() {
        try {
            this.join();
            enProceso = false; //TODO: Nunca se llega acá porque el bucle es true todo el tiempo
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarDatos() {
        teclado.actualizar();
        corriendoJuego.actualizar();

    }


    public void dibujar() {
        buffer = lienzoDelJuego.getBufferStrategy();
        if (buffer == null) {
            lienzoDelJuego.createBufferStrategy(3);
            return;
        }


        grafico = buffer.getDrawGraphics();
        /* Los dibujos comienzan desde aquí */

        grafico.drawImage(RecursosExternos.fondoDelJuego, 0, 0, ANCHO_LIENZO, LARGO_LIENZO, null);
        //grafico.drawImage(RecursosExternos.player, 150, 100, null);


        grafico.drawImage(RecursosExternos.obstáculoHielo, 200, -50, null);
        grafico.drawImage(RecursosExternos.obstáculoHielo, 250, -50, null);
        for (int i = -50; i < 350; i += (50)) {
            grafico.drawImage(RecursosExternos.obstáculoHielo, 150, i, null);
        }
        grafico.drawImage(RecursosExternos.obstáculoHielo, 200, 300, null);
        grafico.drawImage(RecursosExternos.obstáculoHielo, 250, 300, null);

        //Líneas de los lados
        for (int i = -200; i < 500; i += (50)) {
            grafico.drawImage(RecursosExternos.obstáculoHielo, 0, i, null);
        }
        for (int i = -200; i < 500; i += (50)) {
            grafico.drawImage(RecursosExternos.obstáculoHielo, 720, i, null);
        }


        grafico.drawImage(RecursosExternos.obstáculoHielo, 500, -50, null);
        grafico.drawImage(RecursosExternos.obstáculoHielo, 450, -50, null);
        for (int i = -50; i < 350; i += (50)) {
            grafico.drawImage(RecursosExternos.obstáculoHielo, 550, i, null);
        }
        grafico.drawImage(RecursosExternos.obstáculoHielo, 500, 300, null);
        grafico.drawImage(RecursosExternos.obstáculoHielo, 450, 300, null);


        grafico.drawImage(RecursosExternos.monstruo, 300, 200, null);


        corriendoJuego.dibujar(grafico);

        /* Los dibujos terminan acá */
        grafico.dispose();
        buffer.show();


    }

    /*************** Métodos con menor Relevancia ********************************/
    private void configuracónDelFondoDePantalla() {
        lienzoDelJuego.setPreferredSize(new Dimension(ANCHO_LIENZO, LARGO_LIENZO)); //Es como poner una capa sobre la ventana y le digo su tamaño
        lienzoDelJuego.setMaximumSize(new Dimension(ANCHO_LIENZO, LARGO_LIENZO)); // Le pongo limites para que no se pueda expandir
        lienzoDelJuego.setMinimumSize(new Dimension(ANCHO_LIENZO, LARGO_LIENZO));
        lienzoDelJuego.setFocusable(true); //Para ir verificando si se está usando el teclado
    }


    public Component getLienzoDelJuego() {
        return lienzoDelJuego;
    }

    public void agregarRecursosExternos() {
        RecursosExternos.agregarRecursos(); // Qué belleza los métodos estáticos
    }
    private void init()
    {
        RecursosExternos.agregarRecursos();
        corriendoJuego = new CorriendoJuego();
    }
}
