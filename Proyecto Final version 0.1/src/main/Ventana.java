package main;
import EstadosDelPrograma.CorriendoJuego;
import javax.swing.*; //para crear la ventana


public class Ventana extends JFrame {
    private static final int ANCHO_VENTANA = 1200;// static para no malgastar memoria y final porque no quiero que cambie
    private static final int LARGO_VENTANA = 750; //Controlo el ancho y la altura de la ventana emergente
    HiloLógicaDelJuego hiloLógicaDelJuego;


    public Ventana() { // Constructor de la clase Ventana
        this.hiloLógicaDelJuego = new HiloLógicaDelJuego();
        configuraciónDeVentana();
    }

    public void comenzarHiloJuego() {
        hiloLógicaDelJuego.start(); // Este método lo que va a hacer es comenzar la ejecución del metodo run() dentro la clase HiloLógicaDelJuego

    }


    /***************** Métodos con menor Relevancia ************************/
    private void configuraciónDeVentana() {
        setTitle("BAD ICE CREAM"); // le doy nombre a la main.Ventana que se va a desplegar
        setSize(ANCHO_VENTANA, LARGO_VENTANA); // Tamaño de la pantalla Size - Tamaño (width-Ancho height-Altura)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para permitir al usuario cerrar la Ventana y con ello acabar la ejecucion del programa
        setResizable(false); // Para no permitir que el usuario modifique el tamaño de la pantalla
        setLocationRelativeTo(null); //Que aparezca la pantalla en el centro, si no pongo esto se va a la parte superior izquierda
        setVisible(true); // Hacer visible la pantalla creada
        this.add(hiloLógicaDelJuego.getLienzoDelJuego()); // A la ventana le estoy agregando el lienzo encima
    }



}
