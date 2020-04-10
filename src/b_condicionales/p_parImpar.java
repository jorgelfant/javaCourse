package b_condicionales;

import java.util.Scanner;

public class p_parImpar {
  public static void main(String[] args) {
    //Programa que pida 2 numeros y diga si ambos son pares o impares
    int n1, n2;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese el primer numero");
    n1 = sc.nextInt();
    System.out.println("Ingrese el primer numero");
    n2 = sc.nextInt();
/*
    if (n1 % 2 == 0) {
      if (n2 % 2 == 0) {
        System.out.println(n1 + " y " + n2 + " son pares");
      } else {
        System.out.println(n1 + " es par y " + n2 + " es impar");
      }
    } else if (n1 % 2 != 0) {
      if (n2 % 2 != 0) {
        System.out.println(n1 + " y " + n2 + " son impares");
      } else {
        System.out.println(n2 + " es par y " + n1 + " es impar");
      }
    }
    OU
    */
    if (n1 % 2 == 0 && n2 % 2 == 0) {
      System.out.println(n1 + " y " + n2 + " son pares");
    }
    else if (n1 % 2 == 0 ) {
      System.out.println(n1 + " es par y " + n2 + " es impar");
    }
    else if (n2 % 2 == 0 ){
      System.out.println(n2 + " es par " + n1 + " es impar");
    }
    else{
      System.out.println(n1 + " y " + n2 + " son impares");
    }
  }
}
