package Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JListA extends JFrame {
    //COMPONENTES IMPORTANTES
    DefaultListModel modeloLista; //Datos de la lista
    JList lista; //La lista en si

    /**
     * PASOS A SEGUIR
     * 1. Crear DefaultListModel
     * 2. Crear un JList pasando por parametro el DefaultListModel
     */

    JPanel pPrincipal, pOeste, pCentro;
    JLabel lAnyadir;
    JTextField tfAnyadir;
    JButton bAnyadir, bBorrar, bBorrarTodos;

    //TODO ScrollPane / ScrollBar

    public JListA (){
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pPrincipal = new JPanel(new BorderLayout());
        pOeste = new JPanel(new BorderLayout());
        pCentro = new JPanel(new FlowLayout());
        lAnyadir = new JLabel("Añadir elemento a la lista");
        tfAnyadir = new JTextField();
        bAnyadir = new JButton("Añadir elemento a la lista");
        bBorrar = new JButton("Borrar");
        bBorrarTodos = new JButton("Borrar todo!");

        modeloLista = new DefaultListModel();
        lista = new JList(modeloLista);

        pOeste.add(lista);
        pCentro.add(lAnyadir);
        pCentro.add(tfAnyadir);
        pCentro.add(bAnyadir);
        pCentro.add(bBorrar);
        pCentro.add(bBorrarTodos);

        pPrincipal.add(pOeste, BorderLayout.WEST);
        pPrincipal.add(pCentro, BorderLayout.CENTER);
        add(pPrincipal);

        for(int i = 0; i<10; i++){
            modeloLista.addElement("Elemento "+ i);
        }

        //EVENTOS
        bAnyadir.addActionListener(e -> {String anyadir = tfAnyadir.getText(); modeloLista.addElement(anyadir); tfAnyadir.setText("");});
        bBorrarTodos.addActionListener(e -> {modeloLista.clear();});

        /**
         * //TODO NO funciona bien, elimina todoo el rato el primer elemento
         */
        bBorrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int posicion = lista.locationToIndex(e.getPoint());
                modeloLista.remove(posicion);
            }
        });

        //DECORACIONES
        tfAnyadir.setPreferredSize(new Dimension(200,200));
    }

    public static void main(String[] args) {
        JListA v = new JListA();
        v.setVisible(true);



    }


}
