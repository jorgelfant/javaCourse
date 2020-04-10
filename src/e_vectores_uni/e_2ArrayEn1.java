package e_vectores_uni;

import java.util.Scanner;

public class e_2ArrayEn1 {
  public static void main(String[] args) {
    /*Hacer un programa que lea 10 numeros por teclado, 5 para un array ,5 para otro distinto
      al final mostrar los 10 numeros en un solo array */
    int[] tab1 = new int[5];
    int[] tab2 = new int[5];
    int[] tabF = new int[10];
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < 10; i++) {
      System.out.println("Ingrese un numero");
      if (i <= 4)
        tab1[i] = sc.nextInt();
      else
        tab2[i - 5] = sc.nextInt();//tab2[0]
    }
    for (int j = 0; j < tabF.length; j++) {
      if (j <= 4)
        tabF[j] = tab1[j];
      else
        tabF[j] = tab2[j - 5];//tab2[0]
      //System.out.println(tabF[j]); imprime uno a uno
    }
    for (int indices : tabF) {// each for
      System.out.println(tabF[indices]);
    }
  }
}
