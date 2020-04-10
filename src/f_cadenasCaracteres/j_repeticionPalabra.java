package f_cadenasCaracteres;

import java.util.Scanner;

public class j_repeticionPalabra {
    public static void main(String[] args) {
        //realizar un programa que permita contabilizar cuantas veces una palabra(subcadena) se repite dentro de una frase
        String frase;
        String subFrase;
        String palabra = "";

        int conteo = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una frase");
        frase = sc.nextLine();


        System.out.println("Ingrese una palabra que desea buscar para saber cuantas veces se repite");
        subFrase = sc.nextLine();

        int i = 0;
        while (i < frase.length()) {
            if (frase.charAt(i) != ' ') {
                palabra = palabra.concat(frase.substring(i, i + 1));
            }
            if (frase.charAt(i) == ' ' || i == frase.length()-1) {//i+1 pa que tenga en cuenta la ultima palabra
                if (subFrase.equals(palabra)) {
                    conteo++;
                }
                palabra = "";
            }//if y no else if porque en la ultima iteracion deben ejecutarse los 2 el 1er if pa hacer la ultima palabra
            i++;//y el 2do if para entrar y hacer la comparacion
        }
        System.out.println("La palabra en la frase se repite " + conteo + " veces");
        //substring no es muy aptoo a este tipo de comparaciones, pa sabes al final cuantas veces ta una palabra deberiamos
        // agregar 1 a conteo
    }
}

