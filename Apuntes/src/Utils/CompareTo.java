package Utils;

public class CompareTo implements Comparable <CompareTo>{

    private String nombre;
    private String dni;
    private int edad;

    public void CompareTo(String dni, String nombre, int edad) { //Constructor Alumno
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public int compareTo(CompareTo o) {
        //Si comparamos String
        return this.nombre.compareTo(o.nombre); //Vamos a ordenarlo ascendentemente por nombre
        //return this.dni.compareTo(o.dni);//Vamos a ordenarlo ascendentemente por dni
       // return o.dni.compareTo(this.dni); //Ordenado descendentemente por dni

        //Si comparamos cualquier atributo que no sea String
        //return this.edad - o.edad; //Ordenado ascendentemente por edad
        //return o.edad - this.edad; //Ordenado descendentemente por edad
    }
}