package a_sequences;

import java.util.Scanner;

public class e_areaTrapecio {
  public static void main(String[] args) {//Programa que calcula area de trapecio
    //A=b+B/2 *h
    int bMenor, bMayor, altura, area;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese la base menor");
    bMenor = sc.nextInt();
    System.out.println("Ingrese la base mayor");
    bMayor = sc.nextInt();
    System.out.println("Ingrese la base altura");
    altura = sc.nextInt();

    area = ((bMenor + bMayor) / 2) * altura;
    System.out.println("El area del trapecio es " + area);

  }
}
