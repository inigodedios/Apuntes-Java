package componentes;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTableYJScrollPaneA extends JFrame{
    /**
     * Existen dos formas de crear tablas, usando una matriz de datos o mediante DefaultTableMode. Nosotros vamos a usar siempre el DefaultTableModel
     * Como una tabla puede tener muchos datos, lo vamos a hacer en un scrollPane para que tenga un scrollBar
     */

    //COMPONENTES IMPORTANTES
    JScrollPane pScrollPane; //En este panel ira la tabla, con scrollbar por defecto
    private JTable tTabla; //La tabla en si
    private DefaultTableModel modeloTabla; //Datos de la TABLA (columnaas, filas...)
    //private DefaultTableCellRenderer; //Para hacer cambios en las celdas de la tabla, tanto datos como aspecto. Coger un dato y si es X, cambiar de color

    /**
     * IMPORTANTE
     * - Aunque los datos se menipulen desde el modelo, podemos obtener datos de la tabla (getValue(x,y)) tanto con la tabla como con el modelo
     *   tTabla.getValue(4,5) || modeloTabla.getValue(4,5)
     *
     * - Si metemos nuevos datos o queremos cambiar los datos por otros, al añadir, lo hace al final! Por lo que
     *   debemos borrar el contenido --> modeloTabla.setNumRows(0);
     *
     * - Si por cualquier cosa, no se refresca la tabla al añadir, eliminar, actulizar... datos o tenemos problemas
     *   con la visualización de la tabla, ademas de los típicos metodos revalidate(), repaint(), updateUI(), también
     *   podemos hacer --> tabla.setModel(modeloTabla) ya hace que refresca la IU (confirmar si es cierto, aunque en un principio si)
     */

    /**
     * PASOS A SEGUIR ESTRICTAMENTE!!
     * 1. Crear DefaultTableModel
     * 2. Crear JTable -- Pasar por parametro el DefaultTableModel
     * 3. Crear JScrollPane -- Pasar por parametro la JTabla
     * 4. Establecer en el panel el ScrollBar (para que aparezca)
     * 5. Crear Array de String con los nombres de las columnas,  y arrays del contenido de la tabla.
     * 6. Asignarle al modelo el nombre de las columnas y  añadir filas (tambien al modelo)
     *
     */
    JPanel pPrincipal;

    private JTableYJScrollPaneA (){
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pPrincipal = new JPanel(new BorderLayout());

        modeloTabla = new DefaultTableModel();
        tTabla = new JTable(modeloTabla);
        pScrollPane = new JScrollPane(tTabla); //pScrollPane.setViewportView(tTabla)
        pScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tTabla.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        String nombreColumnas [] = {"Columna 1", "Columna 2", "Columna 3", "Columna 4", "Columna 5"};
        String fila1 [] = {"11", "12", "13", "14", "prueba"};
        String fila2 [] = {"21", "22", "23", "24", "25"};
        String fila3 [] = {"21", "32", "33", "34", "35"};

        //1º establecer columnas y despues filas. Si no, las filas salen vacias!
        modeloTabla.setColumnIdentifiers(nombreColumnas);
        for (int i = 0; i<40; i++){
            String fila [] = {i+"", i+"", i+"", i+"", i+""};
            modeloTabla.addRow(fila);
        }


        /**
         *
         */


        //IMPORTANTE --> NO hay que añadir al panel pScrollPane la tTbala(pScrollPane.add(tTbala)). Ya se hace en el paso 3!!
        pPrincipal.add(pScrollPane, BorderLayout.CENTER);
        add(pPrincipal);

        //Poner siempre Object.class!! Si no da problemas
        tTabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() { //O.class porque el cambio va suceder en los String y DefaultTableCellRenderer porque el cambio va a suceder en los cell
            /**
             * hacer new TableCellRenderer que nos implementa unos metodos, ya que es una interfaz. Coger los métodos que
             * nos interesen y cambiar el nombre a DefaultTableCellRenderer
             */
            @Override //TODO
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //Forma en la que esta dibujada la celda antes de hacer un cambio
                //Debemos operar con table, value, isSelected, hasFocus, row y column para que se apliquen los cambios en la tabla

                String s = (String) value;
                boolean seleccionado = isSelected;
                boolean foco = hasFocus;
                int fila = row;
                int columna = column;

                if(row==0 && column==0) {
                    c.setForeground(Color.MAGENTA);
                }else {
                    //RECOMENDABLE HACER EL ELSE! porque a veces falla
                }

                if(row==0) {
                    c.setBackground(Color.GREEN);
                }else {
                }

                return c;
            }
        });

        //Obetener datos de la tabla y añadir a la base de datos
        for(int i=0;i<modeloTabla.getRowCount();i++) {
            //DESDE LA COLUMNA Y FILA 0!!
            String celdai0 = modeloTabla.getValueAt(i, 0).toString();
            String celdai1 = modeloTabla.getValueAt(i, 1).toString();
            String celdai2 = modeloTabla.getValueAt(i, 2).toString();
            String celdai3 = modeloTabla.getValueAt(i, 3).toString();
            String celdai4 = modeloTabla.getValueAt(i, 4).toString();

            String fila [] = {celdai0, celdai1, celdai2, celdai3, celdai4};
           //baseDeDatos.insertarFila(fila);
        }

        //Obtener fila y columnsa del JTable donde se hace click
        tTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tTabla.rowAtPoint(e.getPoint());
                int columna = tTabla.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1))
                    System.out.println(modeloTabla.getValueAt(fila,columna));
            }
        });

        //Al pulsar una tecla sucede...
        tTabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyCode()== KeyEvent.VK_F1)
                    System.out.println("Has pulsado F1 keyListener");
            }
        });

        //Al hacer doble click, sucede...
        tTabla.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()>=2) {

                    int fila = tTabla.rowAtPoint( e.getPoint() );
                    int columna = tTabla.columnAtPoint( e.getPoint() );

                }
            }
        });
    }

    public static void main(String[] args) {
        JTableYJScrollPaneA v = new JTableYJScrollPaneA();
        v.setVisible(true);
    }
}
