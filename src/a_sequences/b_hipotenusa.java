package a_sequences;

import java.util.Scanner;

public class b_hipotenusa {
  public static void main(String[] args) {
//Trouver hypothnuse de un triangulo rectangulo, pidiendo al usuario el valor de los 2 catetos PITAGORAS
    double cat1, cat2;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese los catetos");
    cat1 = sc.nextInt();
    cat2 = sc.nextInt();

    double hipo = Math.sqrt(Math.pow(cat1,2)+Math.pow(cat2,2));

    System.out.println("La hipotenusa del triangulo rectangulo es: " + hipo);
  }
}
