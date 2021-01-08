package Componentes;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JTableA {
    //Existen dos formas de crear tablas, usando una matriz de datos o mediante DefaultTableModel.
    //Nosotros vamos a usar siempre el DefaultTableModel

    //COMPONENTES IMPORTANTES
    private JTable tabla; //La tabla
    private DefaultTableModel tModel; //Para hacer CAMBIOS en la TABLA
//    private DefaultTableCellRenderer; //Para hacer cambios en las celdas de la tabla


    private void mostrarDatosConTableModel (){
        tabla = new JTable();
        tModel = new DefaultTableModel(); //Definimos el objeto tableModel
        tabla.setModel(tModel); //NO se porque da error, pero esta bien. Se importa mal
        tModel.addColumn("Nombre");
        tModel.addColumn("Apellido");
        tModel.addColumn("DNI");

        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.getTableHeader().setReorderingAllowed(false);


        //Error porque se importan mal las clases
        tabla.setDefaultRenderer(String.class, new DefaultTableCellRenderer() { //String.class porque el cambio va suceder en los String y DefaultTableCellRenderer porque el cambio va a suceder en los cell
           /*hacer new TableCellRenderer que nos implementa unos metodos, ya que es una interfaz, coger los métodos que
            nos interesen y cambiar el nombre a DefaultTableCellRenderer
           */
            public Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { //Devuelve la forma en la que se dibuja la celda
                //La linea superior es un metodo llamado getTableCellRendererComponent
                Color colorLetraAnterior = table.getForeground();
                Font fuenteAnterior = table.getFont();
                Color anterior = table.getBackground();
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //Forma en la que esta dibujada la celda antes de hacer un cambio
                if(row==0 && column==0) {
                    c.setForeground(Color.MAGENTA);
                }else {
                    c.setForeground(colorLetraAnterior);
                }
                if(row==0) {
                    c.setBackground(Color.GREEN);
                }else {
                    c.setBackground(anterior);
                }
                if(column==0) {
                    c.setFont(new Font(Font.SERIF, Font.BOLD, 16));
                }else {
                    c.setFont(fuenteAnterior);
                }
                return c;
            }
        });
    }


}