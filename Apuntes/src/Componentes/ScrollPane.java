package Componentes;

import javax.swing.*;
import java.awt.*;
//SCROLLPANE NO ES LO MISMO QUE SCROLLBAR

public class ScrollPane extends JFrame {
    private JPanel contentPane;
    JLabel lNombre;
    JTextField tf;
    JScrollPane scrollPane;

    /**
     * Create the frame.
     */
    public ScrollPane() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        add(contentPane);

        JPanel panelNorte = new JPanel();
        contentPane.add(panelNorte, BorderLayout.NORTH);

        JPanel panelSur = new JPanel();
        contentPane.add(panelSur, BorderLayout.SOUTH);

        JPanel panelEste = new JPanel();
        contentPane.add(panelEste, BorderLayout.EAST);


        lNombre = new JLabel("Introduce tu nombre");

        tf = new JTextField();
        tf.setPreferredSize(new Dimension(100, 50));

        JButton boton = new JButton("Aceptar");

        scrollPane = new JScrollPane(); //NO se aprecia en la ventana! Creo que esta mal TODO
        panelSur.add(scrollPane, BorderLayout.CENTER); //TODO

        panelNorte.add(lNombre);
        panelNorte.add(tf);
        panelSur.add(boton);
    }

    public static void main(String[] args) {
        ScrollPane v = new ScrollPane();
        v.setVisible(true);
    }
}
