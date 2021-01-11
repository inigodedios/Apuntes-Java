package EscrituraEnFicheros;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Log {
    private static Logger l;
    private static Logger log;
    /*
     * - Un logger es una forma de registrar lo que un programa va haciendo que nos servirán en un futuro para, por ejemplo,
     * estadísticas de uso, determinar como se están usando una cosa u  otra…
     * - Recomendable crear ficheros .xml, ya que es mas facil de visualizar
     * - Hay siete niveles para controlar el logging output; segun como de detallado queramos la información. IMPORTANTE-->
     * si seleccionamos el level INFO, solo nos saldrá información acerca de ese nivel o los siguientes (INFO,
     * SEVERE y WARNING), no los anteriores.
     */

    public static void main(String[] args) throws IOException {
        log = Logger.getLogger("Ejemplo"); //Lo que es esta entre parentesis es el nombre que le damos al logger para el "subsistema"

        //El HANDLER es un gestor de ficheros de logger
        //true para que no se sobreescriba, sino que se ENCADENE la información
        Handler fh = new FileHandler("fichero.xml", true); //Nombre que le damos al archivo. Puede ser un .txt, .csv...

        log.addHandler (fh);

        log.setLevel(Level.SEVERE);
        fh.setLevel(Level.SEVERE); //Tambien hay que establecer el nivel en el que va a tener que trabajar el FileHander

        //Ejemplo de como registrar
        log.log(Level.INFO, "Inicio de sesión" + (new Date())); //Se registra el mensaje + la fecha a nivel INFO

    }

    //LOG MÉTODO
    //Acuerdate de llamarlo en el main
    public static Logger creacionDeLogger() {
        l = null;
        try {
            Handler h = new FileHandler("fichero.xml", true);
            l = Logger.getLogger( "loggerOutput" );
            l.addHandler( h );
            l.setLevel( Level.INFO );
            h.setLevel( Level.INFO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }



    //LOG FUERA AL INICAR LA CLASE!!
    static {
        Logger log = null;
        try {
            log.addHandler( new FileHandler(".log.xml", true ));
        } catch (Exception e) {
            log.log( Level.SEVERE, "Error en creación fichero log" );
        }
    }

}
