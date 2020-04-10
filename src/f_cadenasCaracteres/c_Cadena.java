package f_cadenasCaracteres;

import java.util.Scanner;

public class c_Cadena {
  public static void main(String[] args) {
    //disenar un algoritmo cuya entrada sea una cadena, y un numero entero N, cuya funcion sea generar la cadena cada
    //n veces

    String cadena;
    int n = 5;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingresar una cadena");
    cadena = sc.nextLine();
    System.out.println("Ingresar un numero");
    n = sc.nextInt();

    while (n <= 0) {//pa asegurarse que el numero sea positivo, el while debe poder cambiar dentro
      System.out.println("Ingresar un numero que sea mayor que 0");
      n = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      System.out.print(cadena + " ");
    }

  }
}
