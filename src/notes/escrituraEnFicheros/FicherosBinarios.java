package escrituraEnFicheros;

import java.io.*;
import java.util.TreeSet;

public class FicherosBinarios  implements Serializable{

    public static void main(String[] args) {

        String ts = "prueba";

        //ESCRIBIR EN UN FICHERO BINARIO
        ObjectOutputStream oos = null; //Sirve para poder escribir (output) (controla el flujo)

        try {
            oos = new ObjectOutputStream(new FileOutputStream("Coches.dat"));
            oos.writeObject(ts); //Escribimos. El objeto debe ser SERIALIZABLE. SE DEBE IMPORTAR SERIALIZABLE
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (oos != null) {
                    oos.flush(); //Liberar buffer
                    oos.close();//Cerramos escritura. Ya no se puede modificar el archivo
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //LEER UN FICHERO BINARIO
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Coches.dat"));
            TreeSet<Object> tsDelFichero = (TreeSet<Object>) ois.readObject(); //Hay que hacer casting
            System.out.println("El número de coches almacenados en el fichero es: " + tsDelFichero.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

