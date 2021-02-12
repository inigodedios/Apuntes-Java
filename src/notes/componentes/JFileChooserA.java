package componentes;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JFileChooserA {
    public static void main(String[] args) {
        String txtRuta = "";
        JButton btnBuscarFoto = new JButton("BUSCAR FOTO");
        btnBuscarFoto.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
                //Abrir el explorador en un director en particular
                fc.setCurrentDirectory(new File(".")); //Abre el directorio raiz de nuestra carpeta
                fc.setFileFilter(new FileNameExtensionFilter("TIPO JPG", "jpg"));
                fc.setFileFilter(new FileNameExtensionFilter("TIPO PNG", "png"));
                int sel = fc.showOpenDialog(null); //nos devulve un int, que hace referencia a la accion que hemos hecho
                if (sel == javax.swing.JFileChooser.APPROVE_OPTION) {
                    File ficheroSeleccionado = fc.getSelectedFile();
                    loQueQueremosQueHaga(ficheroSeleccionado.getAbsolutePath());
                }
            }
        });
    }

    private static void loQueQueremosQueHaga( String path) {
    }
}
