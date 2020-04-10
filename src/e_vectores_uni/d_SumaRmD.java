package e_vectores_uni;

import java.util.Scanner;

public class d_SumaRmD {
  public static void main(String[] args) {
    //Hacer un programa que lea 5 numeros, los almacene en un array y muestre la suma resta multiplicacion y div de todos
    int[] tab = new int[5];
    int suma = 0;
    int resta = 0;
    int multi = 1;
    int div = 1;

    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < tab.length; i++) {
      System.out.println("Ingrese un numero");
      tab[i] = sc.nextInt();

      suma = suma + tab[i];
      resta = resta - tab[i];
      multi = multi * tab[i];
      div = tab[i] / div;
    }
    System.out.println(suma + " " + resta + " " + multi + " " + div);
  }
}
