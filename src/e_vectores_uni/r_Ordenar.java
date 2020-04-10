package e_vectores_uni;

import java.util.Scanner;

public class r_Ordenar {
    public static void main(String[] args) {
    /*Leer 5 elementos numericos que se introduciran de manera creciente.
    Estos los guardaremos en un arreglo de tamanio 6.
    Leer un numero N; e insertanlo en el lugar adecuado para que el arreglo
    continue ordenando.*/
        //tab[6]= 1 2 3 5 6      por ejemplo en orden cresciente con la ultima posicion vacia
        //        0 1 2 3 4 5
        //si se introduce por ejemplo el 4 este deberia ir entre el 3 y el 5
        int numero;
        int faltante;
        int posicion = 0;
        int k = 0;

        Scanner sc = new Scanner(System.in);

        int[] tab = new int[6];

        boolean creciente; //Porque el arreglo esta en forma cresciente hasta que demostremos lo contraio

        do {
            creciente = true;
            for (int i = 0; i < tab.length - 1; i++) {
                System.out.println("Ingrese un numero");
                numero = sc.nextInt();
                tab[i] = numero;
            }
            for (int j = 0; j < tab.length - 2; j++) {//hasta 3  0 1 2 3 4    4 iteraciones entre 5 numeros
                if (tab[j] > tab[j + 1]) {//esto contempla todas las alternativas sobrantes
                    creciente = false;
                }
            }//esto me permitira comprobar si esta ordenado
            if (!creciente) {//creciente==false
                System.out.println("El arreglo no esta ordenado de manera creciente, vuelva a intentarlo");
            }
        } while (!creciente);

        System.out.println("Digite el valor del numero que falta");
        faltante = sc.nextInt();

        //recorremos el arreglo para saber donde insertar el valor
        while (tab[k] < faltante && k < 5) {//j=5 es el numero de elementos presentes en el arreglo
            posicion++;                      // 1 2 3 5 6         4
            k++;                             // 0 1 2 3 4
        }
        //5
        for (int i = tab.length - 1; i > posicion; i--) {//4>3    5 numeros 4 iteraciones
            tab[i] = tab[i - 1];     //1 2 3 5 6 _
        }                     // 0 1 2 3 4 5
        //ou
    /*
    for (int i = 4; i >= posicion; i--) {//4>3    5 numeros 4 iteraciones
      tab[i+1] = tab[i];     //1 2 3 5 6 _
    }
    **/
        System.out.println("indice donde debe ir el numero faltante " + posicion);//
        tab[posicion] = faltante;//pongo en el indice 3 el numero faltante // 1 2 3   5 6
        // 0 1 2 3 4 5
        for (int indice : tab) {//4>3
            System.out.print(indice + " ");
        }
    }

}

