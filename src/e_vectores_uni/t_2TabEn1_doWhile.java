package e_vectores_uni;

import java.util.Scanner;

public class t_2TabEn1_doWhile {
    public static void main(String[] args) {
    /*Leer 2 arreglos de 5 numeros enteros cada uno que estan ordenados crecientemente.
Copiar(fusionar) los 2 arreglos en un tercero, de forma que los numeros sigan ordenados.
*/
        int[] tab1 = new int[5];
        int[] tab2 = new int[5];
        int[] tabF = new int[10];


        Scanner sc = new Scanner(System.in);
        //do while buen metodo si queremos entrar en el bucle una vez sin condicion inicial
        //declarando afuera el boolean e iniciandolo adentro como true solo habra un if t[i] >t[i+1]
        //esto signfifica que al inicio es true y que si el 1er indice es superior al indice superior
        //esto es falso, los unicos 2 casos en lo que esto pasa son: 1) 5 4 3 2 1  2)1 3 5 2 1
        // lo cual quiere decir que el arreglo ha esta en orden creciente todoo  el tiempo o alguna vez
        // lo cual contradice al true inicial
        boolean ascendente;
        do {
            ascendente = true; //esto es necesario avec do while
            //estos 2 for avec 2 while o con while 2 for en el 2 habria if et else true y false
            for (int i = 0; i < tab1.length; i++) {
                System.out.println("Ingrese un numero");
                tab1[i] = sc.nextInt();
            }
            for (int i = 0; i < tab1.length - 1; i++) {
                if (tab1[i] > tab1[i + 1]) {
                    ascendente = false;
                }//ou un else para la alternativa contraria
            }
            if (!ascendente) {
                System.out.println("El arreglo 1 no esta ordenado, vuelva a intentarlo");
            }
        } while (!ascendente);

        //2do arreglo
        System.out.println("Arreglo 2");
        do {
            ascendente = true; //esto es necesario avec do while iniciando en true
            //estos 2 for avec 2 while o con while 2 for en el 2 habria if et else true y false
            for (int i = 0; i < tab2.length; i++) {
                System.out.println("Ingrese un numero");
                tab2[i] = sc.nextInt();
            }
            for (int i = 0; i < tab1.length - 1; i++) {
                if (tab2[i] > tab2[i + 1]) {
                    ascendente = false;
                }//ou un else para la alternativa contraria
            }
            if (!ascendente) {
                System.out.println("El arreglo 2 no esta ordenado, vuelva a intentarlo");
            }
        } while (!ascendente);
        /*El do while es la mejor alternativa si queremos utilizar solo una boolean asciende
         * iniciandolo adentro del do como true y dando solo un if que lo permita cambiar a false
         * este if dira que si en algun momento el indice anterior es superior al posterior
         * entonces ascendente es falso!!!
         *con el while tendriamos que tener creciente y decreciente iniciadas afuera como false
         * y ahi necesitariamos un if y un else if que vendria a decir que en el if siempre
         * debe ser asi y en el else if siempre debe ser del otro modo*/

        //LLENAMOS EL TABF
        // 1 3 5 7 9 tab1
        // 2 4 6 8 10 tab2
        //ESTE METODO SOLO ORDENA BIEN EN EL CASO QUE EL TAB1 ESTE EN ORDEN ASCENDENTE Y EL TAB2 TAMBIEN
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < 5 && j < 5) {
            if (tab1[i] < tab2[j]) {
                tabF[k] = tab1[i];
                i++;
            } else {
                tabF[k] = tab2[j];
                j++;
            }
            k++;//avanza el iterador de tabF
        }
        //Ya copiamos los 2 arreglos en el final pero no sabemos si todoo se copio
        if (i == 5) {//hemos terminado de copiar el arreglo 1, falta tab2
            while (j < 5) {
                tabF[k] = tab2[j];
                j++;
                k++;
            }
        } else if (j == 5) {//hemos terminado de copiar el arreglo 1, falta tab1
            while (i < 5) {
                tabF[k] = tab1[i];
                i++;
                k++;
            }
        }

        for (int l = 0; l < 10; l++) {
            System.out.print(tabF[l] + " ");
        }
    }
}
