package Recursividad;

import java.io.File;

public class Recursividad {

    //Ejemplo de cargar un archivo de forma recursiva
    private void gestionarDirectorioRecursivo(java.util.List<File> lista, int i) {
        if(i<lista.size()) {
            File f = lista.get(i);
            if(f.isDirectory())
                gestionarDirectorioRecursivo(lista, i+1);
            else {
                cargaCSVMeet( f.getAbsolutePath() );
                gestionarDirectorioRecursivo(lista, i+1);
            }
        }
    }

    private void cargaCSVMeet(String absolutePath) { }


}
