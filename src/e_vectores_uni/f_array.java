package e_vectores_uni;

import java.util.Scanner;

public class f_array {
  public static void main(String[] args) {
    /*Hacer un programa que lea 5 numeros por teclado, los copie a otro array multiplicacos por 2
     y muestre el 2do array*/
    int[] tab1 = new int[5];
    int[] tab2 = new int[5];
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < tab1.length; i++) {
      System.out.println("Ingrese un numero");
      tab1[i] = sc.nextInt();
    }
    for (int i = 0; i < tab2.length; i++) {
      tab2[i] = tab1[i] * 2;
      //System.out.println(tab2[i]);
    }
    for (int indice : tab2) {
      System.out.println(indice);
    }
  }
}
