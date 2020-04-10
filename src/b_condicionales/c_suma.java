package b_condicionales;

import java.util.Scanner;

public class c_suma {
  public static void main(String[] args) {
  /*Mostrar el resultado de una suma de 2 numeros y si esta supera a 10*/
    int n1, n2,suma;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese sus 3 notas");

    n1 = sc.nextInt();
    n2 = sc.nextInt();


    suma = n1 + n2 ;
    if (suma > 10) {
      System.out.println("Enbuenahora!!");
    } else {
      System.out.println(" Vuelve a intentarlo");
    }

  }
}
