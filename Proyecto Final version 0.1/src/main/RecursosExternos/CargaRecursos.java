package main.RecursosExternos;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CargaRecursos {

    /**
     *
     * En Java, un método estático es un método que pertenece a la clase en lugar de a una instancia específica de la clase.
     * Esto significa que puedes invocar un método estático sin necesidad de crear una instancia de la clase.
     * <p> Algunas características clave de los métodos estáticos son las siguientes:
     * No requieren una instancia de la clase: <p> Puedes llamar a un método estático directamente desde la clase, sin necesidad de crear un objeto de esa clase.
     * Acceso directo a miembros estáticos: <p> Un método estático puede acceder a variables estáticas y a otros métodos estáticos directamente. Sin embargo, no puede acceder a variables de instancia o invocar métodos de instancia sin una instancia específica.
     * Llamada a través de la clase: <p> Para invocar un método estático, usas el nombre de la clase, seguido por el nombre del método, por ejemplo, NombreDeClase.metodoEstatico().
     * No pueden hacer referencia a this:<p> Un método estático no puede hacer referencia a la instancia actual de la clase usando this, ya que no está vinculado a una instancia particular.
     * Comparten el mismo contexto estático: <p> Todos los objetos de la clase comparten la misma copia del método estático, y cualquier modificación hecha por un objeto afectará a todos los demás objetos de la misma clase.
     */

    public static BufferedImage cargarImagen(String direcciónDeMemoria){
        try {
            File archivo = new File(direcciónDeMemoria);
            return ImageIO.read(archivo);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;

    }


}

