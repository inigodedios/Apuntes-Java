package BD;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDConceptos {
    /**                                             IMPORTANTE
    1. ESTABLECER CONEXIÓN CON LA BD
    2. CREAR UN OBJETO STATEMENT
    3. EJECUTAR SENTENCIA SQL
    4. SI ES SELECT --> ADEMAS CREAR UN RESULSET, DONDE SE EJECUTA LA SENTENCIA

    //TODO Preguntar Marian
    Sólo se abre una vez la conexion (initBD(...))
    Sólo se crea un Connection una vez
    Por cada sentencia, un objeto nuevo statement (y resulset si es necesario)
    Se debe cerrar la la sentencia y el resulset cada vez que acabemos de usarlos.
     */

    static Connection con;

    public static void main(String[] args) {
        initBD("prueba.db");
        //Operaciones con la base de datos
        cerrarBD(con);
    }

    /**                                        INICIAR BASE DE DATOS
     * Opción 1: Llamar al metodo initBD (...)
     * Opción 2: Inicializa una BD SQLITE nada mas ejecutar (es automatico), como aparece a continuación
     */
    static String nombreBD = "prueba.db"; //EL NOMBRE SIEMRE DEBE INCLUIR .db (DataBase) si no crea un fichero de texto
    static {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD ); //Establecer la conexion con la BD
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    /** Inicializa una BD SQLITE
     * @param nombreBD	Nombre de fichero de la base de datos
     * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
     */
    public static void initBD(String nombreBD ) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD ); //Establecer la conexion con la BD
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    /** Crea las tablas de la base de datos. Si ya existen, las deja tal cual.Devuelve un statement para trabajar con esa base de datos
     * @param con	Conexión ya creada y abierta a la base de datos
     * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
     */
    public static void usarBD(Connection con ) {
        try {
            Statement statement = con.createStatement(); //Nos conectamos con la BD
            statement.executeUpdate("create table Usuario (nick string, contraseña string)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Crea las tablas de la base de datos. Si ya existen, las deja tal cual
     * @param con	Conexión ya creada y abierta a la base de datos
     * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
     */
    public static void usarCrearTablasBD (Connection con) {
        //statement.executeUpdate(""); --> Cuando queramos hacer create, insert, delete, update, drop
        //statement.executeQuery ("") --> Cuando queramos hacer select
        //Drop vs delete --> Drop elimina tabla y contenido; Delete --> elimina contenido pero no la tabla (tampoco las cabeceras)
        //Si queremos que nos devuelva algo, utilizar un resulset
        try {
            Statement st = con.createStatement(); //Conectamos la base de datos mediante la conexion "con" al statement, con el cual vamos a hacer consultas
            try{
                st.executeUpdate("create table prueba (columna1 string, columna2 string)"); //Opción1
                st.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /** Reinicia en blanco las tablas de la base de datos.
     * UTILIZAR ESTE MÉTODO CON PRECAUCIÓN. Borra todos los datos que hubiera ya en las tablas
     * @param con	Conexión ya creada y abierta a la base de datos
     * @return	sentencia de trabajo si se borra correctamente, null si hay cualquier error
     */
    public static void reiniciarBD( Connection con ) {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("drop table if exists Usuario");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /** Cierra la base de datos abierta
     * @param con	Conexión abierta de la BD
     */
    public static void cerrarBD( Connection con) {
        try {
            if (con!=null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BDConceptos() throws SQLException { //Debido a la linea Statement st = con.createStatement();
    }
}
