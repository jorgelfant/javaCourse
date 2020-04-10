package e_vectores_uni;

import java.util.Scanner;

public class v_BusquedaSec1Num {
  public static void main(String[] args) {
    /*Dado un determinado valor, se trata de ver si existe un elemento con ese valor en el arreglo
      o archivo donde se busca, tal que se devuelva si esta o no
      HAY 2 TIPOS DE BUSQUEDA:
      1) SECUENCIAL: se puede aplicar para busquedas internas y externas si hay que ir pasando
      secuencialmete por todos los elementos de la estructura hasta encontrar el elemento o acabar la lista
      no importa si estan ordenados o no
      2) BINARIA
     */

    int elementos;
    int numero;
    int posicion = 0;
    boolean encontrado = false;
    Scanner sc = new Scanner(System.in);
    //--------------------------------------------------------------------------------
    System.out.println("Ingrese el numero de elementos");
    elementos = sc.nextInt();
    int[] tab = new int[elementos];

    for (int i = 0; i < tab.length; i++) {
      System.out.println("Ingrese un numero");
      tab[i] = sc.nextInt();
    }
    //--------------------------------------------------------------------------------
    //                  BUSQUEDA DEL NUMERO EN EL ARREGLO
    //--------------------------------------------------------------------------------
    System.out.println("Ingrese el numero que desea buscar");
    numero = sc.nextInt();
    int j = 0;
    while (j < tab.length && !encontrado) {//recorre el arreglo
      if (tab[j] == numero) {
        encontrado = true;
       //ou posicion = j;
      }
      j++;
    }
    //PARECIDO A s_borrarPosit
    if (!encontrado) {
      System.out.println("El numero ingresado no esta en el tab");
    } else {
      System.out.println("El numero se encontraba en la posicion " + (j-1));//ou posicion
    }
  }
}
