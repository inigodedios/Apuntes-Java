package EscrituraEnFicheros;

import java.io.*;
import java.util.TreeSet;

public class FicherosBinarios {

    public static void main(String[] args) {

        String ts = "prueba";

        //ESCRIBIR EN UN FICHERO BINARIO
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("Coches.dat"));
            oos.writeObject(ts);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) { //TODO
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //LEER UN FICHERO BINARIO
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Coches.dat"));
            TreeSet<Object> tsDelFichero = (TreeSet<Object>) ois.readObject();
            System.out.println("El número de coches almacenados en el fichero es: " + tsDelFichero.size());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

