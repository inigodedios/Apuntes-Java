package Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class JMenu extends JFrame {
    //Para crear menús --> 1º JMenuBar, 2º Jmenu, 3º JMenuItem

    private JPanel p;
    private JMenuBar menuBar;
    private JMenu menu1, menu2, menu3;
    private JMenuItem menuItem11, menuItem21, menuItem31, menuItem32;

    public JMenu (){
        p = new JPanel(new BorderLayout());
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        menu1 = new JMenu(); //TODO
        menu2 = new JMenu(); menu2.setMnemonic( KeyEvent.VK_V ); //TODO
        menu3 = new JMenu("Menú 3"); //TODO

        menuItem11 = new JMenuItem("Item11");
        menuItem21 = new JMenuItem("Item21");
        menuItem31 = new JMenuItem("Item31");
        menuItem32 = new JMenuItem("Item32");

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        menu1.add(menuItem11);
        menu2.add(menuItem21);
        menu3.add(menuItem31);
        menu3.add(menuItem32);

    }

    public static void main(String[] args) {
        JMenu v = new JMenu();
        v.setVisible(true);
    }

}
