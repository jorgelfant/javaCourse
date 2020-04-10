package a_sequences;

import java.util.Scanner;

public class d_longCircun {
  public static void main(String[] args) {//Programa que calcule la longitud de una circunferencia
    //formula  L= 2 * pi * r
    int radio;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el radio para calcular la longitud de la circunferencia");

    radio = sc.nextInt();
    int longitud = (int) (2 * Math.PI * radio);//pi es double

    System.out.println("La longitud de la circunferencia es " + longitud);
  }
}
