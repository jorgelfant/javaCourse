package f_cadenasCaracteres;

import java.util.Scanner;

public class f_palindrome {
    public static void main(String[] args) {
        //Disenar un algoritmo que tomando como entrada una cadena de texto nos devuelva si es palindromo o no.
        //Se conocde que se denomina palindromo a una palabra o frase que, ignorando los blancos, se lee igual
        //de izquierda a derecha que de derecha a izquierda
// reconocer oso      anita lava la tina    anit al aval atina
        String cadena;
        boolean siEs;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca una cadena");
        cadena = sc.nextLine();
        //basta con que la primera comparacion de 1 y ultimo no sea igual pa saber que no es palindromo
        //------------------------------------------------------------------------------------------------------------------
        //                                            WHILE PARA PALINDROME
        //------------------------------------------------------------------------------------------------------------------
        //MI METODO si mio!!
        siEs = true;

        int i = 0;
        int j = cadena.length() - 1;//cuando se compara uno con otro hay length-1

        while (i < j && siEs) {
            while (cadena.charAt(i) == ' ') {//Cambie y puso estos 2 while antes en caso de que la palabra tuviera espacios al inicio
                i++;                         // ala//  por ejemplo  esto tratara los espacios en caso de que hayan desde el inicio
            }
            while (cadena.charAt(j) == ' ') {
                j--;
            }
            if (cadena.charAt(i) != cadena.charAt(j)) {//basta con que haya una sola falsa y ya no es palindrome
                siEs = false;                            //da igual si otras letras si son iguales
            }                                          //ya entro asi que el valor queda en falso dentro del while
            i++;
            j--;
            //estos 2 whiles van a asegurarse de recorrer los espacios para poder llegar a la letra correspondiente de un lado
            //y del otro osea de inicio y final y asi poder compararlos, borre el if antes del while pk funciona con o sin
        }
        //------------------------------------------------------------------------------------------------------------------
        //                                            FIN WHILE Y CONSTANTACION
        //------------------------------------------------------------------------------------------------------------------
        if (!siEs) {
            System.out.println("La cadena no es palindrome");
        } else {
            System.out.println("La cadena si es palindrome");
        }
        //CON EL METODO DEL TUTORIAL SE HACE LO QUE YO PENSE AL INICIO
        //CON UN FOR QUITAR LOS ESPACIOS CON OTRO FOR INVERTIRLO Y AL FINAL CON OTRO FOR
        // o simplemente con frase1.equals(fraseInvertida)COMPARARLO
        // 0 con ultimo 1 con pen..etc  con este metodo se podria haber hecho sin boolean
    }
}


