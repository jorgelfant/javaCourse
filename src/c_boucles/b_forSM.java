package c_boucles;

import java.util.Scanner;

public class b_forSM {
  public static void main(String[] args) {
    //Digitar un numero, si el numero supera a 10 multiplique los 10 primeros numeros, sino sumelos
    int n;
    int mult = 1;
    int suma = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("digite un numero");
    n = sc.nextInt();
    if (n > 10) {
      for (int i = 1; i <= n; i++) {
        mult = mult * i;
      }
      System.out.println("la multiplicacion de los " + n + " numeros es " + mult);
    } else {
      for (int i = 1; i <= n; i++) {
        suma = suma + i;
      }
      System.out.println("la suma de los " + n + " numeros es " + suma);
    }
  }
}
