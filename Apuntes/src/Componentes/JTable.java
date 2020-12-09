package Componentes;


import javax.swing.table.DefaultTableModel;

public class JTable {
    /*Existen dos formas de crear tablas, usando una matriz de datos o mediante DefaultTableModel.
    *Nosotros vamos a usar siempre el DefaultTableModel
    */

    private JTable tabla;
    private DefaultTableModel tModel; //Modelo de la tabla

//    TODO
    //Cambio de color
    //mirar examen 11 de dicembre 2020 codigo de preparatorio

    private void mostrarDatosConTableModel (){
        tabla = new JTable();
        tModel = new DefaultTableModel(); //Definimos el objeto tableModel
        tabla.setModel(tModel); //NO se porque da error, pero esta bien. Se importa mal
        tModel.addColumn("Nombre");
        tModel.addColumn("Apellido");
        tModel.addColumn("DNI");

        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.getTableHeader().setReorderingAllowed(false);

    }
}
