package Componentes;

import javax.swing.*;
import java.awt.*;

public class JMenu extends JFrame {
    //Para crear menús --> 1º JMenuBar, 2º Jmenu, 3º JMenuItem

    private JPanel p;
    private JMenuBar menuBar;
    private JMenu menu1, menu2, menu3;
    private JMenuItem menuItem21, menuItem22, menuItem31, menuItem32;

    public JMenu (){
        p = new JPanel(new BorderLayout());
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    menuBar = new JMenuBar();
    menu1 = new JMenu();
    menuBar.add(menu1);

    }

    public static void main(String[] args) {
        JMenu v = new JMenu();
        v.setVisible(true);
    }

}
