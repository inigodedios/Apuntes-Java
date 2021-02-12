package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class EjemploBDCompleto {

    public static ArrayList<ArrayList<Object>> datosUsuario;
    public static ArrayList<Object> tuplaUsuario;

    public static Connection con;

    public static void initBD(String nombreBD ) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
            //			log.log(Level.INFO, "Éxito al iniciar la BD");
        } catch (ClassNotFoundException | SQLException e) {
            //			log.log(Level.SEVERE, "Error al iniciar la BD");
        }
    }

    public static void crearTablas (Connection con) {
        try {
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            st.executeUpdate("CREATE TABLE if not exists Usuario (Nick string not null, Nombre string not null, Apellidos string not null, FechaNacimiento Date)");
            st2.executeUpdate("CREATE TABLE if not exists paraEliminar (column1 String)");
            st.close();
            st2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**Método que ELIMINA tanto los datos como la tabla
     * @param nombreTabla
     */
    public static void borrarTablaCompletamente(String nombreTabla) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DROP TABLE if exists " + nombreTabla);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**Elimina solo los datos de una tabla, no la tabla en si
     * @param nombreTabla
     */
    public static void borrarTablaContenido (String nombreTabla) {
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate("Delete FROM "+ nombreTabla);
            System.out.println("Tabla " + nombreTabla + " eliminada");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void insertarUsuario(String nick, String nombre, String apellidos, Date FechaNacimiento) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO USUARIO VALUES ('"+  nick + "','" + nombre+ "','"+apellidos +"','" +FechaNacimiento +"')");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean existeUsuario (String nick) {
        boolean existe = false;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select nick from Usuario where nick = '" + nick +"'");
            System.out.println(rs.getString("nick")); //TODO no funciona
            while (rs.next()) {
                if (rs.getString("nick") == nick) {
                    existe = true;
                    System.out.println("Ha entrado");
                }else {
                    System.out.println("NO ha entrado");
                    existe = false;
                }
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            existe = false;
            System.out.println("NONHa entrado");
        }
        return existe;
    }


    public static ArrayList<String> datosUsuario (Usuario u){
        ArrayList<String> usuario = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from Usuario where nick = '" + u.getNick() + "'"); //Opción 1
            PreparedStatement pst = con.prepareStatement("Select * from Usuario where nick = ?");//Opción2 --  Se deja la sentencia hecha, en el cual el ? es una variable
            pst.setString(1, u.getNick());//Opción2 -- La primera (1) variable con ?, toma el valor de u.getNick()
            ResultSet rs1 = pst.executeQuery();
            while (rs1.next()) {
                usuario.add(rs.getString(1));
                usuario.add(rs.getString("nombre"));
                usuario.add(rs.getString(3));
                usuario.add(rs.getString("FechaNacimiento"));
            }
            st.close();
            rs.close();
            System.out.println(usuario.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return usuario;
    }


    public static void eliminarUsuario (String nick) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM USUARIO where nick = '" + nick +"';");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ArrayList<Object>> obtenerDatosBBDD (){
        datosUsuario = new ArrayList<>();
        tuplaUsuario = new ArrayList();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from Usuario");
            while(rs.next()) {
                tuplaUsuario.add(rs.getString("nick"));
                tuplaUsuario.add(rs.getString(2));
                tuplaUsuario.add(rs.getString("apellidos"));
                tuplaUsuario.add(rs.getString(4));

                //Vemos la evolucion del contenido de los ArrayList
                datosUsuario.add(tuplaUsuario);
                System.out.println(tuplaUsuario.toString());
                System.out.println(datosUsuario.toString());

            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datosUsuario;
    }


    //Editar datos

    public static void editarUsuarioBBDD (String nick, String nombre, String apellidos, Date FechaNacimiento) {
        try {
            PreparedStatement pst = con.prepareStatement("Delete from Usuario where nick = ?");
            pst.setString(1, nick);
            Statement st2 = con.createStatement();
            st2.executeUpdate("Insert into Usuario values ('"+ nick +"','" + nombre + "','" + apellidos +"','" + FechaNacimiento + "')");
            pst.close();
            st2.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void cerrarBD(String nombreBBDD, Connection con) { //Aqui tendria que cerrrar el statement?
        if (con!=null)
            try {
                con.close();
                System.out.println("Bases de datos cerrada");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }





    public static void main(String[] args) {
        Usuario u1 = new Usuario("inigo", "Iñigo", "de Dios", new Date(2020, 01, 01));
        Usuario u2 = new Usuario("pedro", "Pedro", "Perez", new Date(2020, 01, 01));
        Usuario u3 = new Usuario("lucia", "Lucia", "Perez", new Date(2020, 01, 01));
        Usuario u4 = new Usuario("maria", "María", "Perez", new Date(2020, 01, 01));
        Usuario u5 = new Usuario("antonio", "Antonio", "Perez", new Date(2020, 01, 01));


        initBD("Libreria.db");
        borrarTablaContenido("Usuario");
        borrarTablaCompletamente("Usuario");
        crearTablas(con);
        borrarTablaCompletamente("paraEliminar");
        insertarUsuario(u1.getNick(), u1.getNombre(), u1.getApellidos(), u1.getFechaNacimiento());
        insertarUsuario(u2.getNick(), u2.getNombre(), u2.getApellidos(), u2.getFechaNacimiento());
        insertarUsuario(u3.getNick(), u3.getNombre(), u3.getApellidos(), u3.getFechaNacimiento());
        insertarUsuario(u4.getNick(), u4.getNombre(), u4.getApellidos(), u4.getFechaNacimiento());
        insertarUsuario(u5.getNick(), u5.getNombre(), u5.getApellidos(), u5.getFechaNacimiento());
        if (existeUsuario(u1.getNick())==true) {System.out.println("Existe el usuario inigo");}else {System.out.println("No existe el usuario inigo");}
        eliminarUsuario("antonio");
        System.out.println("Obetener datos del usuario Pedro");
        datosUsuario(u2);
        System.out.println("Obtener todos los datos de la base de datos:");
        obtenerDatosBBDD();
        editarUsuarioBBDD("lucia", "Lucia", "EDITADO", new Date(2000,01,01));
        cerrarBD("Libreria.db", con);



    }

    public static class Usuario{
        String nick, nombre, apellidos;
        Date FechaNacimiento;


        public Usuario(String nick, String nombre, String apellidos, Date fechaNacimiento) {
            this.nick = nick;
            this.nombre = nombre;
            this.apellidos = apellidos;
            FechaNacimiento = fechaNacimiento;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public Date getFechaNacimiento() {
            return FechaNacimiento;
        }

        public void setFechaNacimiento(Date fechaNacimiento) {
            FechaNacimiento = fechaNacimiento;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return super.toString();
        }

    }

}

