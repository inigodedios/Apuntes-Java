package BD;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDConceptos {
    /*
    1. ESTABLECER CONEXIÓN CON LA BD
    2. CREAR UN OBJETO STATETMENT
    3. EJECUTAR SENTENCIA SQL
     */
    Connection con = initBD("prueba.db");
    Statement st = con.createStatement();
    Statement st1 = usarBD(con != null ? con : null); //El método usarBD nos devuelve lo que esta en la linea anterior.
//    cerrarBD(con, st);


    // Inicializa una BD SQLITE nada mas ejecutar (es automatico)
    static String nombreBD = "prueba.db"; //EL NOMBRE SIEMRE DEBE INCLUIR .db (DataBase) si no crea un fichero de texto
    static {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD ); //Establecer la conexion con la BD
        } catch (ClassNotFoundException | SQLException e) {
        }
    }


    /** Inicializa una BD SQLITE y devuelve una conexión con ella
     * @param nombreBD	Nombre de fichero de la base de datos
     * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
     */
    public static Connection initBD(String nombreBD ) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD ); //Establecer la conexion con la BD
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }


    /** Crea las tablas de la base de datos. Si ya existen, las deja tal cual.Devuelve un statement para trabajar con esa base de datos
     * @param con	Conexión ya creada y abierta a la base de datos
     * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
     */
    public static Statement usarBD(Connection con ) {
        try {
            Statement statement = con.createStatement(); //Nos conectamos con la BD
            statement.executeUpdate("create table Usuario "+
                    "(nick string, "+
                    " contraseña string)");

            return statement;
        } catch (SQLException e) {
            return null;
        }
    }

    /** Crea las tablas de la base de datos. Si ya existen, las deja tal cual
     * @param con	Conexión ya creada y abierta a la base de datos
     * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
     */
    public static Statement usarCrearTablasBD (Connection con) {
        //statement.executeUpdate(""); --> Cuando queramos hacer create, insert, delete, update, drop
        //statement.executeQuery ("") --> Cuando queramos hacer select
        //Drop vs delete --> Drop elimina tabla y contenido; Delete --> elimina contenido pero no la tabla (tampoco las cabeceras)
        //Si queremos que nos devuelva algo, utilizar un resulset
        try {
            Statement st = con.createStatement(); //Conectamos la base de datos mediante la conexion "con" al statement, con el cual vamos a hacer consultas
            try{
                st.executeUpdate("create table prueba (columna1 string, columna2 string)"); //Opción1
                String consulta = "create table prueba (columna1 string, columna2 string)";
                st.executeUpdate(consulta); //Opción 2
            }catch (SQLException e){ } //Crea las tablas de la base de datos. Si ya existen, las deja tal cual
            return st;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /** Reinicia en blanco las tablas de la base de datos.
     * UTILIZAR ESTE MÉTODO CON PRECAUCIÓN. Borra todos los datos que hubiera ya en las tablas
     * @param con	Conexión ya creada y abierta a la base de datos
     * @return	sentencia de trabajo si se borra correctamente, null si hay cualquier error
     */
    public static Statement reiniciarBD( Connection con ) {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("drop table if exists Usuario");
            return usarCrearTablasBD( con );
        } catch (SQLException e) {
            return null;
        }
    }


    /** Cierra la base de datos abierta
     * @param con	Conexión abierta de la BD
     * @param st	Sentencia abierta de la BD
     */
    public static void cerrarBD( Connection con, Statement st ) {
        try {
            if (st!=null) st.close();
            if (con!=null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public BDConceptos() throws SQLException { //Debido a la linea Statement st = con.createStatement();
    }
}
