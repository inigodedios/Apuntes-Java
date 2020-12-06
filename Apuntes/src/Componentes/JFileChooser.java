package Componentes;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JFileChooser {
    public static void main(String[] args) {
        String txtRuta = "";
        JButton btnBuscarFoto = new JButton("BUSCAR FOTO");
        btnBuscarFoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
                //Abrir el explorador en un director en particular
                File directorio = new File("imagenes"); //imagenes --> ruta en el que quiero abrir el fichero
                fc.setCurrentDirectory(directorio);
                fc.setFileFilter(new FileNameExtensionFilter("TIPO JPG", "jpg"));
                fc.setFileFilter(new FileNameExtensionFilter("TIPO PNG", "png"));
                int sel = fc.showOpenDialog(btnBuscarFoto);
                if (sel == javax.swing.JFileChooser.APPROVE_OPTION) {
                    File ficheroSeleccionado = fc.getSelectedFile();
//                    txtRuta.setText("imagenes/" + ficheroSeleccionado.getName()); //TODO error?
                }
            }
        });
    }
}
