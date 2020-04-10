package d_funciones.l_valorAbsoluto;

import java.util.Scanner;

public class ValorAbsol {
  public static void main(String[] args) {//valor absoluto de un numero
    int numero;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese un numero");
    numero = sc.nextInt();

    System.out.println("El valor absoluto de " + numero + " es " + absoluto(numero));
  }

  private static int absoluto(int numero) {
    if (numero >= 0) {
      return numero;
    } else {
      return numero * -1;
    }
  }
}
