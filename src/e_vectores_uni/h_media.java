package e_vectores_uni;

import java.util.Scanner;

public class h_media {
  public static void main(String[] args) {
    //Hacer un programa que lea 10 numeros por teclado, los almacene en un array y muestre la media
    int[] tab = new int[10];
    int suma = 0;
    int media;
    int count = 0;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < tab.length; i++) {
      System.out.println("Ingrese un numero");
      tab[i] = sc.nextInt();
    }
    for (int indice : tab) {
      suma = suma + indice;
      count++;
    }
    media = suma / count;
    System.out.println("La media es " + media);
  }
}
