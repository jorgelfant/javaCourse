package d_funciones.j_ParImpar;

import java.util.Scanner;

public class ParImpar {
  public static void main(String[] args) {
    //Par o impar
    int numero;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese un numero");
    numero = sc.nextInt();

    System.out.println("El numero es " + parImpar(numero));
  }

  //FUNCION
  private static String parImpar(int numero) {
    if (numero % 2 == 0) {
      return "par";
    } else {
      return "impar";
    }
  }

}
