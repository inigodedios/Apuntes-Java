package EscrituraEnFicheros;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Log {
    private static Logger logger;
    /*
        - Un logger es una forma de registrar lo que un programa va haciendo que nos servirán en un futuro para, por ejemplo,
        estadísticas de uso, determinar como se están usando una cosa u  otra…
        - Recomendable crear ficheros .xml, ya que es mas facil de visualizar
        - Hay siete niveles para controlar el logging output; segun como de detallado queramos la información. IMPORTANTE-->
        si seleccionamos el level INFO, solo nos saldrá información acerca de ese nivel o los siguientes (INFO,
        SEVERE y WARNING), no los anteriores.
        */

    public static void main(String[] args) throws IOException {
        logger = Logger.getLogger("fichero.xml"); //Creamos fichero .xml. tambien puede ser .txt, ...
        logger.log(Level.INFO, "Inicio de sesión" + (new Date())); //Se registra el mensaje + la fecha a nivel INFO

        //El HANDLER es un gestor de ficheros de logger.
        Handler fh = new FileHandler("fichero.xml", true); //true para que no se sobreescriba, sino que se ENCADENE la información
        logger.addHandler (fh);

        logger.setLevel(Level.SEVERE);
        fh.setLevel(Level.SEVERE); //Tambien hay que establecer el nivel en el que va a tener que trabajar el FileHander


        //TODO
        //MIRAR SI ESTA BIEN CON MARIAN O ANDONI
        //QUIEN CREA EL ARCHIVO FICHERO.XML; EL LOGGER O EL HANDLER?
    }

    //LOG FUERA DE METODO!!
    static {
        Logger logger = null;
        try {
            logger.addHandler( new FileHandler(".log.xml", true ));
            //Ponemos a true para que no se sobreescriba, se ENCADENE la informacion
        } catch (Exception e) {
            logger.log( Level.SEVERE, "Error en creación fichero log" );
        }
    }

}
