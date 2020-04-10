package a_sequences;

import java.util.Scanner;

public class k_mediaG {
  public static void main(String[] args) {//Programa que de la media geometrica de 3 numeros
    double n1, n2, n3, mediaG;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese los 3 numeros");
    n1 = sc.nextDouble();
    n2 = sc.nextDouble();
    n3 = sc.nextDouble();

    mediaG = Math.sqrt(n1 * n2 * n3);

    System.out.println("La media geometrica es " + mediaG);
  }
}
