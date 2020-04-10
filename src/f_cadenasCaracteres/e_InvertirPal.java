package f_cadenasCaracteres;

import java.util.Scanner;

public class e_InvertirPal {
    public static void main(String[] args) {
        //cambiar una cadenas de caracteres al reves
        String cadena;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una cadena");
        cadena = sc.nextLine();
        //------------------------------------------------------------------------------------------------------------------
        //                                                    METHODO 1
        //------------------------------------------------------------------------------------------------------------------
        ///METHODO 1 ALMACENAR EN UN CHAR ET IR IMPRIMIENDO 1 a 1

        char inverser;//invierto letra por letra de derecha a izquierda

        for (int i = 0; i < cadena.length(); i++) {//ou while
            inverser = cadena.charAt(cadena.length() - i - 1);//-1 - 2 etc
            System.out.print(inverser);
        }

        System.out.println();//salto de linea para separar los 2 metodos

        //------------------------------------------------------------------------------------------------------------------
        //              METHODO 2 ALMACENAR EN UN STRING IMPRIMIR AL FINAL FUERA DEL FOR LA PALABRA
        //------------------------------------------------------------------------------------------------------------------

        String inverso = "";//invierto letra por letra de derecha a izquierda

        for (int i = cadena.length(); i > 0; i--) {//ou while
            inverso += cadena.charAt(i - 1);// voy concatenando varios caracteres forman un char, si hubiera solo uno no se podria
        }
        System.out.print(inverso);

        System.out.println();//salto de linea para separar los 2 metodos

        //------------------------------------------------------------------------------------------------------------------
        //METHODO 3 ALMACENAR EN UN STRING IMPRIMIR AL FINAL FUERA DEL FOR LA PALABRA CON CONCAT solo con strings
        //------------------------------------------------------------------------------------------------------------------

        String invers = "";//invierto letra por letra de derecha a izquierda

        for (int i = cadena.length(); i > 0; i--) {//ou while
            invers = invers.concat(cadena.substring(i - 1, i));// voy concatenando varios caracteres forman un char, si hubiera solo uno no se podria
        }
        System.out.print(invers);
    }
}

