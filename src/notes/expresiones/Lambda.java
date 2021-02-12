package expresiones;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Lambda {
    //La expresion lambda se puede utilizar de muchas maneras:

    public static void main(String[] args) {
        JButton b = new JButton();

        //ActionListener's --SOLO SIRVE CUANDO LA INTERFAZ SOLO IMPLEMENTA UN MÉTODO
        b.addActionListener (
                (ActionEvent e) -> proceso ()
        );
    }
    public static void proceso(){}; //Static!!
}
