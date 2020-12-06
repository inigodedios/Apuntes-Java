package Operadores;

import javax.swing.*;

public class Operadores {
    public static void main(String[] args) {
        //OPERADOR TERNARIO
        //Sintaxis --> Object o = (expresion)?valor1:valor2; Donde o recibira el valor1 en el caso de que la condicion sea true o el valor si es falso
        String s1 = "Prueba1";
        String s2 = "Prueba2";
        String s3 = (s1.equals(s2)) ? s1 : s2;
        System.out.println("El mayor de los dos números es " + s3);


        //OPERADOR INSTANCEOF
        //Mediante el operador instanceof podemos comprobar si un objeto es de una clase concreta.
        //Sintaxis --> objeto instanceof clase
        JButton boton = null;
        if (boton instanceof JButton) {
            System.out.println("Es de la misma clase");//No es de la misma clase
        }
    }
}
