package EscrituraEnFicheros;

import java.io.*;

public class FicherosDeTexto {
    public static void main(String[] args) {
        //ESCRIBIR EN UN FICHERO DE TEXTO
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("Ejemplo.txt");
            pw.println("Hola");
            pw.println("vamos a crear un fichero de texto");

        } catch (FileNotFoundException e) {
            e.printStackTrace(); //Muestra mensaje de error
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }

        //LEER DE UN FICHERO DE TEXTO
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("Ejemplo.txt"));
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}