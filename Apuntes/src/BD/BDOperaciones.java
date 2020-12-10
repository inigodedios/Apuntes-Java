package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static BD.BDConceptos.cerrarBD;
import static BD.BDConceptos.initBD;

public class BDOperaciones {

    /*
    * Nos devuelve  true si existe el usuario
    * */
    public static boolean existeUsuario(String nick) {
        //statement.executeUpdate : Cuando queramos hacer create, insert, delete, update, drop
        //statement.executeQuery : Cuando queramos hacer select
        //Utilizamos resulset porque nos devuelve un usuario
        boolean existe = false;

        String sql = "SELECT * FROM Usuario WHERE nick ='"+nick+"'"; //Comillas simples!!
        Connection con = initBD("academia.db");
        Statement st;
        try {
            st = con.createStatement(); //Creo el objeto sentencia
            ResultSet rs = st.executeQuery(sql); //Ejecutamos la consulta
            if(rs.next()) { //rs.next() -> Devuelve true si rs tiene datos, false en caso contrario
                rs.getString("con");
                existe = true;
            }
            cerrarBD(con, st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }

    public static void insertarUsuario(String nick, String con) {

        String s = "INSERT INTO Usuario VALUES('"+nick+"','"+con+"')";
        Connection c = initBD("academia.db");
        try {
            Statement st = c.createStatement();
            st.executeUpdate(s);
            cerrarBD(c, st);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
