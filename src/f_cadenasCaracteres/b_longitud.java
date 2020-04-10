package f_cadenasCaracteres;

import java.util.Scanner;

public class b_longitud {
  public static void main(String[] args) {
    //calcular la longitud de 2 cadenas de caracteres y mostrar la cadena con mayor longitud

    String cadena1;
    String cadena2;

    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese la 1ra cadena");
    cadena1 = sc.nextLine();
    System.out.println("Ingrese la 2da cadena");
    cadena2 = sc.nextLine();

    if (cadena1.length() == cadena2.length()) {
      System.out.println("las 2 cadenas tienen la misma longitud");
    } else if (cadena1.length() > cadena2.length()) {
      System.out.println("la cadena mas grande es la 1ra " + cadena1);
    } else {
      System.out.println("la cadena mas grande es la 2da " + cadena2);
    }
  }
}
