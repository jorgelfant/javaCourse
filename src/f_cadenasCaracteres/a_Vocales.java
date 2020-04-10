package f_cadenasCaracteres;

import java.util.Scanner;

public class a_Vocales {
    public static void main(String[] args) {
        //Disenie un programa que permita ingresar una cadena de caracteres y detecte cuantas vocales tiene
        String cadena;
        int conteo = 0;
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};//hubieramos podido tambien hacer un string  String vocales="aeiou"
        Scanner sc = new Scanner(System.in);                                                 //y comparar

        System.out.println("Ingrese una cadena");
        cadena = sc.nextLine();
        //------------------------------------------------------------------------------------------------------------------
        //                  COMPARACION ELEMENTOS DE LA CADENA Y VOCALES
        //------------------------------------------------------------------------------------------------------------------
        int[] repeticiones = new int[vocales.length];// 5 vocales tamanio del arreglo vocales
        // del arreglo
        //ARREGLOS donde se guardaran las posiciones de cada letra, uno por letra
        int[] posicionesA = new int[cadena.length()];//mas letras mas cases habrian por eso cojemos el tamanio de la cadena
        int[] posicionesE = new int[cadena.length()];
        int[] posicionesI = new int[cadena.length()];
        int[] posicionesO = new int[cadena.length()];
        int[] posicionesU = new int[cadena.length()];

        for (int i = 0; i < cadena.length(); i++) {
            for (int j = 0; j < vocales.length; j++) {//a e i o u  = 0 1 2 3 4
                if (cadena.charAt(i) == vocales[j]) {//si entra aqui es que hay una vocal en la palabra o frase
                    conteo++;//cuantas vocales hay   la j accorde vocales y repeticiones
                    repeticiones[j] += 1;//eso me va decir cuantas veces se repite cada vocal!!
                }//posiciones          vocales y repeticiones estan sincronizadas y tienen el mismo tamanio abcde=01234
            }
            if (cadena.charAt(i) == 'a') {//estas condiciones me permiten saber en que posiciones se repiten las letras
                posicionesA[i] += 1;
            } else if (cadena.charAt(i) == 'e') {
                posicionesE[i] += 1;
            } else if (cadena.charAt(i) == 'i') {
                posicionesI[i] += 1;
            } else if (cadena.charAt(i) == 'o') {
                posicionesO[i] += 1;
            } else if (cadena.charAt(i) == 'u') {//si else solo con else if
                posicionesU[i] += 1;
            }
        }
        //------------------------------------------------------------------------------------------------------------------
        //                                   IMPRESION REPETICIONES
        //------------------------------------------------------------------------------------------------------------------
        System.out.println("En la palabra hay " + conteo + " vocales");
    /*esto me da las repeticiones de cada letra a la vez
    for (int FluentApiTest = 0; FluentApiTest < cadena.length(); FluentApiTest++) {//maximo length repeticiones ou FluentApiTest  conteo
      if (repeticiones[FluentApiTest] != 0) {//pa que imprima solo los repetidos
        System.out.println(vocales[FluentApiTest] + " se repite " + repeticiones[FluentApiTest] + " veces ");
      }
    }*/
        //------------------------------------------------------------------------------------------------------------------
        //                IMPRESION DE POSICIONES GUARDADAS EN ARREGLOS A  E I O U
        //------------------------------------------------------------------------------------------------------------------
        char rep;//esto me permite entrar
        System.out.println("Desea saber en que posiciones se encuentra una determinada letra ?");
        rep = sc.nextLine().charAt(0);

        while (rep != 's' && rep != 'n') {
            System.out.println("la respuesta debe ser 'si' o 'no', intentelo de nuevo");
            rep = sc.nextLine().charAt(0);
        }
        if (rep != 's') {
            System.out.println("Hasta luego");
        } else {
            System.out.println("Ingrese la letra deseada para saber cuantas veces se repite y en que posiciones ");
            char vocal;
            vocal = sc.nextLine().charAt(0);
            //----------------------------------------------------------------------------------------------------------------
            //                EL BOOLEAN PERMITE CONFIRMAR SI LA VOCAL ESTA DENTRO DE LA PALABRA O NO
            // ---------------------------------------------------------------------------------------------------------------
            boolean siEsta = false;
            while (!siEsta) { //cuando a e i  u necesitan ser comprobadas se usa && pero si estan aconpanadas de otra condicion mas
                for (int j = 0; j < cadena.length(); j++) {//a e i o u = 0 1 2 3 4    se hace como aqui la segunda condicion NO es accesoria
                    if ((vocal == cadena.charAt(j)) && (vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u')) {
                        siEsta = true;                 //si entra aqui es que hay una vocal en la palabra o frase
                    }                                //voca==a etc es con && pero si a estas 5 a e i o u se le acompana otra
                }                                  //condicion colo aqui entonces se une n las 2 con && y las de dentro con ||
                if (!siEsta) {
                    System.out.println("La letra debe formar parte de la palabra, y debe ser una vocal ");
                    vocal = sc.nextLine().charAt(0);
                }
            }
            //podrian hacerse 2 whiles
            //----------------------------------------------------------------------------------------------------------------
            //             EL WHILE VA FILTRAR LA VOCAL CON SUS 2 CONDICIONES
            // ---------------------------------------------------------------------------------------------------------------
            if (vocal == 'a') {
                System.out.print("'a' se repite " + repeticiones[0] + " veces en las posiciones ");
                for (int k = 0; k < posicionesA.length; k++) {//maximo lde lugares en los que puede estar
                    if (posicionesA[k] != 0) {//pa que imprima solo los repetidos
                        System.out.print(k + " ");
                    }
                }
            } else if (vocal == 'e') {
                System.out.print("'e' se repite " + repeticiones[1] + " veces en las posiciones ");
                for (int k = 0; k < posicionesE.length; k++) {//maximo lde lugares en los que puede estar
                    if (posicionesE[k] != 0) {//pa que imprima solo los repetidos
                        System.out.print(k + " ");
                    }
                }
            } else if (vocal == 'i') {
                System.out.print("'i' se repite " + repeticiones[2] + " veces en las posiciones ");
                for (int k = 0; k < posicionesI.length; k++) {//maximo lde lugares en los que puede estar
                    if (posicionesI[k] != 0) {//pa que imprima solo los repetidos
                        System.out.print(k + " ");
                    }
                }
            } else if (vocal == 'o') {
                System.out.print("'o' se repite " + repeticiones[3] + " veces en las posiciones ");
                for (int k = 0; k < posicionesO.length; k++) {//maximo lde lugares en los que puede estar
                    if (posicionesO[k] != 0) {//pa que imprima solo los repetidos
                        System.out.print(k + " ");
                    }
                }
            } else {
                System.out.print("'u' se repite " + repeticiones[4] + " veces en las posiciones ");
                for (int k = 0; k < posicionesU.length; k++) {//maximo lde lugares en los que puede estar
                    if (posicionesU[k] != 0) {//pa que imprima solo los repetidos
                        System.out.print(k + " ");
                    }
                }
            }
        }

    }
}
