package Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class JListA extends JFrame {
    //COMPONENTES IMPORTANTES
    DefaultListModel modeloLista; //Datos de la jlLista
    JList jlLista; //La jlLista en si

    /**
     * PASOS A SEGUIR
     * 1. Crear DefaultListModel
     * 2. Crear un JList pasando por parametro el DefaultListModel
     * 3. Crear JPanel pasando por parametro el JList
     *
     * MÉTODOS PRINCIPALES
     * modeloLista.addElement
     * modeloLista.remove(posicion);
     * modeloLista.clear()
     */

    JPanel pPrincipal, pCentro;
    JScrollPane pOeste;
    JLabel lAnyadir;
    JTextField tfAnyadir;
    JButton bAnyadir, bBorrar, bBorrarTodos;

    //TODO ScrollPane / ScrollBar

    public JListA (){
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        modeloLista = new DefaultListModel();
        jlLista = new JList(modeloLista);
        pOeste = new JScrollPane(jlLista); //pOeste.setViewportView(jlLista)

        pPrincipal = new JPanel(new BorderLayout());
        pCentro = new JPanel(new FlowLayout());
        lAnyadir = new JLabel("Añadir elemento a la jlLista");
        tfAnyadir = new JTextField();
        bAnyadir = new JButton("Añadir elemento a la jlLista");
        bBorrar = new JButton("Borrar");
        bBorrarTodos = new JButton("Borrar todo!");

        jlLista.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        //NO hay que añadir al panel pOeste el jlLista(pOeste.add(jlLista)). Ya se hace en el paso 3!!
        pCentro.add(lAnyadir);
        pCentro.add(tfAnyadir);
        pCentro.add(bAnyadir);
        pCentro.add(bBorrar);
        pCentro.add(bBorrarTodos);

        pPrincipal.add(pOeste, BorderLayout.WEST);
        pPrincipal.add(pCentro, BorderLayout.CENTER);
        add(pPrincipal);

        for(int i = 0; i<40; i++){
            modeloLista.addElement("Elemento "+ i);
        }

        //EVENTOS
        bAnyadir.addActionListener(e -> {String anyadir = tfAnyadir.getText(); modeloLista.addElement(anyadir); tfAnyadir.setText("");});
        bBorrarTodos.addActionListener(e -> {modeloLista.clear();});

        /**
         * //TODO NO funciona bien, elimina cuando das dos veces a borrar
         */
        bBorrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
//                Object obj = jlLista.getSelectedValue();
                modeloLista.remove(jlLista.getSelectedIndex());
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