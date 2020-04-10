package e_vectores_uni;

import java.util.Scanner;

public class m_MAxMin {
  public static void main(String[] args) {
    /*Crear un arreglo con "n" numeros, lee los elementos por teclado
    guardelos en el arreglo, calcule cual de los numeros es mayor y cual es el menor
    */
    int elementos;
     /*esto funciona metodo 1
    int max = 0; ca marche avant le tableau
    int min = 999999;   */

    Scanner sc = new Scanner(System.in);

    System.out.println("Ingresar el numero de elementos deseado ");
    elementos = sc.nextInt();

    int[] tab = new int[elementos];

    for (int i = 0; i < tab.length; i++) {
      System.out.println("Ingrese un numero");
      tab[i] = sc.nextInt();
    }
    //ces 2 valeurs doivent etre apres avoir rempli le tableau sinon ils sont vides
    int max = tab[0];
    int min = tab[0];
    // alternativa int min = max; para cuando bulco el minimo if (tab[j] < min)

    for (int i = 0; i < tab.length; i++) {//o for each
      if (tab[i] > max) {
        max = tab[i];
      }
    }
    for (int j = 0; j < tab.length; j++) {
      if (tab[j] < min) {
        min = tab[j];
      }
    }
    System.out.println("El maximo es " + max + " y el minimo es " + min);

  }
}
