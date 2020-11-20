package Operadores;

import javax.swing.*;

public class Operadores {
    public static void main(String[] args) {
        //OPERADOR TERNARIO TODO Marian
        //Sintaxis --> (expresion)?valor_true:valor_false;
        int vble1 = 5;
        int vble2 = 4;
        int mayor;
        mayor = (vble1 > vble2) ? vble1 : vble2;
        System.out.println("El mayor de los dos números es " + mayor);


        //OPERADOR INSTANCEOF
        //Mediante el operador instanceof podemos comprobar si un objeto es de una clase concreta.
        //Sintaxis --> objeto instanceof clase
        JButton boton = null;
        if (boton instanceof JButton) {
            System.out.println("error");//No es de la misma clase

        }
    }
}
