package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static BD.BDConceptos.initBD;

public class BDOperaciones {

    /*
     * Nos devuelve  true si existe el usuario
     * */
    public static boolean existeUsuario(String nick) {
        //statement.executeUpdate : Cuando queramos hacer create, insert, delete, update, drop
        //statement.executeQuery : Cuando queramos hacer select
        //Utilizamos resulset porque nos DEVUELVE algo (un boolean en este caso)
        boolean existe = false;

        String sql = "SELECT * FROM Usuario WHERE nick ='"+nick+"'"; //Comillas simples!!
        Connection con = initBD("academia.db");
        Statement st;
        try {
            st = con.createStatement(); //Creo el objeto sentencia
            ResultSet rs = st.executeQuery(sql); //Ejecutamos la consulta
            if(rs.next()) { //rs.next() -> Devuelve true si rs tiene datos, false en caso contrario
                rs.getString("Usuario"); //En que columna queremos que compruebe el nick
                existe = true;
            }
            BDConceptos.cerrarBD(con, st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }

    public static void insertarUsuario(String nick, String contraseña) {

        String s = "INSERT INTO Usuario VALUES('"+nick+"','"+con+"')";
        Connection c = initBD("academia.db");
        try {
            Statement st = c.createStatement();
            st.executeUpdate(s);
            BDConceptos.cerrarBD(c, st);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Borra la tabla, es decir, tanto su contenido como la tabla en si
    public static void borrarTabla(String nombreBD, String nombreTabla) {
        String s = "drop table if exists "+nombreTabla;
        Connection con = initBD(nombreBD);
        Statement st = null;

        try {
            st = con.createStatement();
            st.executeUpdate(s);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BDConceptos.cerrarBD(con, st);
        }
    }


    //Crea una nueva tabla
    public static void crearNuevaTabla(String nombreBD, String nomTabla) {
        borrarTabla(nombreBD, nomTabla);
        String s = "create table if not exists " + nomTabla + " (nombre string, email string, duracion string, horaInicio string, horaFin string)";
        Connection con = initBD(nombreBD);
        Statement st = null;

        try {
            st = con.createStatement();
            st.executeUpdate(s);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BDConceptos.cerrarBD(con, st);
        }
    }

    //Inserta nueva tupla/fila
    public static void insertarNuevaFila(String nombreBD, String nomTabla, String nombre, String email, String duracion, String horaInicio, String horaFin) {
        String s = "insert into "+nomTabla+" values('"+nombre+"','"+email+"','"+duracion+"','"+horaInicio+"','"+horaFin+"')";
        Connection con = initBD(nombreBD);
        Statement st = null;

        try {
            st = con.createStatement();
            st.executeUpdate(s);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BDConceptos.cerrarBD(con, st);
        }
    }

    //Obtiene todas las filas
    public static ArrayList<ArrayList<String>> obtenerTodasLasFilas(String nombreBD, String nomTabla){
        ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
        Connection con = initBD(nombreBD);//initBD devuelve una connection
        Statement st = null;
        String s = "SELECT * FROM "+nomTabla;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(s);
            while(rs.next()) {
                ArrayList<String> fila = new ArrayList<>();
    				/*fila.add(rs.getString(1));
    				fila.add(rs.getString(2));
    				fila.add(rs.getString(3));
    				fila.add(rs.getString(4));
    				fila.add(rs.getString(5));*/
                for(int i=1;i<=5;i++)
                    fila.add(rs.getString(i));
                datos.add(fila);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return datos;
    }


}
