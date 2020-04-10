package d_funciones;

import java.util.Scanner;

public class w_RecursividadPot {
    public static void main(String[] args) {
        //Escribir una funcion recursiva para elevar un numero a una potencia
        int base;
        int exponente;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una base");
        base = sc.nextInt();
        System.out.println("Ingrese un exponente");
        exponente = sc.nextInt();
        //si pudiera utilizar la referencia podria poner los valores direntamente en la funcion
        //von lo de arriba
        System.out.println(potencia(base, exponente));

    }
    private static int potencia(int base, int exponente) {
        if (exponente == 0) {//caso base
            return 1;
        } else {//caso recursivo
            return base * potencia(base, exponente - 1);//vamos disminuyendo el exponente
        }//ej: 5^3= 5 * 5^2 que vendria ser  5 * 5 * 5^1 =  5 * 5 * 5 * 5^0* OSEA 5 * 5 * 5 * 1
    }
}
//5^3==
//5* 5^2
//5*5^1
//5*5^0
//OU
/*
5 * 5^2
-    5 * 5^1
     -    5 * 5^0  = 125
          -
*/

